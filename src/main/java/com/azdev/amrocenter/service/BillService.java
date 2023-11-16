package com.azdev.amrocenter.service;

import com.azdev.amrocenter.apiException.ApiException;
import com.azdev.amrocenter.model.*;
import com.azdev.amrocenter.repository.BillRepository;
import com.azdev.amrocenter.repository.CustomerRepository;
import com.azdev.amrocenter.repository.PartRepository;
import com.azdev.amrocenter.repository.MaintenanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BillService {


    private final BillRepository billRepository;
    private final PartRepository partsRepository;
    private final MaintenanceRepository maintenanceRepository;

//    private final CustomerRepository customerRepository;

    public List<Bill> getAllBill() {
        return billRepository.findAll();
    }

    public Bill getBill(Integer id) {
        Bill bill = billRepository.findBillById(id);
        if (bill == null) {
            throw new ApiException("bill not found");
        }
        return billRepository.findBillById(id);
    }

    public void addBill(Bill bill) {
        billRepository.save(bill);
    }

    public boolean updateBill(Bill billRes, Integer id) {
        Bill bill = billRepository.findBillById(id);
        if (bill == null) {
            return false;
        }
        bill.setTotalPrice(billRes.getTotalPrice());
        bill.setPaymentMethod(billRes.getPaymentMethod());
        bill.setDiscount(billRes.getDiscount());
        bill.setDescription(billRes.getDescription());
        bill.setDate(billRes.getDate());
//        bill.setTaxCode(billRes.getTaxCode());
        billRepository.save(bill);
        return true;
    }

    public void deleteBill(Integer id) {
        Bill bill = billRepository.findBillById(id);
        if (bill == null) {
            throw new ApiException("Bill not found");
        }

        billRepository.delete(bill);
    }

    ///////////////////////////////////////////////////////////////////////

    public void assignPart(Integer billId, Integer partId) {
        Bill bill = billRepository.findBillById(billId);
        Parts part = partsRepository.findPartsById(partId);
        if (bill == null) {
            throw new ApiException("Bill not found or created");
        } else if (part == null) {
            throw new ApiException("Parts not found or created");
        }
        part.setBill(bill);
        partsRepository.save(part);
    }


    public void assignMaintenance(Integer billId, Integer maintenanceId) {
        Bill bill = billRepository.findBillById(billId);
        Maintenance maintenance = maintenanceRepository.findMaintenanceById(maintenanceId);
        if (bill == null) {
            throw new ApiException("Bill not found or created");
        } else if (maintenance == null) {
            throw new ApiException("Maintenance not found or created");
        }
        maintenance.setBill(bill);
        maintenanceRepository.save(maintenance);
    }

}
