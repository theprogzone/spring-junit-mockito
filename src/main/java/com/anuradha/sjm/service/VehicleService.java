package com.anuradha.sjm.service;

import com.anuradha.sjm.InvalidInputException;
import com.anuradha.sjm.dto.VehicleDTO;

import java.util.List;

public interface VehicleService {

    List<VehicleDTO> getAll();

    void createVehicle(VehicleDTO vehicleDTO) throws InvalidInputException;

    VehicleDTO getVehicleById(Long id);
}
