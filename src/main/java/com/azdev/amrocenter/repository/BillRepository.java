package com.azdev.amrocenter.repository;

import com.azdev.amrocenter.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

//@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {

     Bill findBillById(Integer id);

     //Bill findBillByCustomer_id(Integer customerId);

     @Query("select b from Bill b join b.customer c where c.phone = :phone order by b.date desc")
     List<Bill> findByCustomerPhone(@Param("phone") String phone);

     @Query("select b from Bill b join b.customer c where c.id = :id order by b.date desc")
     List<Bill> findByCustomerId(@Param("id") Integer id);
     @Query("select b from Bill b where b.date >= :startDate and b.date <= :endDate order by b.date desc")
     List<Bill> findByDateRange(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

     List<Bill> findBillByCustomerId(Integer id);



}
