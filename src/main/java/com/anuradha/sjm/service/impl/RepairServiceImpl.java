package com.anuradha.sjm.service.impl;

import com.anuradha.sjm.InvalidInputException;
import com.anuradha.sjm.dto.ServiceDTO;
import com.anuradha.sjm.model.ServiceItem;
import com.anuradha.sjm.model.Vehicle;
import com.anuradha.sjm.repository.ServiceItemRepository;
import com.anuradha.sjm.repository.ServiceRepository;
import com.anuradha.sjm.repository.VehicleRepository;
import com.anuradha.sjm.service.RepairService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class RepairServiceImpl implements RepairService {

    private final ServiceRepository serviceRepository;
    private final VehicleRepository vehicleRepository;
    private final ServiceItemRepository serviceItemRepository;

    @Override
    public List<ServiceDTO> getAll() {
        List<com.anuradha.sjm.model.Service> services = serviceRepository.findAll();
        log.info("All services count ==> {}", services.size());
        return ServiceDTO.valueOf(services);
    }

    @Override
    public void createService(ServiceDTO serviceDTO) throws InvalidInputException {
        log.info("Service details => {}", serviceDTO);
        if (serviceDTO == null || serviceDTO.getVehicle() == null || serviceDTO.getVehicle().getId() == null) {
            throw new InvalidInputException("Invalid service details");
        }
        Optional<Vehicle> vehicle = vehicleRepository.findById(serviceDTO.getVehicle().getId());
        List<ServiceItem> serviceItems = new ArrayList<>();
        List<ServiceItem> serviceItemsUpdated = new ArrayList<>();
        if (serviceDTO.getServiceItems() != null) {
            serviceItems = ServiceItem.valueOf(serviceDTO.getServiceItems());
        }
        com.anuradha.sjm.model.Service service = com.anuradha.sjm.model.Service.valueOf(serviceDTO);
        if (vehicle.isPresent()) {
            service.setVehicle(vehicle.get());
        } else {
            throw new InvalidInputException("Invalid vehicle id");
        }
        service = serviceRepository.save(service);
        for (ServiceItem serviceItem : serviceItems) {
            if (serviceItem != null) {
                serviceItem.setService(service);
                serviceItemsUpdated.add(serviceItem);
            }
        }
        serviceItemRepository.saveAll(serviceItemsUpdated);
    }

    @Override
    public ServiceDTO getServiceById(Long id) {
        Optional<com.anuradha.sjm.model.Service> service = serviceRepository.findById(id);
        if (service.isPresent()) {
            ServiceDTO serviceDTO = ServiceDTO.valueOf(service.get());
            log.info("Service details => {}", serviceDTO);
            return serviceDTO;
        }
        return new ServiceDTO();
    }
}
