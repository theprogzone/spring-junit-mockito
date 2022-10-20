package com.anuradha.sjm.model;

import com.anuradha.sjm.dto.ServiceItemDTO;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Data
public class ServiceItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private BigDecimal cost;
    @ManyToOne
    @JoinColumn(name = "service_id", referencedColumnName = "id")
    private Service service;

    public static ServiceItem valueOf(ServiceItemDTO serviceItemDTO) {
        ServiceItem serviceItem = new ServiceItem();
        BeanUtils.copyProperties(serviceItemDTO, serviceItem);
        return serviceItem;
    }

    public static List<ServiceItem> valueOf(List<ServiceItemDTO> serviceItemDTOS) {
        return serviceItemDTOS.stream().map(ServiceItem::valueOf).collect(Collectors.toList());
    }
}
