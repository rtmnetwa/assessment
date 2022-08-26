package com.xib.assessment.serviceImpl;

import com.xib.assessment.exceptionHandling.ResourceNotFoundException;
import com.xib.assessment.models.Manager;
import com.xib.assessment.repositories.ManagerRepository;
import com.xib.assessment.services.AgentService;
import com.xib.assessment.services.ManagerService;
import com.xib.assessment.services.TeamService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerServiceImp implements ManagerService {

    private ManagerRepository managerRepository;
    @Autowired
    public ManagerServiceImp(ManagerRepository managerRepository) {
        this.managerRepository=managerRepository;
    }
    @Override
    public Manager addManager(final Manager manager) {
        return managerRepository.save(manager);
    }

    @Override
    public Manager getManagementDetails(final Long id) throws ResourceNotFoundException {
        return managerRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Manager doesn't exist")
        );
    }
}
