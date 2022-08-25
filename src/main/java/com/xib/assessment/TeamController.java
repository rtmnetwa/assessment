package com.xib.assessment;

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

    @PostMapping("/addTeam")
    @ResponseStatus(HttpStatus.CREATED)
    public Team addTeam(@RequestBody final Team team) throws ResourceExistsException{
        Team t=new Team();
        t.setId(UUID.randomUUID().getMostSignificantBits());
        t.setName(team.getName());
        return teamServiceImp.addTeam(t);
    }

    @GetMapping("/findTeam/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Team getTeam(@PathVariable("id") final Long id) throws ResourceExistsException{
        return teamServiceImp.getTeamById(id);
    }
    @GetMapping("/findAllTeams")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Team> getAllTeams() {
        return teamServiceImp.getAllTeams();
    }
}
