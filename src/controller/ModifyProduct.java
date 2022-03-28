package controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Inventory;
import model.Part;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ModifyProduct implements Initializable {

    public TableView partsTable3;

    public TableColumn partIdCol3;
    public TableColumn partNameCol3;
    public TableColumn partInvLevelCol3;
    public TableColumn partPriceCol3;

    public TextField searchBarPart3;

    public Label warningLabel3;

    public Inventory inventory;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        partsTable3.setItems(inventory.getAllParts());

        partIdCol3.setCellValueFactory(new PropertyValueFactory<>("id"));
        partNameCol3.setCellValueFactory(new PropertyValueFactory<>("name"));
        partInvLevelCol3.setCellValueFactory(new PropertyValueFactory<>("stock"));
        partPriceCol3.setCellValueFactory(new PropertyValueFactory<>("price"));

    }

    public void getResultsParts3(ActionEvent actionEvent) {
        warningLabel3.setText("");

        String s = searchBarPart3.getText();

        ObservableList<Part> parts = inventory.lookupPart(s);

        partsTable3.setItems(parts);
        searchBarPart3.setText("");

        if (parts.size() == 0) {

            int id = Integer.parseInt(s);
            Part part = inventory.lookupPart(id);
            if (part != null)
                parts.add(part);
        }
        if (parts.size() == 0) {
            warningLabel3.setText("Part could not be found. Please try a new search.");
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
