package com.anuradha.sjm.service;

import com.anuradha.sjm.InvalidInputException;
import com.anuradha.sjm.dto.ServiceDTO;

import java.util.List;

public interface RepairService {

    List<ServiceDTO> getAll();

    void createService(ServiceDTO serviceDTO) throws InvalidInputException;

    ServiceDTO getServiceById(Long id);
}
