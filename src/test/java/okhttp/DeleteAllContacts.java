package okhttp;

import dto.ContactResponseDTO;
import helpers.Helper;
import okhttp3.Request;
import okhttp3.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;


public class DeleteAllContacts implements Helper {
    String endpoint = "contacts/clear";

    @Test
    public void DeleteContactPos() throws IOException {


        Request request = new Request.Builder()
                .url(BASE_URI + "/" + PATH + "/" + endpoint)
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
