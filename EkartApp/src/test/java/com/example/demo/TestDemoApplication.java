package com.example.demo;

import org.springframework.boot.SpringApplication;

import com.ekart.DemoApplication;

public class TestDemoApplication {

	public static void main(String[] args) {
		SpringApplication.from(DemoApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
