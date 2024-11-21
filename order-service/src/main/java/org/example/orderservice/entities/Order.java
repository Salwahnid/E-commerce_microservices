package org.example.orderservice.entities;

import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
@Data  // Lombok annotation to generate getters, setters, toString, equals, and hashCode methods
@NoArgsConstructor  // Lombok annotation to generate a no-argument constructor
@AllArgsConstructor // Lombok annotation to generate a constructor with all fields
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customerId", nullable = false)
    private Long customerId;

    @Column(name = "orderDate", nullable = false)
    private Date orderDate;

    @Column(name = "quatity", nullable = false)
    private int  quatity;

    @Column(name = "totalAmount", nullable = false)
    private Double totalAmount;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "shippingAddress")
    private String shippingAddress;

    @ElementCollection
    @CollectionTable(name = "order_product_codes", joinColumns = @JoinColumn(name = "order_id"))
    @Column(name = "product_code")
    private List<String> productCodes;



}
