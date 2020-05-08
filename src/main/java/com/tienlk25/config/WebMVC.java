package com.tienlk25.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // báo cho spring boot đây là một file cấu hình cho spring mvc
@EnableWebMvc // file cấu hình này dùng cho Webmvc
@ComponentScan(basePackages = { "com.tienlk25" }) // chỉ ra đường dẫn có controller
public class WebMVC implements WebMvcConfigurer {
	
	// classpath là src/main/resources
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(
//                "/webjars/**",
                "/img/**",
                "/css/**",
                "/js/**",
                "/files/**")
                .addResourceLocations(
//                        "classpath:/META-INF/resources/webjars/",
                        "classpath:/static/img/",
                        "classpath:/static/css/",
                        "classpath:/static/js/",
                        "file:F:/Project-TT/Web-motos/Web-Motor/upload/");
		
//		registry.addResourceHandler("/files/**").addResourceLocations("file:F:/Project-TT/Web-motos/Web-Motor/upload/"); 
	}
	
}
