package com.anuradha.sjm.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer mileage;
    private String description;
    private BigDecimal totalAmount;
    @ManyToOne
    private Vehicle vehicle;
}
