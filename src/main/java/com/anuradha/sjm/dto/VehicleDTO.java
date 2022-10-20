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
    private Integer productionYear;
    private OwnerDTO owner;

    public static VehicleDTO valueOf(Vehicle vehicle) {
        VehicleDTO vehicleDTO = new VehicleDTO();
        OwnerDTO ownerDTO = new OwnerDTO();
        if (vehicle.getOwner() != null) {
            ownerDTO = OwnerDTO.valueOf(vehicle.getOwner());
        }
        BeanUtils.copyProperties(vehicle, vehicleDTO);
        vehicleDTO.setOwner(ownerDTO);
        return vehicleDTO;
    }

    public static List<VehicleDTO> valueOf(List<Vehicle> vehicles) {
        return vehicles.stream().map(VehicleDTO::valueOf).collect(Collectors.toList());
    }
}
