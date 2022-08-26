package com.xib.assessment.serviceImpl;

import com.xib.assessment.exceptionHandling.MaxManagersReachedException;
import com.xib.assessment.exceptionHandling.ResourceExistsException;
import com.xib.assessment.exceptionHandling.ResourceNotFoundException;
import com.xib.assessment.models.Manager;
import com.xib.assessment.models.Team;
import com.xib.assessment.repositories.TeamRepository;
import com.xib.assessment.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImp implements TeamService {

    private TeamRepository teamRepository;
    @Autowired
    public TeamServiceImp(TeamRepository teamRepository) {
        this.teamRepository=teamRepository;
    }

    @Override
    public Team addTeam(final Team team) throws ResourceExistsException {
        if(teamRepository.existsById(team.getId())){
            throw new ResourceExistsException("Team already exists");
        }
        return teamRepository.save(team);
    }

    @Override
    public Team getTeamById(final Long id) throws ResourceNotFoundException {
        return teamRepository.findById(id)
                .orElseThrow(
                        ()-> new ResourceNotFoundException("Team doesn't exists")
                );
    }

    @Override
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    @Override
    public List<Team> emptyTeams() {
        return teamRepository.emptyTeams();
    }

    //Adds a maximum of 2 managers for each team and prevents adding another
    @Override
    public Team addManager(final Long teamId, final Manager manager) throws ResourceNotFoundException, MaxManagersReachedException {
        Team team = getTeamById(teamId);
        if(team.getManagers().size() >=2 ) {
            throw new MaxManagersReachedException("Max amount of managers for this team has been reached.");
        }
        team.getManagers().add(manager);
        return teamRepository.save(team);
    }
}
