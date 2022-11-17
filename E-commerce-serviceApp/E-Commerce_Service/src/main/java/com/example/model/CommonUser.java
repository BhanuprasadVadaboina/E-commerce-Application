package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonUser {
    private String email_id;

    private String address;
    private String phoneNo;
    private String user_name;
    private String password;
}
