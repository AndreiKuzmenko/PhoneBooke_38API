package restassured;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import dto.AuthRequestDTO;
import dto.AuthResponseDTO;
import dto.ErrorDTO;
import helpers.Helper;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

public class Registration implements Helper {

String endpoint = "user/registration/usernamepassword";

    @BeforeMethod
    public void precondition(){
        RestAssured.baseURI = BASE_URI;
        RestAssured.basePath = PATH;
    }
    @Test
    public void regPositive(){
        AuthRequestDTO requestDTO = AuthRequestDTO.builder()
                .username("rtref_" + i + "@gmail.com")
                .password("$$$Qwe1234")
                .build();
        AuthResponseDTO responseDTO = given()
                .body(requestDTO)
                .contentType(ContentType.JSON)
                .when()
                .post(endpoint)
                .then()
                .assertThat().statusCode(200)
                .extract()
                .as(AuthResponseDTO.class);

        System.out.println(responseDTO.getToken());
    }
    @Test
    public void regNegative(){
        AuthRequestDTO requestDTO = AuthRequestDTO.builder()
                .username("rtref_" + i + "gmail.com")
                .password("$$$Qwe1234")
                .build();

        ErrorDTO errorDTO = given()
                .body(requestDTO)
                .contentType(ContentType.JSON)
                .when()
                .post(endpoint)
                .then()
                .assertThat().statusCode(400)
                .extract()
                .as(ErrorDTO.class);

        System.out.println(errorDTO.getMessage());
    }

}
