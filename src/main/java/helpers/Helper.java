package helpers;

import com.google.gson.Gson;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;

import java.util.Random;

public interface Helper {

    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    Gson gson = new Gson();

    OkHttpClient client = new OkHttpClient();

    String TOKEN ="eyJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6WyJST0xFX1VTRVIiXSwic3ViIjoicmVmQGdtYWlsLmNvbSIsImlzcyI6IlJlZ3VsYWl0IiwiZXhwIjoxNjkwOTgwODM5LCJpYXQiOjE2OTAzODA4Mzl9.nuPbBsXBlIpSgkJAW-I1Rl9a4FF4VhJr2-DsL2wEtX8";

    String BASE_URI = "https://contactapp-telran-backend.herokuapp.com";
    String PATH = "v1";
    String authHeader = "Authorization";
    int i = new Random().nextInt(1000) + 1000;
}
