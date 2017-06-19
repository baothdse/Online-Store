package com.cos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.cos.config.JPAConfiguration;

@Import(JPAConfiguration.class)
@SpringBootApplication(scanBasePackages = {"com.cos"})
public class COSMain {
	public static void main(String[] args) {
		SpringApplication.run(COSMain.class, args);
	}
}
