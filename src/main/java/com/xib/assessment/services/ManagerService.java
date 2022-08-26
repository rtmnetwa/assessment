package com.xib.assessment.services;

import com.xib.assessment.exceptionHandling.ResourceNotFoundException;
import com.xib.assessment.models.Manager;

public interface ManagerService {
    Manager addManager(Manager manager);
    Manager getManagementDetails(Long id) throws ResourceNotFoundException;
}
