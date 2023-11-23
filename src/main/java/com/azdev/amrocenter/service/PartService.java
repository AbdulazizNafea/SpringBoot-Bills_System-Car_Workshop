package com.azdev.amrocenter.service;


import com.azdev.amrocenter.apiException.ApiException;
import com.azdev.amrocenter.model.Parts;
import com.azdev.amrocenter.repository.PartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PartService {
    private final PartRepository partsRepository;


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

    public void updateParts(Parts partsRes, Integer id) {
        Parts parts = partsRepository.findPartsById(id);
        if (parts == null) {
            throw new ApiException("parts not found");
        }
        parts.setPartName(partsRes.getPartName());
        parts.setPrice(partsRes.getPrice());
        partsRepository.save(parts);
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
