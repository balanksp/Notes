package org.zaga.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
// @Table(name="ticketinfo")
public class TicketInfo extends PanacheEntity{

   private long phoneNumber;
   private String name;
   private int ticketCount;
   private int totalTicketPrice;

}
