package com.anuradha.sjm.dto;

import lombok.Data;

@Data
public class VehicleDTO {
    private Long id;
    private String registrationNo;
    private String vehicleClass;
    private String fuel;
    private String maker;
    private Integer year;
    private OwnerDTO owner;
}
