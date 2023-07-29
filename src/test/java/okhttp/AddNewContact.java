package okhttp;

import dto.*;
import helpers.Helper;
import okhttp3.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddNewContact implements Helper {

    String endpoint = "contacts";

    @Test

public void addNewContact() throws IOException {

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
        Assert.assertTrue(response.isSuccessful());
        String message = contactResponseDTO.getMessage();
        System.out.println("Message: " + message);
        String id = message.substring(message.lastIndexOf(" ") + 1);
        System.out.println(id);
    }
}



