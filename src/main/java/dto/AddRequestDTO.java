package dto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder

public class AddRequestDTO {

    String name;
    String lastName;
    String email;
    String phone;
    String address;
    String description;
}
