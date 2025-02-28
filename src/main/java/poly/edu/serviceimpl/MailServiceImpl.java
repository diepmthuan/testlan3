package poly.edu.serviceimpl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import jakarta.mail.internet.MimeMessage;
import poly.edu.service.MailService;

@Service
public class MailServiceImpl implements MailService {
    @Autowired
    JavaMailSender mailSender;

    List<Mail> queue = new ArrayList<>();
    @Override
    public void push(Mail mail){
    queue.add(mail);
    }
    @Scheduled(fixedDelay = 10000)
    public void run() {
    while(!queue.isEmpty()) {
    try {
    this.send(queue.remove(0));
    } catch (Exception e) {e.printStackTrace();
	    }
	    }
    }
    
    
    @Override
    public void send(Mail mail) {
        try {
            // 1. Tạo Mail
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");

            // 2. Ghi thông tin người gửi (phải trùng với tài khoản SMTP)
            helper.setFrom("diepmthuan23042003@gmail.com");
            helper.setReplyTo("diepmthuan23042003@gmail.com");

            // 3. Ghi thông tin người nhận
            helper.setTo(mail.getTo());
            if (isValidEmail(mail.getCc())) helper.setCc(mail.getCc());
            if (isValidEmail(mail.getBcc())) helper.setBcc(mail.getBcc());

            // 4. Ghi tiêu đề và nội dung
            helper.setSubject(mail.getSubject());
            helper.setText(mail.getBody(), true);

            // 5. Đính kèm file (kiểm tra tồn tại)
            if (!isNullOrEmpty(mail.getFilenames())) {
                for (String filename : mail.getFilenames().split("[,;]+")) {
                    File file = new File(filename.trim());
                    if (file.exists() && file.isFile()) {
                        helper.addAttachment(file.getName(), file);
                    }
                }
            }

            // 6. Gửi email
            mailSender.send(message);
            System.out.println("Email sent successfully!");

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Lỗi khi gửi email: " + e.getMessage(), e);
        }
    }

    private boolean isNullOrEmpty(String text) {
        return (text == null || text.trim().isEmpty());
    }

    private boolean isValidEmail(String email) {
        return !isNullOrEmpty(email) && email.contains("@");
    }
}