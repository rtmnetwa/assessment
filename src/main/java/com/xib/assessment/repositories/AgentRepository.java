package com.xib.assessment.repositories;

import com.xib.assessment.models.Agent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Long> {
    /**
     * So how do I construct the Agent object using the query from the database?
     */
    //@Query("SELECT new com.xib.assessment.models.Agent(a.firstName, a.lastName) FROM agent_table.agent_schema")
    @Query (value = "SELECT id, first_name, last_name, team, manager FROM agent", nativeQuery = true)
    Page<Agent> findAll(Pageable pageable);
}
