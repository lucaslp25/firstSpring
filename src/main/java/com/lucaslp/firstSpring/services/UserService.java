package com.lucaslp.firstSpring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucaslp.firstSpring.entities.User;
import com.lucaslp.firstSpring.repositories.UserRepository;

@Service  // definindo como um serviço (registrando como um componente)
public class UserService {
	
	@Autowired //injeção de dependência
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}

	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
	
}
