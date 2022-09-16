package com.tweetApp.comp2.DTO;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ForgotPasswordDTO {

    private String username;
    private String newPassword;
    private String contact;


}