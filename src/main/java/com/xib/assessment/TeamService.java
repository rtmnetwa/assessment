package com.xib.assessment;

import java.util.List;
import java.util.Optional;

public interface TeamService {
    Optional<Team> addTeam(Team team) throws ResourceExistsException;
    Team getTeamById(long id);
    List<Team> getAllTeams();
}
