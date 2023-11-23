package com.azdev.amrocenter.repository;

import com.azdev.amrocenter.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Integer> {

   public Branch findBranchById(Integer id);
}
