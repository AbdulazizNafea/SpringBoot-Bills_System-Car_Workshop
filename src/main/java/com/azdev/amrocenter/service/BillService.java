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

    private final CustomerRepository customerRepository;

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

//    public void addBill(Bill bill) {
//        billRepository.save(bill);
//    }

    public boolean updateBill(Bill billRes, Integer id) {
        Bill bill = billRepository.findBillById(id);
        if (bill == null) {
            return false;
        }

        double totalPartPrice = 0.0;
        for (Parts p : bill.getPart()) {
            totalPartPrice = p.getPrice() + totalPartPrice;
        }

        double totalMaintenancePrice = 0;
        for (Maintenance m : bill.getMaintenance()) {
            totalMaintenancePrice = m.getPrice() + totalMaintenancePrice;
        }




        bill.setPaymentMethod(billRes.getPaymentMethod());
        bill.setDiscount(billRes.getDiscount());
        bill.setDescription(billRes.getDescription());
        bill.setDate(billRes.getDate());
        bill.setCarName(billRes.getCarName());
        bill.setCarType(billRes.getCarType());
        bill.setModel(billRes.getModel());
        bill.setVehicleNumber(billRes.getVehicleNumber());
        bill.setPlateNumber(billRes.getPlateNumber());
        bill.setTotalPrice((totalPartPrice + totalMaintenancePrice) - bill.getDiscount());
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

    public void assignPart(Integer billId, Parts part) {
        Bill bill = billRepository.findBillById(billId);
        if (bill == null) {
            throw new ApiException("Bill not found or created");
        } else if (part == null) {
            throw new ApiException("Parts not found or created");
        }
        part.setBill(bill);
        partsRepository.save(part);
    }


    public void assignMaintenance(Integer billId, Maintenance maintenance) {
        Bill bill = billRepository.findBillById(billId);
        if (bill == null) {
            throw new ApiException("Bill not found or created");
        } else if (maintenance == null) {
            throw new ApiException("Maintenance not found or created");
        }
        maintenance.setBill(bill);
        maintenanceRepository.save(maintenance);
    }

//


    // get all bill by customer phone as ID ...
    public List<Bill> getBillsByCustomerPhone(String customerPhone) {
        Customer customer = customerRepository.findCustomersByPhone(customerPhone);
        if (customer == null) {
            throw new ApiException("Customer not found or created");
        } else {
            List<Bill> bill = billRepository.findByCustomerPhone(customerPhone);
            if (bill == null) {
                throw new ApiException("No Bills founds or created");
            }
            return bill;
        }
    }

    public void assignBillToCustomer(Integer customerId, Bill bill) {
        Customer customer = customerRepository.findCustomerById(customerId);
        if (customer == null) {
            throw new ApiException("Bill not found or created");
        } else if (bill == null) {
            throw new ApiException("Customer not found or created");
        }
        bill.setCustomer(customer);
        billRepository.save(bill);
    }


}
