package com.anuradha.sjm.service;

import com.anuradha.sjm.dto.VehicleDTO;

import java.util.List;

public interface VehicleService {

    List<VehicleDTO> getAll();

    void createService(VehicleDTO vehicleDTO);

    VehicleDTO getServiceById(Long id);
}
