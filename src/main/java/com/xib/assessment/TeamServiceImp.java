package com.xib.assessment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImp implements TeamService{

    private TeamRepository teamRepository;
    @Autowired
    public TeamServiceImp(TeamRepository teamRepository) {
        this.teamRepository=teamRepository;
    }

    @Override
    public Team addTeam(Team team) throws ResourceExistsException {
        if(teamRepository.existsById(team.getId())){
            throw new ResourceExistsException("Team already exists");
        }
        return teamRepository.save(team);
    }

    @Override
    public Team getTeamById(Long id) throws ResourceExistsException {
        return teamRepository.findById(id)
                .orElseThrow(
                        ()-> new ResourceExistsException("Team doesn't exists")
                );
    }

    @Override
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }
}
