package com.example.nix_spring1;

import com.example.nix_spring1.repository.entity.PhotoEntity;
import com.example.nix_spring1.repository.entity.StudentEntity;
import com.example.nix_spring1.service.PhotoService;
import com.example.nix_spring1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class DemoNixSpring1Application {
	@Autowired
	private StudentService studentService;
	@Autowired
	private PhotoService photoService;

	public static void main(String[] args) {
		SpringApplication.run(DemoNixSpring1Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			System.out.println("Let's inspect the beans provided by Spring Boot");
			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for(String beanName:beanNames){
				System.out.println(beanName);
			}
			studentService.createStudent("Anton", "antoha88@gmail.com");
			studentService.createStudent("Serhii", "sergo32@gmail.com");

			photoService.addPhotoToStudent("url1", "image1", 1);
			photoService.addPhotoToStudent("url2", "image2", 2);
			photoService.addPhotoToStudent("url3", "image3", 3);

			photoService.getPhotoByDescription("image2").forEach(System.out::println);



		};
	}
}
