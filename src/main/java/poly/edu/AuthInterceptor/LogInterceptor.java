package poly.edu.AuthInterceptor;

import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import poly.edu.entity.AccountEntity;
@Component
public class LogInterceptor implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest request,
	                         HttpServletResponse response, Object handler) throws Exception {
	    AccountEntity user = (AccountEntity) request.getSession().getAttribute("user");
	    
	    System.out.print(request.getRequestURI() + ", " + new Date());
	    
	    if (user != null) {
	        System.out.println(", " + user.getFullname());
	    } else {
	        System.out.println(", User is null");
	    }
	    
	    return true;
	}

}
