package com.anuradha.sjm.service.impl;

import com.anuradha.sjm.InvalidInputException;
import com.anuradha.sjm.dto.OwnerDTO;
import com.anuradha.sjm.model.Owner;
import com.anuradha.sjm.repository.OwnerRepository;
import com.anuradha.sjm.service.OwnerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;

    @Override
    public List<OwnerDTO> getAll() {
        List<Owner> owners = ownerRepository.findAll();
        log.info("Vehicle owners count ==> {}", owners.size());
        return OwnerDTO.valueOf(owners);
    }

    @Override
    public void createOwner(OwnerDTO ownerDTO) throws InvalidInputException {
        log.info("vehicle owner ==> {}", ownerDTO);
        if (ownerDTO == null) {
            throw new InvalidInputException("Data cannot be null");
        }
        ownerRepository.save(Owner.valueOf(ownerDTO));
    }

    @Override
    public OwnerDTO getOwnerById(Long id) {
        Optional<Owner> optionalOwner = ownerRepository.findById(id);
        if (optionalOwner.isPresent()) {
            log.info("vehicle owner ==> {}", optionalOwner.get());
            return OwnerDTO.valueOf(optionalOwner.get());
        }
        return new OwnerDTO();
    }
}
