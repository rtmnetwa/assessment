package com.xib.assessment;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Manager {
    @Id
    private long id;
    private String name;
    private Agent agent;
    private Team team;
}
