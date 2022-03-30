package controller;

import javafx.collections.FXCollections;
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
    public TableView associatedPartsTable;

    public TableColumn partIdCol2;
    public TableColumn partNameCol2;
    public TableColumn partInvLevelCol2;
    public TableColumn partPriceCol2;

    public TableColumn aPartIdCol;
    public TableColumn aPartNameCol;
    public TableColumn aPartInvLevelCol;
    public TableColumn aPartPriceCol;


    public TextField searchBarPart2;
    public TextField prodNameTF;
    public TextField prodStockTF;
    public TextField prodPriceTF;
    public TextField prodMaxTF;
    public TextField prodMinTF;


    public Label warningLabel2;

    public Inventory inventory;
   // public Product product;

    public ObservableList<Part> bottomTableList = FXCollections.observableArrayList();



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        partsTable2.setItems(inventory.getAllParts());

        partIdCol2.setCellValueFactory(new PropertyValueFactory<>("id"));
        partNameCol2.setCellValueFactory(new PropertyValueFactory<>("name"));
        partInvLevelCol2.setCellValueFactory(new PropertyValueFactory<>("stock"));
        partPriceCol2.setCellValueFactory(new PropertyValueFactory<>("price"));


        associatedPartsTable.setItems(bottomTableList);

        aPartIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        aPartNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        aPartInvLevelCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        aPartPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));


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


    public void onAddButton(ActionEvent actionEvent) {
        Part sPart = (Part) partsTable2.getSelectionModel().getSelectedItem();
        bottomTableList.add(sPart);
    }

    public void onCancelButton(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../view/MainScreen.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 850, 750);
        stage.setTitle("Inventory Management");
        stage.setScene(scene);
        stage.show();
    }

    public void onRemoveButton(ActionEvent actionEvent) {
        Part sPart = (Part) associatedPartsTable.getSelectionModel().getSelectedItem();
        bottomTableList.remove(sPart);
    }

    public void onSaveButton(ActionEvent actionEvent) {
    }
}


