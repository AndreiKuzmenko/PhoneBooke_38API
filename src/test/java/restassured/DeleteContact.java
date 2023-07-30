package restassured;

import com.jayway.restassured.RestAssured;
import dto.ContactDTO;
import dto.ContactResponseDTO;
import helpers.Helper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

public class DeleteContact implements Helper {

    String endpoint = "contacts";
    String id;
    @BeforeMethod
    public void precondition(){
        RestAssured.baseURI = BASE_URI;
        RestAssured.basePath = PATH;
    }
    @Test
    public void DeleteContactPositive(){
        ContactDTO contactDTO = ContactDTO.builder()
                .name("Leon")
                .lastName("Roen")
                .email("jyhn@gmail.com")
                .phone("12844444444")
                .address("local")
                .description("Contact")
                .build();

        ContactResponseDTO contactResponseDTO = given()
                .header(authHeader, PATH)
                .when()
                .delete(endpoint)
                .then()
                .assertThat().statusCode(401)
                .extract()
                .as(ContactResponseDTO.class);


        String message = contactResponseDTO.getMessage();
        System.out.println("Message: " + message);
}


}
