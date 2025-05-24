package com.lucaslp.firstSpring.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lucaslp.firstSpring.entities.User;
import com.lucaslp.firstSpring.services.UserService;

@RestController
@RequestMapping(value = "/users") //caminho do recurso (ENDPOINT...) DIGITAMOS no localhost ou no servidor que esta e ele retorna a requisição de tudo que tem a partir desta classe...
public class UserResource {

	@Autowired
	private UserService service; //service agora está fazendo o meio de campo entre minha aplicação, e o banco de dados, isso deixa o programa com uma melhor pratica, em muitos sentidos, usei isso no programa da petshop, porém agora é em um copntexto de um framework aplicado!
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		//controlador Rest que responde no caminho users
		
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}") //ENDPOINT adicional ao request mapping, ao adicionar uma / + um id de da entidade estaremos buscando um usuario em especico e não todos!
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping 
	public ResponseEntity<User> insert(@RequestBody User obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
			service.delete(id);
			return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
	
	
}
