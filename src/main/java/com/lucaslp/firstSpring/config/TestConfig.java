package com.lucaslp.firstSpring.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.lucaslp.firstSpring.entities.User;
import com.lucaslp.firstSpring.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	// essa classe vai fazer o database seeding, (popular o banco de dados!)

	// autoWired vai fazer o papel de injeção de dependencia nesse caso, como
	// estamos ,lidando com um framework fica mais simplicado o caso de injeção de
	// dependencia também, então apenas colocamos a notação de autoWired que o
	// compilador vaai reconhcer a Injeção de dependencia do UserRepository, que é a
	// classe que tem o SpringDATA jpa
	// Para fazer as operações com o banco de dados com a entidade que esta
	// associada a esta classe, que nesse caso, é o USER!

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {

		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		User u3 = new User (null, "Lucas LP", "LP.SKT@GMAIL.COM", "3516248", "SEGREDO");

		userRepository.saveAll(Arrays.asList(u1, u2, u3));
	}

}
