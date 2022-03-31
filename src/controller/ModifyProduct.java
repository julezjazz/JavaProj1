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

import static controller.MainScreen.productToModify;

public class ModifyProduct implements Initializable {

    public TableView partsTable3;
    public TableView associatedPartsTable2;

    public TableColumn partIdCol3;
    public TableColumn partNameCol3;
    public TableColumn partInvLevelCol3;
    public TableColumn partPriceCol3;


    public TableColumn aPartIdCol2;
    public TableColumn aPartNameCol2;
    public TableColumn aPartInvLevelCol2;
    public TableColumn aPartPriceCol2;

    public TextField searchBarPart3;
    public TextField prodIdTF;
    public TextField prodNameTF2;
    public TextField prodStockTF2;
    public TextField prodPriceTF2;
    public TextField prodMaxTF2;
    public TextField prodMinTF2;

    public Label warningLabel3;

    public Inventory inventory;

    public ObservableList<Part> bottomTableList2 = FXCollections.observableArrayList();



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        partsTable3.setItems(inventory.getAllParts());

        partIdCol3.setCellValueFactory(new PropertyValueFactory<>("id"));
        partNameCol3.setCellValueFactory(new PropertyValueFactory<>("name"));
        partInvLevelCol3.setCellValueFactory(new PropertyValueFactory<>("stock"));
        partPriceCol3.setCellValueFactory(new PropertyValueFactory<>("price"));

        associatedPartsTable2.setItems(bottomTableList2);

        for (Part items : productToModify.getAllAssociatedParts()) {
            bottomTableList2.add(items);
        }

        aPartIdCol2.setCellValueFactory(new PropertyValueFactory<>("id"));
        aPartNameCol2.setCellValueFactory(new PropertyValueFactory<>("name"));
        aPartInvLevelCol2.setCellValueFactory(new PropertyValueFactory<>("stock"));
        aPartPriceCol2.setCellValueFactory(new PropertyValueFactory<>("price"));

        prodIdTF.setText(Integer.toString(productToModify.getId()));
        prodNameTF2.setText(productToModify.getName());
        prodStockTF2.setText(Integer.toString(productToModify.getStock()));
        prodPriceTF2.setText(Double.toString(productToModify.getPrice()));
        prodMaxTF2.setText(Integer.toString(productToModify.getMax()));
        prodMinTF2.setText(Integer.toString(productToModify.getMin()));



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
