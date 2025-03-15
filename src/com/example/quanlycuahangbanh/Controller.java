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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert.AlertType;
import quanlycuahangbanh.database;
import java.sql.Connection;

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

    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    private Alert alert;

    public void regBtn() {
        if (su_username.getText().isEmpty() || su_password.getText().isEmpty()
                || su_question.getSelectionModel().getSelectedItem() == null
                || su_answer.getText().isEmpty()) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");;
            alert.setHeaderText(null);
            alert.setContentText("Vui lòng điền đầy đủ");
            alert.showAndWait();

        } else {
            String regData = "INSERT INTO employee(username,password,question,answer)" + "VALUES(?,?,?,?)";
            connect = database.connectDB();
            try {
                prepare = connect.prepareStatement(regData);
                prepare.setString(1, su_username.getText());
                prepare.setString(2, su_password.getText());
                prepare.setString(3,(String) su_question.getSelectionModel().getSelectedItem());
                prepare.setString(4, su_answer.getText());
                prepare.executeUpdate();

                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information");;
                alert.setHeaderText(null);
                alert.setContentText("Thành công!");
                alert.showAndWait();

                su_username.setText("");
                su_password.setText("");
                su_question.getSelectionModel().clearSelection();
                su_answer.setText("");
                
                TranslateTransition slider = new TranslateTransition();

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

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    private String[] questionList = {"Who is your BFF?", "Anh 7 có bao nhiêu C1?", "Đội bóng nhà vua?"};

    public void regLquestionList() {
        List<String> listQ = new ArrayList<>();

        for (String data : questionList) {
            listQ.add(data);
        }
        ObservableList listData = FXCollections.observableArrayList(listQ);
        su_question.setItems(listData);
    }

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

                regLquestionList();
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
