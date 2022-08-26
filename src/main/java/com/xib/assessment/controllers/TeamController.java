package com.xib.assessment.controllers;

import com.xib.assessment.exceptionHandling.MaxManagersReachedException;
import com.xib.assessment.exceptionHandling.ResourceExistsException;
import com.xib.assessment.exceptionHandling.ResourceNotFoundException;
import com.xib.assessment.models.Manager;
import com.xib.assessment.models.Team;
import com.xib.assessment.serviceImpl.TeamServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/teams")
public class TeamController {

    private TeamServiceImp teamServiceImp;
    @Autowired
    public TeamController(TeamServiceImp teamServiceImp) {
        this.teamServiceImp=teamServiceImp;
    }

    @PostMapping("/team")
    @ResponseStatus(HttpStatus.CREATED)
    public Team addTeam(@RequestBody final Team team) throws ResourceExistsException {
        Team t=new Team();
        t.setId(UUID.randomUUID().getMostSignificantBits());
        t.setName(team.getName());
        return teamServiceImp.addTeam(t);
    }
    //Adds a max of 2 managers to a team and prevents adding more managers
    @PutMapping("/managerTeam/{teamId}/manager")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Team addManager(@PathVariable("teamId")final Long teamId, @RequestBody final Manager manager)
            throws ResourceNotFoundException, MaxManagersReachedException {
        return teamServiceImp.addManager(teamId, manager);
    }
    @GetMapping("/findTeam/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Team getTeam(@PathVariable("id") final Long id) throws ResourceNotFoundException{
        return teamServiceImp.getTeamById(id);
    }
    @GetMapping("/findAllTeams")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Team> getAllTeams() {
        return teamServiceImp.getAllTeams();
    }
}
