package org.zaga;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.zaga.Model.EmployeeDetails;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

@QuarkusTest
public class GreetingResourceTest {

     @Test
    public void testViewEmployeeDetails() {
        long id = 80; 
        String firstName = "balaaaa";

      RestAssured.given()
        .queryParam("id", id)
        .queryParam("firstName", firstName)
    .when()
        .get("http://localhost:8075/v1/employee-management/view")
    .then()
        .statusCode(200) 
        .contentType(ContentType.JSON)
        .body("id",equalTo(80))
        .body("firstName", equalTo(firstName));
    }


    @Test
    public void testcreateEmployeeDetails(){
        EmployeeDetails employeeDetails = new EmployeeDetails();
        employeeDetails.setId(555);
        employeeDetails.setAddress("kvp");
        employeeDetails.setFirstName("bala");
        employeeDetails.setPhoneNumber(555555);
        given()
        .body(employeeDetails)
        .when()
            .post("http://localhost:8075/v1/employee-management/create")
        .then()
        .statusCode(200)
        .body(555).body("kvp").body("bala").body(555555);
            
    }

}