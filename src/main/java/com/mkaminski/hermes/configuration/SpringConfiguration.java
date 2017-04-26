package com.mkaminski.hermes.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.mkaminski.hermes.scheduler.SchedulerService;

@Configuration
@ComponentScan(basePackages = "com.mkaminski.hermes")
@EnableWebMvc
@EnableTransactionManagement
@EnableScheduling
@EnableAsync

public class SpringConfiguration extends WebMvcConfigurerAdapter {

	
	@Bean(name = "multipartResolver")
    public CommonsMultipartResolver multipartResolve() {
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();    
        return commonsMultipartResolver;
    }
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}	

	  @Bean
	    public InternalResourceViewResolver viewResolver() {
	        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	        viewResolver.setViewClass(JstlView.class);
	        viewResolver.setPrefix("/WEB-INF/");
	        viewResolver.setSuffix(".jsp");
	        return viewResolver;
	    }

	@Bean
	public SchedulerService getAdvService() {
		return new SchedulerService();
	}

	@Bean
	public JavaMailSender javaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);
		mailSender.setUsername("hermes.delivery.noreply@gmail.com");
		mailSender.setPassword("HermesDelivery1");
		mailSender.getJavaMailProperties().setProperty("mail.smtp.auth", "true");
		mailSender.getJavaMailProperties().setProperty("mail.smtp.starttls.enable", "true");
		return mailSender;
	}	
	
	
	
}
