package com.lucaslp.firstSpring.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table; 
// a partir do Spring Boot 3 Começou a se usar o Jakarta, e não mais o  javax.persistence!

@Entity
@Table(name = "tb_user")
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;	//Comum para trafegar entre redes o serializable! 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //autoincremento do id no banco de dados
	private Long id;
	private String name;
	private String email;
	private String fone;
	private String password;
	
	//quando temos duas associações e a gente mapeia elas pelo JPA no nosso programa, nós temos que colocar uma notação de JsonIgnore em um dos lados dessa associação para não entrar em um loop infinito o programa quando for chamar a requisição! nesse caso optei por colocar aqui no cliente, pois a chave estrangeira fica na parte da Order, aqui a associação fica mais opcional, então fica mais criterio meu colocar essa notação nessa classe!
	
	@JsonIgnore 
	@OneToMany(mappedBy = "client")
	private List<Order> orders = new ArrayList<>();
	
	public User() {} //No uso de Framework é obrigatorio o uso de construtores vazios!

	public User(Long id, String name, String email, String fone, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.fone = fone;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<Order> getOrders() {
		return orders;
	}
	
	//hashcode apenas do ID nesse caso aqui do projeto!

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}



	
}
