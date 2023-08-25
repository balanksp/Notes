package org.zaga.Resource;

import org.zaga.Model.EmployeeDetails;
import org.zaga.Repo.EmployeeDetailsRepo;
import org.zaga.Service.EmployeeDetailsService;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/v1/employee-management")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeeDetailsResource {

    @Inject
    EmployeeDetailsService service;

    @Inject
    EmployeeDetailsRepo repo;
    
  @POST
  @Path("/create")
  public EmployeeDetails createEmployeeDetails(EmployeeDetails details){
    EmployeeDetails details2= service.createEmployeeDetails(details);
    return details2;
  }

  @GET
  @Path("/view")
  public EmployeeDetails viewEmployeeDetails(@QueryParam("id") Long id, @QueryParam("firstName") String firstName){
   EmployeeDetails details = service.viewEmployeeDetails(id, firstName);
   return details;
  }

  @PUT
  @Path("/update")
  public Response modifEmployeeDetails(@QueryParam ("id") long id,EmployeeDetails details){
    service.modifyEmployeeDetails(details);
                return Response.noContent().build();
  }
   
  @DELETE
  @Path("/delete")
    public void deleteEmployeeDetails(@QueryParam ("id") long id ,@QueryParam ("firstName") String firstName){
        service.deleteEmployeeDetails(id, firstName);
    }

}
