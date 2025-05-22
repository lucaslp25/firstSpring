package com.lucaslp.firstSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucaslp.firstSpring.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{ //SpringData JPA
	
	//interface userRepository que estende outra interface JpaRepository que é um subFramework do ecossistema Spring e faz as minhas operações CRUDS automaticamente com essa implementação, e passa como parametros a classe que tu vai colocar como repositorio, e o tipo de dado do ID da classe!
	
	
	
	
	
	
	
	
	
	
	
	

}
