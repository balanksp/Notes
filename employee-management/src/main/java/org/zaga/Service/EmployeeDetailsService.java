package org.zaga.Service;

import org.zaga.Model.EmployeeDetails;



public interface EmployeeDetailsService {

   
    EmployeeDetails createEmployeeDetails(EmployeeDetails employeeDetails);

    EmployeeDetails viewEmployeeDetails(Long id, String firstName);

    EmployeeDetails modifyEmployeeDetails(EmployeeDetails employeeDetails); 

    void deleteEmployeeDetails(Long id, String firstName);
    
}
