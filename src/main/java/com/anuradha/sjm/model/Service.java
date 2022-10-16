package com.anuradha.sjm.model;

import com.anuradha.sjm.dto.ServiceDTO;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer mileage;
    private String description;
    private BigDecimal totalAmount;
    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;
    @OneToMany(cascade = CascadeType.ALL)
    private List<ServiceItem> serviceItems;

    public static Service valueOf(ServiceDTO serviceDTO) {
        Service service = new Service();
        BeanUtils.copyProperties(serviceDTO, service);
        return service;
    }
}
