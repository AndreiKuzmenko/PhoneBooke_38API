package okhttp;

import dto.ContactDTO;
import dto.ContactResponseDTO;
import helpers.Helper;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class DeleteContactByIDTests implements Helper {
    String endpoint = "contacts";
    String id;
    @BeforeMethod
    public void precondition() throws IOException {

        ContactDTO contactDTO = ContactDTO.builder()
                .name("Neo")
                .lastName("John")
                .email("john@gmail.com")
                .phone("12244444444")
                .address("localhost")
                .description("New Contact")
                .build();
        RequestBody requestBody =RequestBody.create(gson.toJson(contactDTO), JSON);

        Request request = new Request.Builder()
                .url(BASE_URI + "/" + PATH + "/" + endpoint)
                .addHeader(authHeader, PATH)
                .post(requestBody)
                .build();


        Response response = client.newCall(request).execute();
        ContactResponseDTO contactResponseDTO = gson.fromJson(response.body().string(), ContactResponseDTO.class);
        Assert.assertFalse(response.isSuccessful());
        String message = contactResponseDTO.getMessage();
        System.out.println("Message: " + message);
        id = message.substring(message.lastIndexOf(" ") + 1);

    }


    @Test
            public void DeleteContactPos() throws IOException {


        Request request = new Request.Builder()
                .url(BASE_URI + "/" + PATH + "/" + endpoint + "/" + id)
                .addHeader(authHeader, PATH)
                .delete()
                .build();


        Response response = client.newCall(request).execute();
        ContactResponseDTO contactResponseDTO = gson.fromJson(response.body().string(), ContactResponseDTO.class);
        Assert.assertFalse(response.isSuccessful());
        String message = contactResponseDTO.getMessage();
        System.out.println("Message: " + message);
    }
}
