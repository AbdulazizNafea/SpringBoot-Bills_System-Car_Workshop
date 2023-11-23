package com.azdev.amrocenter.service;

import com.azdev.amrocenter.apiException.ApiException;
import com.azdev.amrocenter.model.Maintenance;
import com.azdev.amrocenter.repository.MaintenanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class MaintenanceService {
    private final MaintenanceRepository maintenanceRepository;

    public List<Maintenance> getAllServices() {
        return maintenanceRepository.findAll();
    }

    public Maintenance getServices(Integer id) {
        Maintenance services = maintenanceRepository.findMaintenanceById(id);
        if (services == null) {
            throw new ApiException("services not found");
        }
        return maintenanceRepository.findMaintenanceById(id);
    }


    public void updateServices(Maintenance servicesRes, Integer id) {
        Maintenance maintenance = maintenanceRepository.findMaintenanceById(id);
        if (maintenance == null) {
            throw new ApiException("Maintenance not found");

        }
        maintenance.setServiceName(servicesRes.getServiceName());
        maintenance.setPrice(servicesRes.getPrice());
        maintenanceRepository.save(maintenance);
    }

    public void deleteServices(Integer id) {
        Maintenance services = maintenanceRepository.findMaintenanceById(id);
        if (services == null) {
            throw new ApiException("Services not found");
        }
        maintenanceRepository.delete(services);
    }

}