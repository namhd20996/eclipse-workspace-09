package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.example.model.Order;
import com.example.model.Person;

@Configuration
public class HelloWordConfig {

	@Bean(name = "person", initMethod = "init", destroyMethod = "destroy")
	@Scope(value = "singleton")
	public Person person() {
		// Field person cần phải giống với field của Class Order để có thể mapping
		Person person = new Person("Hello Word 1", 2);
		return person;
	}

	@Bean("person2")
	public Person person2() {
		Person person = new Person("Hello Word 2", 2);
		return person;
	}

// Cách này được gọi là Inject do gán bean trực tiếp cho biến
//	@Bean
//	public Order order() {
//		return new Order(person2());
//	}

// Cách này là sử dụng Annotation @Autowired: tự động tìm bean và gán vào khi dùng person2 là name của Bean
	@Bean
//	@Autowired
//	@Qualifier("person2")
	
	public Order order(Person person2) {
		return new Order(person2);
	}

}
