package com.anuradha.sjm.dto;

import com.anuradha.sjm.model.ServiceItem;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class ServiceItemDTO {
    private Long id;
    private String description;
    private BigDecimal cost;

    public static ServiceItemDTO valueOf(ServiceItem serviceItem) {
        ServiceItemDTO serviceItemDTO = new ServiceItemDTO();
        BeanUtils.copyProperties(serviceItem, serviceItemDTO);
        return serviceItemDTO;
    }

    public static List<ServiceItemDTO> valueOf(List<ServiceItem> serviceItems) {
        return serviceItems.stream().map(ServiceItemDTO::valueOf).collect(Collectors.toList());
    }
}
