package okhttp;

import dto.ContactDTO;
import dto.ContactResponseDTO;
import helpers.Helper;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class UpDateContact  implements Helper {

    String endpoint = "contacts";

    @Test

    public void UpDateContact() throws IOException {

        ContactDTO contactDTO = ContactDTO.builder()
                .name("Leo")
                .lastName("Joy")
                .email("uihn@gmail.com")
                .phone("12267444444")
                .address("local")
                .description("Contact")
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
        String id = message.substring(message.lastIndexOf(" ") + 1);
        System.out.println(id);
    }


}
