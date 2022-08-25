package com.xib.assessment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ManagerRepository extends JpaRepository<Manager, Long> {

    @Query("SELECT name.manager_schema id_number.manager_schema FROM manager_table.manager_schema WHERE id_number=?")
    Manager findManagerByIdNumber(String idNumber);
}
