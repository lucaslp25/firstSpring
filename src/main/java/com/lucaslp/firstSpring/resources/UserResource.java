package com.lucaslp.firstSpring.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucaslp.firstSpring.entities.User;

@RestController
@RequestMapping(value = "/users") //caminho do recurso
public class UserResource {

	@GetMapping
	public ResponseEntity<User> findAll(){
		//controlador Rest que responde no caminho users
		User user = new User(1L, "Lucas", "lp@gmail.com", "999999", "12345");
		return ResponseEntity.ok().body(user);
	}
	

}
