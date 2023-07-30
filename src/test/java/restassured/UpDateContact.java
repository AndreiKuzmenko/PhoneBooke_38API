package restassured;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import dto.AuthResponseDTO;
import dto.ContactDTO;
import dto.ContactListDTO;
import dto.ContactResponseDTO;
import helpers.Helper;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.jayway.restassured.RestAssured.given;

public class UpDateContact implements Helper {
    String endpoint = "contacts";


    @BeforeMethod
    public void precondition(){
        RestAssured.baseURI = BASE_URI;
        RestAssured.basePath = PATH;
    }
    @Test

    public void UpDateContact() throws IOException {

        ContactDTO contactDTO = ContactDTO.builder()
                .name("Neon")
                .lastName("Joen")
                .email("ui=tyyhn@gmail.com")
                .phone("19987444444")
                .address("local")
                .description("Contact")
                .build();

        ContactResponseDTO contactResponseDTO = given()
                .header(authHeader, PATH)
                .when()
                .put(endpoint)
                .then()
                .assertThat().statusCode(200)
                .extract()
                .as(ContactResponseDTO.class);

        String message = contactResponseDTO.getMessage();
        System.out.println("Message: " + message);
        String id = message.substring(message.lastIndexOf(" ") + 1);
        System.out.println(id);

    }


}
