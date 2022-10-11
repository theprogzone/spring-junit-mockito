package com.anuradha.sjm.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ServiceDTO {
    private Long id;
    private Integer mileage;
    private String description;
    private BigDecimal totalAmount;
    private VehicleDTO vehicle;
    private List<ServiceItemDTO> serviceItems;
}
