package org.zaga.Repo;


import org.zaga.entity.TicketInfo;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class TicketInfoRepo implements PanacheRepository<TicketInfo>{

public TicketInfo getByNumber(long phoneNumber,String name){
    PanacheQuery<TicketInfo> info = TicketInfo.find("phoneNumber=?1 and name=?2", phoneNumber , name);
       TicketInfo phNumber = info.firstResult();
       System.out.println(phNumber+"      <------------------>>>>");
       return phNumber;
}
    







}
