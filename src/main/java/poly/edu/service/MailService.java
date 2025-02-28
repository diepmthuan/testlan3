package poly.edu.service;

import org.springframework.scheduling.annotation.EnableScheduling; 

import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;


public interface MailService {
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
	default void send(String to, String subject, String body) {
		Mail mail = Mail.builder()
			   // Cần khớp với email cấu hình SMTP
			    .to(to)
			    .subject(subject)
			    .body(body)
			    .build();
	this.send(mail);
	}
	void push(Mail mail);
	default void push(String to, String subject, String body){
	this.push(Mail.builder().to(to).subject(subject).body(body).build());
	}
}
