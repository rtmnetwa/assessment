package com.xib.assessment.repositories;

import com.xib.assessment.models.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    @Query(value = "SELECT id, name FROM team WHERE manager=null AND agent=null", nativeQuery = true)
    List<Team> emptyTeams();
}
