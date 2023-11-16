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

    public void addServices(Maintenance services) {
        maintenanceRepository.save(services);
    }

    public boolean updateServices(Maintenance servicesRes, Integer id) {
        Maintenance services = maintenanceRepository.findMaintenanceById(id);
        if (services == null) {
            return false;
        }
        services.setServiceName(servicesRes.getServiceName());
        services.setPrice(servicesRes.getPrice());
        maintenanceRepository.save(services);
        return true;
    }

    public void deleteServices(Integer id) {
        Maintenance services = maintenanceRepository.findMaintenanceById(id);
        if (services == null) {
            throw new ApiException("Services not found");
        }
        maintenanceRepository.delete(services);
    }

}