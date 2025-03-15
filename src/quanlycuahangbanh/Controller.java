package com.example.quanlycuahangbanh;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
@FXML
    private Hyperlink si_forgot;

    @FXML
    private Button si_loginBtn;

    @FXML
    private AnchorPane si_loginForm;

    @FXML
    private PasswordField si_password;

    @FXML
    private TextField si_username;

    @FXML
    private Label side_alreadyLabel;

    @FXML
    private Button side_createAccount;

    @FXML
    private AnchorPane side_form;

    @FXML
    private Button side_signBtn;

    @FXML
    private Label side_taotk;

    @FXML
    private TextField su_answer;

    @FXML
    private PasswordField su_password;

    @FXML
    private ComboBox<?> su_question;

    @FXML
    private Button su_signupBtn;

    @FXML
    private AnchorPane su_signupForm;

    @FXML
    private TextField su_username;


    public void switchForm(ActionEvent event) {

        TranslateTransition slider = new TranslateTransition();
        if (event.getSource() == side_createAccount) {
            slider.setNode(side_form);
            slider.setToX(300);
            slider.setDuration(Duration.seconds(.2));
            slider.setOnFinished((ActionEvent e) -> {
                side_signBtn.setVisible(true);
                side_createAccount.setVisible(false);
                side_alreadyLabel.setVisible(true);
                side_taotk.setVisible(false);
            });
            slider.play();

        } else if (event.getSource() == side_signBtn) {
            slider.setNode(side_form);
            slider.setToX(0);
            slider.setDuration(Duration.seconds(.2));
            slider.setOnFinished((ActionEvent e) -> {
                side_signBtn.setVisible(false);
                side_createAccount.setVisible(true);
                side_alreadyLabel.setVisible(false);
                side_taotk.setVisible(true);
            });
            slider.play();

        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
