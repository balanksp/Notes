package org.zaga.ServiceImplementation;

import org.zaga.Model.EmployeeDetails;
import org.zaga.Repo.EmployeeDetailsRepo;
import org.zaga.Service.EmployeeDetailsService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class EmployeeDetailsImplementation implements EmployeeDetailsService {

  @Inject
  EmployeeDetailsRepo repo;

  @Override
  @Transactional
  public EmployeeDetails createEmployeeDetails(EmployeeDetails employeeDetails) {
    EmployeeDetails.persist(employeeDetails);
    return employeeDetails;
  }

  @Override
  public EmployeeDetails viewEmployeeDetails(Long id, String firstName) {
    EmployeeDetails employeeDetails = repo.getEmployeeDetails(id, firstName);
    return employeeDetails;
  }

  @Override
  @Transactional
  public EmployeeDetails modifyEmployeeDetails(EmployeeDetails employeeDetails) {
    EmployeeDetails allDetails = repo.findById(employeeDetails.getId());
    allDetails.setId(employeeDetails.getId());
    allDetails.setFirstName(employeeDetails.getFirstName());
    allDetails.setPhoneNumber(employeeDetails.getPhoneNumber());
    allDetails.setAddress(employeeDetails.getAddress());
    allDetails.setBloodGroup(employeeDetails.getBloodGroup());
    return allDetails;
  }

  @Override
  @Transactional
  public void deleteEmployeeDetails(Long id, String firstName) {
    EmployeeDetails details = repo.getEmployeeDetails(id, firstName);
    details.delete();
  }

}
