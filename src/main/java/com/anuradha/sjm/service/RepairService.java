package com.anuradha.sjm.service;

import com.anuradha.sjm.dto.ServiceDTO;

import java.util.List;

public interface RepairService {

    List<ServiceDTO> getAll();

    void createService(ServiceDTO serviceDTO);

    ServiceDTO getServiceById(Long id);
}
