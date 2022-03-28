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

public class AddProduct implements Initializable {

    public TableView partsTable2;

    public TableColumn partIdCol2;
    public TableColumn partNameCol2;
    public TableColumn partInvLevelCol2;
    public TableColumn partPriceCol2;

    public TextField searchBarPart2;

    public Label warningLabel2;

    public Inventory inventory;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        partsTable2.setItems(inventory.getAllParts());

        partIdCol2.setCellValueFactory(new PropertyValueFactory<>("id"));
        partNameCol2.setCellValueFactory(new PropertyValueFactory<>("name"));
        partInvLevelCol2.setCellValueFactory(new PropertyValueFactory<>("stock"));
        partPriceCol2.setCellValueFactory(new PropertyValueFactory<>("price"));
    }

    public void getResultsParts2(ActionEvent actionEvent) {
        warningLabel2.setText("");

        String s = searchBarPart2.getText();

        ObservableList<Part> parts = inventory.lookupPart(s);

        partsTable2.setItems(parts);
        searchBarPart2.setText("");

        if (parts.size() == 0) {

            int id = Integer.parseInt(s);
            Part part = inventory.lookupPart(id);
            if (part != null)
                parts.add(part);
        }
        if (parts.size() == 0) {
            warningLabel2.setText("Part could not be found. Please try a new search.");
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


