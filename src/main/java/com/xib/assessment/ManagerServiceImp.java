package com.xib.assessment;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ManagerServiceImp implements ManagerService{

    private ManagerRepository managerRepository;
    private TeamService teamService;
    private AgentService agentService;

    @Autowired
    public ManagerServiceImp(ManagerRepository managerRepository) {
        this.managerRepository=managerRepository;
    }
    @Override
    public Manager addManager(Manager manager) {
        log.info("Adding manager...");
        return managerRepository.save(manager);
    }

    @Override
    public Manager getManagementDetails(String idNumber) {
        log.info("Getting manager details...");
        return managerRepository.findManagerByIdNumber(idNumber);
    }
}
