package com.xib.assessment;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Long> {
    /**
     * So how do I construct the Agent object using the query from the database?
     */
    @Query("SELECT new com.xib.assessment.Agent(a.firstName, a.lastName) FROM agent_table.agent_schema")
    Page<Agent> findAll(Pageable pageable);
}
