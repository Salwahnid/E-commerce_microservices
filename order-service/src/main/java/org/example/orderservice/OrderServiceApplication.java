package org.example.orderservice;

import org.example.orderservice.entities.Order;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
		Order order = new Order ();
		order.setStatus("Pending");
		order.setShippingAddress("Morocco");

		System.out.println(order);
	}

}
