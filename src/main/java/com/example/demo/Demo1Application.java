package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class Demo1Application implements CommandLineRunner {
	@Autowired
	CustomerInfoRepository customerInfoRepository;
	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
//		customerInfoRepository.save(new CustomerInfoModel("1234500953","youssef",0));
//		customerInfoRepository.save(new CustomerInfoModel("1204920385","amr",0));
//		customerInfoRepository.save(new CustomerInfoModel("1254048685","adham",1));
//		customerInfoRepository.save(new CustomerInfoModel("1204762055","aya",2));
	}
}
