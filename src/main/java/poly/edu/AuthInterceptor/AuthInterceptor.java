package poly.edu.AuthInterceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import poly.edu.dao.AccountDAO;
import poly.edu.entity.AccountEntity;
@Component
public class AuthInterceptor implements HandlerInterceptor{
	@Autowired
	HttpSession session;
	@Override
	public boolean preHandle(HttpServletRequest req ,
			HttpServletResponse resp,Object handler) throws Exception {
			String uri = req.getRequestURI();
			AccountEntity user = (AccountEntity) session.getAttribute("user");
			if (user == null) {
			    session.setAttribute("errorMessage", "Bạn cần đăng nhập để truy cập trang này!");
	            session.setAttribute("securityUri", uri);
	            resp.sendRedirect("/auth/login");
			    return false;
			}

			if (uri.startsWith("/admin") && !user.isAdmin()) {
			    session.setAttribute("errorMessage", "Bạn không có quyền truy cập khu vực admin!");
			    session.setAttribute("securityUri", uri);
			    resp.sendRedirect("/auth/login");
			    return false;
			}

			return true;
	}
}
