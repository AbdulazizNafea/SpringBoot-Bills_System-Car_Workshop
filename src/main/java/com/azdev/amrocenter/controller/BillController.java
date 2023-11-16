package com.azdev.amrocenter.controller;


import com.azdev.amrocenter.model.Bill;
import com.azdev.amrocenter.model.Parts;
import com.azdev.amrocenter.model.Maintenance;
import com.azdev.amrocenter.service.BillService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/bill")
@RequiredArgsConstructor
public class BillController {

    private final BillService billService;

    @GetMapping("/get")
    public ResponseEntity getAllBill() {
        List<Bill> customers = billService.getAllBill();
        return ResponseEntity.status(200).body(customers);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity getBill(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(billService.getBill(id));
    }

    @PostMapping("/add")
    public ResponseEntity addBill(@RequestBody Bill bill) {
        billService.addBill(bill);
        return ResponseEntity.status(200).body("Bill Added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateBill(@RequestBody Bill bill, @PathVariable Integer id) {
        billService.updateBill(bill, id);
        return ResponseEntity.status(200).body("Bill updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBill(@PathVariable Integer id) {
        billService.deleteBill(id);
        return ResponseEntity.status(200).body("deleted");
    }

    @PutMapping("/addS/{billId}/{maintenanceId}")
    public ResponseEntity test(@PathVariable Integer billId, @PathVariable Integer maintenanceId) {
        billService.assignMaintenance(billId, maintenanceId);
        return ResponseEntity.status(200).body("service added to bill");
    }


    @PutMapping("/addP/{billId}/{partId}")
    public ResponseEntity test2(@PathVariable Integer billId, @PathVariable Integer partId) {
        billService.assignPart(billId, partId);
        return ResponseEntity.status(200).body("Part added to bill");
    }

}

    //////////////////////////////////////////////////////////



