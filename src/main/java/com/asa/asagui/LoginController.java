package com.asa.asagui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class LoginController {
    @FXML
    Button loginButton;
    @FXML
    Hyperlink signupHereHyperLink;
    @FXML
    TextField passwordTextField,usernameTextField;

    @FXML
    ImageView loginImageView;


    @FXML
    protected void onLogInButton(ActionEvent evt) throws IOException {



    }
}