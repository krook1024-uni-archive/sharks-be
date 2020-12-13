package krook1024.sharksAPI.user.dto;

import lombok.Data;

@Data
public class UserDTO {
    private int id;

    private String username;

    private String password;

    private String email;
}
