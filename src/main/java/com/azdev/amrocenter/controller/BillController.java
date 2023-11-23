package com.azdev.amrocenter.controller;


import com.azdev.amrocenter.model.Bill;
import com.azdev.amrocenter.model.Parts;
import com.azdev.amrocenter.model.Maintenance;
import com.azdev.amrocenter.service.BillService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@SuppressWarnings("ALL")
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
    public ResponseEntity getBillsByPhone(@PathVariable String phone) {
        List<Bill> bill =  billService.getBillsByCustomerPhone(phone);
        return ResponseEntity.status(200).body(bill);
    }


    @GetMapping("/getBillBetweenDate/{d1}/{d2}")
    public ResponseEntity getBillBetweenDate(@PathVariable LocalDate d1,@PathVariable LocalDate d2) {
        List<Bill> bill =  billService.getBillBetweenDate(d1,d2);
        return ResponseEntity.status(200).body(bill);
    }


    @GetMapping("/getBillByCustomerId/{id}")
    public ResponseEntity getBillByCustomerId(@PathVariable Integer id) {
        List<Bill> bill =  billService.getBillByCustomerId(id);
        return ResponseEntity.status(200).body(bill);
    }




}

//////////////////////////////////////////////////////////



