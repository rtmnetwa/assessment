package com.xib.assessment.controllers;

import com.xib.assessment.exceptionHandling.ResourceNotFoundException;
import com.xib.assessment.models.Manager;
import com.xib.assessment.serviceImpl.ManagerServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/managers")
public class ManagerController {

    private ManagerServiceImp managerServiceImp;
    @Autowired
    public ManagerController (ManagerServiceImp managerServiceImp) {
        this.managerServiceImp=managerServiceImp;
    }

    @PostMapping("/manager")
    @ResponseStatus(HttpStatus.CREATED)
    public Manager addManager(@RequestBody final Manager manager) {
        Manager m=new Manager();
        m.setId(UUID.randomUUID().getMostSignificantBits());
        m.setName(manager.getName());
        m.setIdNumber(manager.getIdNumber());
        return managerServiceImp.addManager(m);
    }

    @GetMapping("/manager/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Manager getManagementDetails(@PathVariable("id")final Long id) throws ResourceNotFoundException {
        return managerServiceImp.getManagementDetails(id);
    }
}
