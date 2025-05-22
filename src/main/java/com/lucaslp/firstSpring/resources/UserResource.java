package com.lucaslp.firstSpring.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucaslp.firstSpring.entities.User;
import com.lucaslp.firstSpring.services.UserService;

@RestController
@RequestMapping(value = "/users") //caminho do recurso
public class UserResource {

	@Autowired
	private UserService service; //service agora está fazendo o meio de campo entre minha aplicação, e o banco de dados, isso deixa o programa com uma melhor pratica, em muitos sentidos, usei isso no programa da petshop, porém agora é em um copntexto de um framework aplicado!
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		//controlador Rest que responde no caminho users
		
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
