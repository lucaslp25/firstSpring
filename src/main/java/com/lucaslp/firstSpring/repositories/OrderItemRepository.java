package com.lucaslp.firstSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucaslp.firstSpring.entities.OrderItem;
import com.lucaslp.firstSpring.entities.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> { // SpringData JPA

}
