package com.xib.assessment;

import java.util.List;
import java.util.Optional;

public interface TeamService {
    Team addTeam(Team team) throws ResourceExistsException;
    Team getTeamById(Long id) throws ResourceExistsException;
    List<Team> getAllTeams();
}
