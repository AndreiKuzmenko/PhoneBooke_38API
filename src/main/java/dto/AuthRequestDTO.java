package dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder

public class AuthRequestDTO {

    //      "username": "string",
//      "password": "`=iNmQBt9Oo"

    String username;

    String password;

    public boolean getToken() {
        return false;
    }
}
