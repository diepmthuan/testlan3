package poly.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.mail.MessagingException;
import poly.edu.service.MailService;
@Controller
public class SendMailController {
	@Autowired
	MailService mailService;
	
	@ResponseBody
	@RequestMapping("/mail/send")
	public String send() {
		mailService.send("thuandmps38008@gmail.com", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
		return "Mail của bạn đã được gửi đi";
		}
	@ResponseBody
	@RequestMapping("/mail/sendSche")
	public String send(Model model) {
	mailService.push("thuandmps38008@gmail.com", "thuận đpẹ traiii", "Đẹp trai kh bằng chai mặt");
	return "Mail của bạn đã được xếp vào hàng đợi";
	}
}

