package poly.edu.service;

import lombok.Builder;
import lombok.Data;
import lombok.Builder.Default;
import poly.edu.service.MailService.Mail;

public interface Mail_1Service {
	@Data
	@Builder
	public static class Mail{
		  	@Default
	        private String from = "Thuận <diepmthuan23042003@gmail.com>";
	        private String to;
	        @Default
	        private String cc = "";
	        @Default
	        private String bcc = "";
	        private String subject;
	        private String body;
	        @Default
	        private String filenames = "";
	}
	void send(Mail mail);
	default void send(String to,String cc,String bcc, String subject, String body) {
		Mail mail = Mail.builder()
			    .to(to)
			    .cc(cc)
			    .bcc(bcc)
			    .subject(subject)
			    .body(body)
			    .build();
				
	this.send(mail);
	}
	void push(Mail mail);
	default void push(String to,String cc,String bcc, String subject, String body){
	this.push(Mail.builder().to(to).cc(cc).bcc(bcc).subject(subject).body(body).build());
	}
}
