package com.xib.assessment.services;

import com.xib.assessment.exceptionHandling.MaxManagersReachedException;
import com.xib.assessment.exceptionHandling.ResourceExistsException;
import com.xib.assessment.exceptionHandling.ResourceNotFoundException;
import com.xib.assessment.models.Manager;
import com.xib.assessment.models.Team;

import java.util.List;

public interface TeamService {
    Team addTeam(Team team) throws ResourceExistsException;
    Team getTeamById(Long id) throws ResourceNotFoundException;
    List<Team> getAllTeams();
    List<Team> emptyTeams();
    Team addManager(Long teamId, Manager manager) throws ResourceNotFoundException, MaxManagersReachedException;
}
