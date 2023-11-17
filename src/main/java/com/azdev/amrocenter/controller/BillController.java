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
        List<Bill> bill = billService.getAllBill();
        return ResponseEntity.status(200).body(bill);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity getBill(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(billService.getBill(id));
    }

//    @PostMapping("/add")
//    public ResponseEntity addBill(@RequestBody Bill bill) {
//        billService.addBill(bill);
//        return ResponseEntity.status(200).body("Bill Added");
//    }

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

    /////////////////////////////////////////////////////

    @PostMapping("/addS/{billId}")
    public ResponseEntity assignMaintenance(@PathVariable Integer billId, @RequestBody @Valid Maintenance maintenance) {
        billService.assignMaintenance(billId, maintenance);
        return ResponseEntity.status(200).body("service added to bill");
    }


    @PostMapping("/addP/{billId}")
    public ResponseEntity assignPart(@PathVariable Integer billId, @RequestBody @Valid Parts part) {
        billService.assignPart(billId, part);
        return ResponseEntity.status(200).body("Part added to bill");
    }

    @PostMapping("/addB/{customerId}")
    public ResponseEntity assignPart(@PathVariable Integer customerId, @RequestBody @Valid Bill bill) {
        billService.assignBillToCustomer(customerId, bill);
        return ResponseEntity.status(200).body("Bill added to customer");
    }


    @GetMapping("/getBillsByPhone/{phone}")
    public ResponseEntity test2(@PathVariable String phone) {
        List<Bill> bill =  billService.getBillsByCustomerPhone(phone);
        return ResponseEntity.status(200).body(bill);
    }

}

//////////////////////////////////////////////////////////



