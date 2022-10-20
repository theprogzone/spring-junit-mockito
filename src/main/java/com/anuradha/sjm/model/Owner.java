package com.anuradha.sjm.model;

import com.anuradha.sjm.dto.OwnerDTO;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String mobile;
    private String email;
    private String address;

    public static Owner valueOf(OwnerDTO ownerDTO) {
        Owner owner = new Owner();
        BeanUtils.copyProperties(ownerDTO, owner);
        return owner;
    }
}
