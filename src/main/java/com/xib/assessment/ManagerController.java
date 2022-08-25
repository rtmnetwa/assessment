package com.xib.assessment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/manager")
public class ManagerController {

    private ManagerServiceImp managerServiceImp;
    @Autowired
    public ManagerController (ManagerServiceImp managerServiceImp) {
        this.managerServiceImp=managerServiceImp;
    }

    @PostMapping("/addManager")
    @ResponseStatus(HttpStatus.CREATED)
    public Manager addManager(@RequestBody final Manager manager) {
        Manager m=new Manager();
        m.setName(manager.getName());
        m.setIdNumber(manager.getIdNumber());
        return managerServiceImp.addManager(m);
    }
}
