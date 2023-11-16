package com.azdev.amrocenter.controller;



import com.azdev.amrocenter.model.Maintenance;
import com.azdev.amrocenter.service.MaintenanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/maintenance")
@RequiredArgsConstructor
public class MaintenanceController {

    private final MaintenanceService maintenanceService;

    @GetMapping("/get")
    public ResponseEntity getAllServices() {
        List<Maintenance> customers = maintenanceService.getAllServices();
        return ResponseEntity.status(200).body(customers);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity getServices(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(maintenanceService.getServices(id));
    }

    @PostMapping("/add")
    public ResponseEntity addServices(@RequestBody Maintenance services) {
        maintenanceService.addServices(services);
        return ResponseEntity.status(200).body("Services Added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateServices(@RequestBody Maintenance services, @PathVariable Integer id) {
        maintenanceService.updateServices(services, id);
        return ResponseEntity.status(200).body("Services updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteServices(@PathVariable Integer id) {
        maintenanceService.deleteServices(id);
        return ResponseEntity.status(200).body("deleted");
    }
}


