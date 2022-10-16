package com.anuradha.sjm.service;

import com.anuradha.sjm.InvalidInputException;
import com.anuradha.sjm.dto.OwnerDTO;

import java.util.List;

public interface OwnerService {

    List<OwnerDTO> getAll();

    void createOwner(OwnerDTO ownerDTO) throws InvalidInputException;

    OwnerDTO getOwnerById(Long id);
}
