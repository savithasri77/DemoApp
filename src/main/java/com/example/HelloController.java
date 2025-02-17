package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@GetMapping("/")
	public String getHello()
	{
		return "Hello!!! V2";
	}
	
	@GetMapping("/city")
	public String getCity()
	{
		return "Bengaluru";
	}
	
}
