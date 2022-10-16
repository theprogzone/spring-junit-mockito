package com.anuradha.sjm.controller;

import com.anuradha.sjm.InvalidInputException;
import com.anuradha.sjm.dto.ServiceDTO;
import com.anuradha.sjm.service.RepairService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/service")
@RequiredArgsConstructor
public class ServiceController {

    private final RepairService repairService;

    @GetMapping("/all")
    public ResponseEntity<?> getServices() {
        return new ResponseEntity<>(repairService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createService(@RequestBody ServiceDTO serviceDTO) throws InvalidInputException {
        repairService.createService(serviceDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getService(@PathVariable Long id) {
        return new ResponseEntity<>(repairService.getServiceById(id), HttpStatus.OK);
    }
}
