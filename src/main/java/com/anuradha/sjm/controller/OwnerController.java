package com.anuradha.sjm.controller;

import com.anuradha.sjm.InvalidInputException;
import com.anuradha.sjm.dto.OwnerDTO;
import com.anuradha.sjm.service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/owner")
@RequiredArgsConstructor
public class OwnerController {

    private final OwnerService ownerService;

    @GetMapping("/all")
    public ResponseEntity<?> getOwners() {
        return new ResponseEntity<>(ownerService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createOwner(@RequestBody OwnerDTO ownerDTO) throws InvalidInputException {
        ownerService.createOwner(ownerDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getOwner(@PathVariable Long id) {
        return new ResponseEntity<>(ownerService.getOwnerById(id), HttpStatus.OK);
    }
}
