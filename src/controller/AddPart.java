package controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

import java.net.URL;
import java.util.ResourceBundle;

public class AddPart implements Initializable {

    public Label machineIdLabel;
    public RadioButton inHouse;
    public RadioButton outsourced;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void onOutsourced(ActionEvent actionEvent) {
    }

    public void onInHouse(ActionEvent actionEvent) {
    }
}