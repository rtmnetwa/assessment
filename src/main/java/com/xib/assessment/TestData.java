package com.xib.assessment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xib.assessment.models.*;
import com.xib.assessment.repositories.*;


import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

@Component
public class TestData {
    @Autowired
    AgentRepository agentRepository;

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    ManagerRepository managerRepository;

    @PostConstruct
    @Transactional
    public void execute() {
        Team team1 = createTeam("Marvel");
        Team team2 = createTeam("DC");
        Manager manager1 = createManager("Captain America", "6584564189786", team1);
        Manager manager2 = createManager("Thor", "4548979581279", team2);
        team1.getManagers().add(manager1);
        team2.getManagers().add(manager2);

        saveTeam(team1);
        saveTeam(team2);
        saveManager(manager1);
        saveManager(manager2);

        createAgent("Bruce", "Banner", "1011125190081", team1, manager1);
        createAgent("Tony", "Stark", "6912115191083", team1, manager1);
        createAgent("Peter", "Parker", "7801115190084", team1, manager1);
        createAgent("Bruce", "Wayne", "6511185190085", team2, manager2);
        createAgent("Clark", "Kent", "5905115190086",team2, manager2);
    }

    private Manager createManager(String name, String idNumber, Team team){
        Manager m = new Manager();
        m.setName(name);
        m.setIdNumber(idNumber);
        m.getTeams().add(team);
        return m;
    }

    private Manager saveManager(Manager manager) {
        return managerRepository.save(manager);
    }

    private Team createTeam(String name) {
        Team t = new Team();
        t.setName(name);
        return t;
    }

    private Team saveTeam(Team team) {
        return teamRepository.save(team);
    }

    private Agent createAgent(String firstName, String lastName, String idNumber, Team team, Manager manager) {
        Agent a = new Agent();
        a.setFirstName(firstName);
        a.setLastName(lastName);
        a.setIdNumber(idNumber);
        a.setTeam(team);
        a.setManager(manager);
        return agentRepository.save(a);
    }
}
