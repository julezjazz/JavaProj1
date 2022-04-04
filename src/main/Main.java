package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**This class creates an app that displays our screens.
 * FUTURE ENHANCEMENT: This app could have a build feature that would remove parts from inventory whenever a product
 * that used those parts was built. In addition, it would add to the inventory number for the product that had been
 * built.
 * Runtime error is located in the first comment of AddProduct.java. */
public class Main extends Application {

    /** This method causes our MainScreen to display as the app starts. */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../view/MainScreen.fxml"));
        primaryStage.setTitle("Inventory Management");
        primaryStage.setScene(new Scene(root, 850, 750));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
