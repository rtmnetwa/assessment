package com.xib.assessment.repositories;

import com.xib.assessment.models.Agent;
import com.xib.assessment.projection.SecureAgent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Long> {
    @Query (value = "SELECT first_name, last_name FROM agent", nativeQuery = true)
    Page<SecureAgent> findAllPaged(Pageable pageable);
}
