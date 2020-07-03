package com.spark.laboratory.config;

import com.spark.laboratory.controller.interceptor.LogcostInterceptor;
import com.spark.laboratory.controller.interceptor.MiniInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**")
		.addResourceLocations("classpath:/META-INF/resources/")
				.addResourceLocations("file:D:/001/resources/");
	}

	/**
	 * 注册到Spring 中
	 * @return s
	 */
	@Bean
	public MiniInterceptor miniInterceptor() {
		return new MiniInterceptor();
	}

	/**
	 * 注册拦截器
	 * @param registry r
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		registry.addInterceptor(new LogcostInterceptor())
				//添加需要验证登录用户操作权限的请求
				.addPathPatterns("/**")
				.addPathPatterns("/CastingWeb/index.html")
				//这里add为“/**”,下面的exclude才起作用，且不管controller层是否有匹配客户端请求，拦截器都起作用拦截
//                .addPathPatterns("/hello")
				//如果add为具体的匹配如“/hello”，下面的exclude不起作用,且controller层不匹配客户端请求时拦截器不起作用

				//排除不需要验证登录用户操作权限的请求
				.excludePathPatterns("/index.html")
				.excludePathPatterns("/index")
				.excludePathPatterns("/login")
				.excludePathPatterns("/regist")
				.excludePathPatterns("/static/**")
				.excludePathPatterns("/locale/**")
//				.excludePathPatterns("/CastingWeb/**")
				.excludePathPatterns("/build/**");
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {

		registry.addMapping("/**")
				.allowedOrigins("*")
				.allowCredentials(true)
				.allowedMethods("GET", "POST", "DELETE", "PUT")
				.maxAge(3600);

	}

}
