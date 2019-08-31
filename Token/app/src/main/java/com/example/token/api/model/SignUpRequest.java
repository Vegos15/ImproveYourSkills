package com.example.token.api.model;

import com.google.gson.annotations.SerializedName;

public class SignUpRequest {
    @SerializedName("UserName")
    String userName;
    @SerializedName("Email")
    String email;
    @SerializedName("Password")
    String password;
    @SerializedName("PasswordConfirm")
    String confirmPassword;

    public SignUpRequest(String userName, String email, String password, String confirmPassword) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }
}
