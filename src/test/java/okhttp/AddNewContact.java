package okhttp;

import com.google.gson.Gson;
import dto.*;
import okhttp3.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddNewContact {

    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    Gson gson = new Gson();
    OkHttpClient client = new OkHttpClient();


    @Test

public void addNewContact() throws IOException {


        AddRequestDTO addRequestDTO = new AddRequestDTO().builder()
                .name("Dan")
                .lastName("Levi")
                .email("wer@gmail.com")
                .phone("3434344444")
                .address("London")
                .description("The new contact")
                .build();

        RequestBody addRequestBody = RequestBody.create(gson.toJson(addRequestDTO), JSON);

        Request request = new Request.Builder()
                .url("https://contactapp-telran-backend.herokuapp.com/v1/user/login/usernamepassword")
                .post(addRequestBody)
                .build();


        Response response = client.newCall(request).execute();

        if (response.isSuccessful()) {

            AddResponseDTO responseDTO = gson.fromJson(response.body().string(), AddResponseDTO.class);
            System.out.println(responseDTO.getMassage());
            System.out.println("Response code is: " + response.code());
            Assert.assertTrue(response.isSuccessful());

        } else {
            System.out.println("Response code is: " + response.code());
            ErrorDTO errorDTO = gson.fromJson(response.body().string(), ErrorDTO.class);
            System.out.println(errorDTO.getStatus() + " " + errorDTO.getMessage() + " " + errorDTO.getError());
            Assert.assertTrue(response.isSuccessful());
        }

    }
}



