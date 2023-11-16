package com.azdev.amrocenter.repository;

import com.azdev.amrocenter.model.Parts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartRepository extends JpaRepository<Parts, Integer> {

    public Parts findPartsById(Integer id);

}
