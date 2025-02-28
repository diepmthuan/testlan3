package poly.edu.controller;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import poly.edu.service.Mail_1Service;

@Controller
public class EmailCoFormController {
	@Autowired
	Mail_1Service mailService;
	@GetMapping("/form/form_email")
	public String sendEmail(Model model) {
		model.addAttribute("from", "diepmthuan23042003@gmail.com");
		return"MailForm";
	}
	@PostMapping("/form/sendEmail")
	public String sendEmail(Model model, 
	        @RequestParam("to") String to,
	        @RequestParam("cc") String cc,
	        @RequestParam("bcc") String bcc,
	        @RequestParam("subject") String subject,
	        @RequestParam("body") String body,
	        @RequestParam("action") String action) {

	    if ("sendEmail1".equals(action)) {
	        mailService.send(to, cc, bcc, subject, body);
	        model.addAttribute("message", "Gửi email thành công!");
	    } else if ("sendEmail2".equals(action)) {
	        mailService.push(to, cc, bcc, subject, body);
	        model.addAttribute("message", "Gửi email thành công vui lòng chờ 10s");
	    }

	    return "MailForm";
	}
	
}
