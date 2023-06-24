package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {
	private String name;
	private Integer age;

	public void init() {
		System.out.println("Initialization success.");
	}

	public void destroy() {
		System.out.println("Destroy success.");
	}
}
