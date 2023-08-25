package org.zaga.Service;

import org.zaga.Repo.TicketInfoRepo;
import org.zaga.entity.TicketInfo;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class TicketInfoService {

    @Inject
    TicketInfoRepo repository;

    @Transactional
    public TicketInfo createTicketInfo(TicketInfo ticketInfo) {
        ticketInfo.setTotalTicketPrice(ticketInfo.getTicketCount() * 120);
        System.out.println("-------------------------" + ticketInfo);
        TicketInfo.persist(ticketInfo);
        return ticketInfo;

    }

    @Transactional
    public TicketInfo viewTicketInfo(long phoneNumber, String name) {
        return repository.getByNumber(phoneNumber, name);
    }

    @Transactional
    public TicketInfo updateTicketInfo(TicketInfo ticketInfo) {
        // ticketInfo.setTicketCount(ticketInfo.getTicketCount()*120);
        ticketInfo.setTotalTicketPrice(ticketInfo.getTicketCount() * 120 - ticketInfo.getTotalTicketPrice());
        return ticketInfo;

    }

    @Transactional
    public void cancelTicket(long phoneNumber, String name) {
        TicketInfo cancel = repository.getByNumber(phoneNumber, name);
        repository.delete(cancel);

    }

    @Transactional
    public void cancelTicketId(long id) {
        // TicketInfo cancel = repository.findById(id);
        repository.deleteById(id);
    }

}
