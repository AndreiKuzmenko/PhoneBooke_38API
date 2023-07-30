package restassured;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import dto.AuthResponseDTO;
import dto.ContactDTO;
import dto.ContactResponseDTO;
import helpers.Helper;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

public class AddNewContact implements Helper {
    String endpoint = "contacts";

    @BeforeMethod
    public void precondition(){
        RestAssured.baseURI = BASE_URI;
        RestAssured.basePath = PATH;
    }
    @Test
    public void addNewContact(){
    ContactDTO contactDTO = ContactDTO.builder()
            .name("Lion")
            .lastName("Ruen")
            .email("jhhhn@gmail.com")
            .phone("17744444444")
            .address("locals")
            .description("Conects")
            .build();


        ContactResponseDTO contactResponseDTO =given()
            .body(contactDTO)
            .contentType(ContentType.JSON)
            .when()
            .post(endpoint)
            .then()
            .assertThat().statusCode(200)
            .extract()
            .as(ContactResponseDTO .class);

        String message = contactResponseDTO.getMessage();
        System.out.println("Message: " + message);
        String id = message.substring(message.lastIndexOf(" ") + 1);
        System.out.println(id);
    }

}
