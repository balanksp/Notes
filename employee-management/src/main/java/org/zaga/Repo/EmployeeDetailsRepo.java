package org.zaga.Repo;

import org.zaga.Model.EmployeeDetails;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class EmployeeDetailsRepo implements PanacheRepositoryBase<EmployeeDetails, Long>
{
  public EmployeeDetails getEmployeeDetails(Long id, String firstName){

    PanacheQuery<EmployeeDetails> details = EmployeeDetails.find("id=?1 and firstName=?2", id, firstName);
    EmployeeDetails employee = details.firstResult();
    return employee ;
    
  }

}
