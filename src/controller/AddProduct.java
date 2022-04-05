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
import model.Product;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
/** This class is the controller for the AddProduct.fxml page for the Add Product scene.
 * RUNTIME ERROR: Initially, under the onAddPart method, I tried to add the part directly to the list of associated
 * parts for the Product. It did not work, because the Product object had not yet been created. Once I went back and
 * created a new list just for the table, the issue was resolved. */
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


    public Label warningLabel;

    public Inventory inventory;

    public ObservableList<Part> bottomTableList = FXCollections.observableArrayList();

    public static int prodAutoId = 100;


    /** This causes the tables to populate with specific lists of parts and controls which attributes go to which
     * columns. */
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
    /** This has the table display results based on what is entered into the search bar. */
    public void getResultsParts2(ActionEvent actionEvent) {
        warningLabel.setText("");
        try {
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
                warningLabel.setText("Part could not be found. Please try a new search.");
            }
        }
        catch (NumberFormatException e) {
            warningLabel.setText("Part could not be found. Please try a new search.");
        }
    }

    /** This adds a part from the list of all parts to the list of associated parts for the product being created. */
    public void onAddButton(ActionEvent actionEvent) {
        warningLabel.setText("");

        if(partsTable2.getSelectionModel().getSelectedItem() == null) {
            warningLabel.setText("Please select a part to add");
        }
        else {
            Part sPart = (Part) partsTable2.getSelectionModel().getSelectedItem();
            bottomTableList.add(sPart);
        }
    }
    /** Without saving any changes, this returns to the Main Screen. */
    public void onCancelButton(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../view/MainScreen.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 850, 750);
        stage.setTitle("Inventory Management");
        stage.setScene(scene);
        stage.show();
    }
    /** This deletes a part from the associated parts list. */
    public void onRemoveButton(ActionEvent actionEvent) {
        warningLabel.setText("");
        if(associatedPartsTable.getSelectionModel().getSelectedItem() == null) {
            warningLabel.setText("Please select a part to remove");
        }
        else {
            Part sPart = (Part) associatedPartsTable.getSelectionModel().getSelectedItem();
            bottomTableList.remove(sPart);
        }
    }
    /** This creates a new Product object based on user input, assigns the product a unique ID, adds the product to the
     * list of all products, and returns to the Main Screen. */
    public void onSaveButton(ActionEvent actionEvent) throws IOException {
        prodAutoId += 2;

        warningLabel.setText("");
        try {
            if (prodNameTF.getText() == "") {
                warningLabel.setText("Please enter valid values in text fields");
            } else if (Integer.parseInt(prodMinTF.getText()) >= Integer.parseInt(prodMaxTF.getText())) {
                warningLabel.setText("Min must be less than max");
            } else if (Integer.parseInt(prodMinTF.getText()) > Integer.parseInt(prodStockTF.getText())) {
                warningLabel.setText("Inventory level must be greater than or equal to min");
            } else if (Integer.parseInt(prodMaxTF.getText()) < Integer.parseInt(prodStockTF.getText())) {
                warningLabel.setText("Inventory level must be less than or equal to max");
            } else {

                Product product = new Product(prodAutoId, prodNameTF.getText(),
                        Double.parseDouble(prodPriceTF.getText()), Integer.parseInt(prodStockTF.getText()),
                        Integer.parseInt(prodMinTF.getText()), Integer.parseInt(prodMaxTF.getText()));

                inventory.addProduct(product);

                for (Part items : bottomTableList) {
                    product.addAssociatedPart(items);
                }


                Parent root = FXMLLoader.load(getClass().getResource("../view/MainScreen.fxml"));
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                Scene scene = new Scene(root, 850, 750);
                stage.setTitle("Inventory Management");
                stage.setScene(scene);
                stage.show();
            }
        }
        catch (NumberFormatException e) {
            warningLabel.setText("Please enter valid values in text fields");
        }

    }
}


