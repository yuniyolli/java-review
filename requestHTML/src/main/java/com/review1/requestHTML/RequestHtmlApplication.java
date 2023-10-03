package com.review1.requestHTML;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class RequestHtmlApplication {

	public static void main(String[] args) {
		// spring에 등록된 bean 객체를 확인하는 메소드 및 로직
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(RequestHtmlApplication.class);
		for (String beanName : applicationContext.getBeanDefinitionNames()) {
			System.out.println(beanName);
		}

		// Spring 실행 메소드
		//SpringApplication.run(RequestHtmlApplication.class, args);
	}

}
