package com.azdev.amrocenter.service;


import com.azdev.amrocenter.apiException.ApiException;
import com.azdev.amrocenter.model.Parts;
import com.azdev.amrocenter.repository.BillRepository;
import com.azdev.amrocenter.repository.PartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PartService {
    private final PartRepository partsRepository;
    private final BillRepository billRepository;


    public List<Parts> getAllParts() {
        return partsRepository.findAll();
    }

    public Parts getParts(Integer id) {
        Parts parts = partsRepository.findPartsById(id);
        if (parts == null) {
            throw new ApiException("parts not found");
        }
        return partsRepository.findPartsById(id);
    }

//    public void addParts(Parts parts) {
//        partsRepository.save(parts);
//    }

    public boolean updateParts(Parts partsRes, Integer id) {
        Parts parts = partsRepository.findPartsById(id);
        if (parts == null) {
            return false;
        }
        parts.setPartName(partsRes.getPartName());
        parts.setPrice(partsRes.getPrice());
//        parts.setBill(null);
        partsRepository.save(parts);
        return true;
    }

    public void deleteParts(Integer id) {
        Parts parts = partsRepository.findPartsById(id);
        if (parts == null) {
            throw new ApiException("Parts not found");
        }
        partsRepository.delete(parts);
    }

    ///////////////////////////////////////////////////////////



}
