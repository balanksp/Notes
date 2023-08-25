package org.zaga;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.zaga.Repo.TicketInfoRepo;
import org.zaga.entity.TicketInfo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

@QuarkusTest
public class MovieTicketBookingTest {

    @Inject
    TicketInfoRepo repo;

    @Test
    @Order(2)
    public void testGetTicket() throws JsonMappingException, JsonProcessingException {
        String ticketinfo = given()
                .contentType(ContentType.JSON)
                .param("phoneNumber", 7708521154L)
                .param("name", "Surendhar")
                .when()
                .get("/ticket-booking/v1/view-ticket-info")
                .then().statusCode(200).extract().asString();
        ObjectMapper mapper = new ObjectMapper();
        TicketInfo info = mapper.readValue(ticketinfo, TicketInfo.class);

        // .body().as(TicketInfo.class);
        assertNotNull(ticketinfo);

    }

    @Test
    @Order(1)
    public void testCreateTicketInfo() {
        TicketInfo info = new TicketInfo();
        info.setPhoneNumber(7708521154L);
        info.setName("Surendhar");
        info.setTicketCount(2);
        info.setTotalTicketPrice(240);
        // repo.persist(info);
        TicketInfo info1 = given()
                .body(info).contentType(ContentType.JSON)
                .when().post("/ticket-booking/v1/create-ticket-info")
                .then().statusCode(200).extract().body().as(TicketInfo.class);
        assertNotNull(info1);
        // assertNotNull(info.id);
    }

    @Test
    @Order(3)
    public void testCancelTicket() {
        
        given()
                .pathParam("id",1502L)
                .contentType(ContentType.JSON)
                .when().delete("/ticket-booking/v1/delete-ticket-id/{id}")
                .then().statusCode(204);

    }

}



// TicketInfo info = new TicketInfo();
//         info.setPhoneNumber(555777L);
//         info.setName("ptr");
        // info.setTicketCount(2);
        // info.setTotalTicketPrice(120);