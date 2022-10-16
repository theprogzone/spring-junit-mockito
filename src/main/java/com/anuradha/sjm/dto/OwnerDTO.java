package com.anuradha.sjm.dto;

import com.anuradha.sjm.model.Owner;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class OwnerDTO {
    private Long id;
    private String name;
    private String mobile;
    private String email;
    private String address;

    public static OwnerDTO valueOf(Owner owner) {
        OwnerDTO ownerDTO = new OwnerDTO();
        BeanUtils.copyProperties(owner,ownerDTO);
        return ownerDTO;
    }

    public static List<OwnerDTO> valueOf(List<Owner> owners) {
        return owners.stream().map(OwnerDTO::valueOf).collect(Collectors.toList());
    }
}
