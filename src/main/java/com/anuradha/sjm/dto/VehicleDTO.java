package com.anuradha.sjm.dto;

import com.anuradha.sjm.model.Vehicle;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class VehicleDTO {
    private Long id;
    private String registrationNo;
    private String vehicleClass;
    private String fuel;
    private String maker;
    private Integer year;
    private OwnerDTO owner;

    public static VehicleDTO valueOf(Vehicle vehicle) {
        VehicleDTO vehicleDTO = new VehicleDTO();
        BeanUtils.copyProperties(vehicle, vehicleDTO);
        return vehicleDTO;
    }

    public static List<VehicleDTO> valueOf(List<Vehicle> vehicles) {
        return vehicles.stream().map(VehicleDTO::valueOf).collect(Collectors.toList());
    }
}
