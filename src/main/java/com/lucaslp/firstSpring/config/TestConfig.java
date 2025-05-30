package com.lucaslp.firstSpring.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.lucaslp.firstSpring.entities.Category;
import com.lucaslp.firstSpring.entities.Order;
import com.lucaslp.firstSpring.entities.OrderItem;
import com.lucaslp.firstSpring.entities.Payment;
import com.lucaslp.firstSpring.entities.Product;
import com.lucaslp.firstSpring.entities.User;
import com.lucaslp.firstSpring.entities.enums.OrderStatus;
import com.lucaslp.firstSpring.repositories.CategoryRepository;
import com.lucaslp.firstSpring.repositories.OrderItemRepository;
import com.lucaslp.firstSpring.repositories.OrderRepository;
import com.lucaslp.firstSpring.repositories.ProductRepository;
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
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Electronics"); 
		Category cat2 = new Category(null, "Books"); 
		Category cat3 = new Category(null, "Computers"); 
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, ""); 
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, ""); 
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, ""); 
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, ""); 
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, ""); 
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		User u3 = new User (null, "Lucas LP", "LP.SKT@GMAIL.COM", "3516248", "SEGREDO");

		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID,u1); 
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"),OrderStatus.WAITING_PAYMENT,  u2); 
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"),OrderStatus.SHIPPED,  u1);
		
		userRepository.saveAll(Arrays.asList(u1, u2, u3));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice()); 
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice()); 
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice()); 
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
		
		//instanciando um  orderItem que é... Order 1, do P1 (PRODUTO 1), quantidade 2, e pegando o preço do produto!
		
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
		
		Payment pay1 = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"), o1);
		o1.setPayment(pay1);
		//jpa faz assim com as relações dependentes...
		
		//salva o o1 com o metodo de pagamento inserido no banco de dados!
		orderRepository.save(o1);
		
	}

}
