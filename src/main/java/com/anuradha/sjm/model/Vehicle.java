package com.anuradha.sjm.model;

import com.anuradha.sjm.dto.VehicleDTO;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

@Entity
@Data
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String registrationNo;
    private String vehicleClass;
    private String fuel;
    private String maker;
    private Integer productionYear;
    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private Owner owner;

    public static Vehicle valueOf(VehicleDTO vehicleDTO) {
        Vehicle vehicle = new Vehicle();
        BeanUtils.copyProperties(vehicleDTO, vehicle);
        return vehicle;
    }
}
