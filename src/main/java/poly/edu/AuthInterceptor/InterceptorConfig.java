package poly.edu.AuthInterceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class InterceptorConfig implements WebMvcConfigurer{
	@Autowired
	AuthInterceptor authInterceptor;
	@Autowired
	LogInterceptor logInterceptor;
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(authInterceptor)
		.addPathPatterns("/admin/**",
		"/account/change-password",
		"/account/edit-profile",
		"/order/**")
		.excludePathPatterns("/home/index");
		
		 registry.addInterceptor(logInterceptor)
         .addPathPatterns("/**"); // Ghi log tất cả request
	}
}
