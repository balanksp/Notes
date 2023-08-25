package org.zaga.Resource;

import org.zaga.Service.TicketInfoService;
import org.zaga.entity.TicketInfo;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/ticket-booking")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TicketInfoResource {

    @Inject
    TicketInfoService service;

    //  @POST
    // @Path("/v1/create-ticket-mock")
    // public Response createTicket(TicketInfo info){
    //                   TicketInfo tckInfo = service.createTicketMock(info);
    //          return Response.ok(tckInfo).build();
    // }

    @POST
    @Path("/v1/create-ticket-info")
    public Response createTicketInfo(TicketInfo info){
        System.out.println("            <--------create details------------");
             return Response.ok(service.createTicketInfo(info)).build();
    }

    @GET
    @Path("/v1/view-ticket-info")
    public Response viewTicketsInfo(@QueryParam ("phoneNumber") long phoneNumber,@QueryParam ("name") String name){
        System.out.println("------view the details--------------");
        return Response.ok(service.viewTicketInfo(phoneNumber,name)).build();
    }

    @PUT
    @Path("/v1/update-ticket-info")
    public Response updateTicketsInfo(@QueryParam ("phoneNumber") long phoneNumber,TicketInfo ticketInfo){
        return Response.ok(service.updateTicketInfo(ticketInfo)).build();
    }


    @DELETE
    @Path("/v1/delete-ticket")
    public void deleteTickets(@QueryParam ("phoneNumber") long phoneNumber, @QueryParam ("name") String name ){
        service.cancelTicket(phoneNumber, name);
    }

    @DELETE
    @Path("/v1/delete-ticket-id/{id}")
    public void deleteTicket(@PathParam("id") Long id){
        service.cancelTicketId(id);
    }
    


}
