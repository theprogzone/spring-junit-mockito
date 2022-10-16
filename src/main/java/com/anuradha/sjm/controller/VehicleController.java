package com.anuradha.sjm.controller;

import com.anuradha.sjm.InvalidInputException;
import com.anuradha.sjm.dto.VehicleDTO;
import com.anuradha.sjm.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/vehicle")
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;

    @GetMapping("/all")
    public ResponseEntity<?> getVehicles() {
        return new ResponseEntity<>(vehicleService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createVehicle(@RequestBody VehicleDTO vehicleDTO) throws InvalidInputException {
        vehicleService.createVehicle(vehicleDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getVehicle(@PathVariable Long id) {
        return new ResponseEntity<>(vehicleService.getVehicleById(id), HttpStatus.OK);
    }
}
