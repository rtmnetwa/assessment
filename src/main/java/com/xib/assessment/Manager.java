package com.xib.assessment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="manager_table", schema="manager_schema")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Manager {
    @Id
    @GeneratedValue
    private long id;
    @Column(name="name")
    private String name;
    @Column(name="id_number")
    private String idNumber;
    @OneToOne
    private Agent agent;
    @ManyToOne
    private Team team;


}
