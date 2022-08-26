package com.xib.assessment.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String idNumber;
    @JsonIgnore
    @OneToMany (mappedBy = "manager")
    private List<Agent> agents;
    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "manager_team", joinColumns = @JoinColumn( name = "manager_id"),
            inverseJoinColumns = @JoinColumn(name = "team_id")
    )
    private List<Team> teams=new ArrayList<Team>();

    public Manager(){}
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public List<Agent> getAgents() {
        return agents;
    }

    public void setAgents(List<Agent> agents) {
        this.agents = agents;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeam(List<Team> teams) {
        this.teams = teams;
    }
}
