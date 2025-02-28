package poly.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import poly.edu.entity.AccountEntity;
import poly.edu.service.AccountService;

@Controller
public class AuthController {
	@Autowired  
	AccountService accountService;

	@Autowired
	HttpSession session;
	@GetMapping("/auth/login")
	public String loginForm(Model model) {
		model.addAttribute("message",session.getAttribute("errorMessage"));
		AccountEntity user= (AccountEntity) session.getAttribute("user");
		if(user != null) {
			model.addAttribute("message",session.getAttribute("messThanhCong"));
		}
		session.removeAttribute("errorMessage"); // Xóa sau khi hiển thị
        return "login";
	}
	@GetMapping("/account/edit-profile")
	public String loginSuaTt(Model model) {
		
		return "TrangSuaThongTin";
	}
	@GetMapping("/account/change-password")
	public String loginDoiMK(Model model) {
		return "TrangDoiMatKhau";
	}
	@GetMapping("/order/**")
	public String loginOder(Model model) {
		return "TrangOrder";
	}
	@PostMapping("/auth/login")
	public String loginProcess(Model model,
		@RequestParam("username") String username,
		@RequestParam("password") String password) {
		
		AccountEntity user = accountService.findByUsername(username);
		if(user == null) {
			model.addAttribute("message","Sai username");
		}else if(!user.getPassword().equals(password)){
			model.addAttribute("message","Sai mật khẩu");
		}
		else{
			session.setAttribute("user", user);
			
	        // Kiểm tra xem có securityUri lưu trước đó không
	        String securityUri = (String) session.getAttribute("securityUri");
//	        System.out.println(securityUri);
	        if (securityUri != null) {
	            session.removeAttribute("securityUri"); // Xóa sau khi sử dụng
	            return "redirect:" + securityUri;
	        }
	        session.setAttribute("messThanhCong","Đăng nhập thành công");
	        return "redirect:/auth/login";
		}
		return "login";
	}
	@GetMapping("/delete/session")
	public String xoaSession(Model model) {
		model.addAttribute("message","Thoát session thành công");
		session.removeAttribute("user");
		return "login";
	}
}
