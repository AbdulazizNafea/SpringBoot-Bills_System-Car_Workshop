package com.azdev.amrocenter.service;


import com.azdev.amrocenter.apiException.ApiException;
import com.azdev.amrocenter.model.Branch;
import com.azdev.amrocenter.repository.BranchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BranchService {


    private final BranchRepository branchRepository;

    public List<Branch> getAllBranch() {
        return branchRepository.findAll();
    }

    public Branch getBranch(Integer id) {
        Branch branch = branchRepository.findBranchById(id);
        if (branch == null) {
            throw new ApiException("branch not found");
        }
        return branchRepository.findBranchById(id);
    }

    public void addBranch(Branch branch) {
        branchRepository.save(branch);
    }

    public void updateBranch(Branch branchRes, Integer id) {
        Branch branch = branchRepository.findBranchById(id);
        if (branch == null) {
            throw new ApiException("branch not found");
        }
        branch.setBranchName(branchRes.getBranchName());
        branch.setCommercialRecord(branchRes.getCommercialRecord());
        branch.setLocationDetails(branchRes.getLocationDetails());
        branch.setGoogleAddress(branchRes.getGoogleAddress());
        branch.setPhone(branchRes.getPhone());
        branch.setPhone2(branchRes.getPhone2());
        branch.setEmail(branchRes.getEmail());
        branch.setBankName(branchRes.getBankName());
        branch.setIBAN(branchRes.getIBAN());
        branchRepository.save(branch);
    }


//    public void deleteBranch(Integer id) {
//        Branch branch = branchRepository.findBranchById(id);
//        if (branch == null) {
//            throw new ApiException("branch not found");
//        }
//        branchRepository.delete(branch);
//    }
}
