package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SbH2Project1Application {

	@Autowired
	private StudentRepo studentRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(SbH2Project1Application.class, args);
		System.out.println("Application is running.......");
	}

	
	@GetMapping("/")
	public String welcome() {
		return "this is applications home page";
	}
	
	@GetMapping("/student/get-list")
	public List<Student> getList(){
		return studentRepo.findAll();
	}
	
	@PostMapping("/student/add")
	public Student saveStudent(@RequestBody Student student) {
		return studentRepo.save(student);
	}
}
