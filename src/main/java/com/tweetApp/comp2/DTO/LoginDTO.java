package com.tweetApp.comp2.DTO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LoginDTO {

    private String username;
    private String password;

}
