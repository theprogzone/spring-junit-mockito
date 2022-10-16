package com.anuradha.sjm.service.impl;

import com.anuradha.sjm.InvalidInputException;
import com.anuradha.sjm.dto.VehicleDTO;
import com.anuradha.sjm.model.Owner;
import com.anuradha.sjm.model.Vehicle;
import com.anuradha.sjm.repository.OwnerRepository;
import com.anuradha.sjm.repository.VehicleRepository;
import com.anuradha.sjm.service.VehicleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;
    private final OwnerRepository ownerRepository;

    @Override
    public List<VehicleDTO> getAll() {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        log.info("Vehicle count ==> {}", vehicles.size());
        return VehicleDTO.valueOf(vehicles);
    }

    @Override
    public void createVehicle(VehicleDTO vehicleDTO) throws InvalidInputException {
        log.info("Vehicle details ==> {}", vehicleDTO);
        if (vehicleDTO == null || vehicleDTO.getOwner() == null || vehicleDTO.getOwner().getId() == null) {
            throw new InvalidInputException("Invalid vehicle details");
        }
        Optional<Owner> owner = ownerRepository.findById(vehicleDTO.getOwner().getId());
        if (owner.isPresent()) {
            Vehicle vehicle = Vehicle.valueOf(vehicleDTO);
            vehicle.setOwner(owner.get());
            vehicleRepository.save(vehicle);
        } else {
            throw new InvalidInputException("Invalid owner id");
        }
    }

    @Override
    public VehicleDTO getVehicleById(Long id) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(id);
        if (vehicle.isPresent()) {
            VehicleDTO vehicleDTO = VehicleDTO.valueOf(vehicle.get());
            log.info("Vehicle details ==> {}", vehicleDTO);
            return vehicleDTO;
        }
        return new VehicleDTO();
    }
}
