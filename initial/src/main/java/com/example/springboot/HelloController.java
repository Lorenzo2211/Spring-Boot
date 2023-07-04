package com.example.springboot;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class HelloController {
	@GetMapping(value = "/hello")
	public ResponseEntity<String> ex1() {
		return ResponseEntity.ok("Hello World!");
	}

	@GetMapping(value = "/greeting")
	public ResponseEntity<String> ex2() {
		return ResponseEntity.ok("Good Afternoon!");
	}

	@GetMapping(value = "/info")
	public ResponseEntity<String> ex3() {
		return ResponseEntity.status(200).body("OK");
	}

	@GetMapping(value = "/random")
	public ResponseEntity<String> ex5 () {
		if (new Random().nextBoolean()){
			return ResponseEntity.status(200).body("OK");
		}
		return ResponseEntity.badRequest().body("It's not OK!");
	}
}

