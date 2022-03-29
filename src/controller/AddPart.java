package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.InHouse;
import model.Inventory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddPart implements Initializable {

    public Label toggleLabel;
    public RadioButton inHouse;
    public RadioButton outsourced;

    public TextField nameTF;
    public TextField stockTF;
    public TextField priceTF;
    public TextField maxTF;
    public TextField minTF;
    public TextField toggleTF;

    public Inventory inventory;






    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }

    public void onOutsourced(ActionEvent actionEvent) {
        toggleLabel.setText("Company Name");
    }

    public void onInHouse(ActionEvent actionEvent) {
        toggleLabel.setText("Machine ID");
    }


    public void onSaveButton(ActionEvent actionEvent) throws IOException {
        if(inHouse.isSelected()) {
          InHouse iH = new InHouse(1, nameTF.getText(), Double.parseDouble(priceTF.getText()),
                  Integer.parseInt(stockTF.getText()), Integer.parseInt(minTF.getText()),
                  Integer.parseInt(maxTF.getText()), Integer.parseInt(toggleTF.getText()));

          inventory.addPart(iH);

            Parent root = FXMLLoader.load(getClass().getResource("../view/MainScreen.fxml"));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 850, 750);
            stage.setTitle("Inventory Management");
            stage.setScene(scene);
            stage.show();

        }

    }


    public void onCancelButton(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../view/MainScreen.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 850, 750);
        stage.setTitle("Inventory Management");
        stage.setScene(scene);
        stage.show();
    }
}
