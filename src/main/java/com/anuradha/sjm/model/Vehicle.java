package com.anuradha.sjm.model;

import javax.persistence.*;

@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String registrationNo;
    private String vehicleClass;
    private String fuel;
    private String maker;
    private Integer year;
    @ManyToOne
    private Owner owner;
}
