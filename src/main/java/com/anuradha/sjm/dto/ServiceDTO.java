package com.anuradha.sjm.dto;

import com.anuradha.sjm.model.Service;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class ServiceDTO {
    private Long id;
    private Integer mileage;
    private String description;
    private BigDecimal totalAmount;
    private VehicleDTO vehicle;
    private List<ServiceItemDTO> serviceItems;

    public static ServiceDTO valueOf(Service service) {
        ServiceDTO serviceDTO = new ServiceDTO();
        BeanUtils.copyProperties(service, serviceDTO);
        serviceDTO.setVehicle(VehicleDTO.valueOf(service.getVehicle()));
        serviceDTO.setServiceItems(ServiceItemDTO.valueOf(service.getServiceItems()));
        return serviceDTO;
    }

    public static List<ServiceDTO> valueOf(List<Service> services) {
        return services.stream().map(ServiceDTO::valueOf).collect(Collectors.toList());
    }

}
