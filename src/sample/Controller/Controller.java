package sample.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.Main;
import sample.Model.Adressbook;

public class Controller implements Initializable{

    @FXML
    private Button save;
    @FXML
    private TextField searchName;
    @FXML
    private TextField searchTel;
    @FXML
    private Button newEmployee;
    @FXML
    private Button delete;

    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert save != null : "fx:id=\"myButton\" was not injected: check your FXML file 'simple.fxml'.";


        save.setOnAction((event)->{
            Adressbook.saveAdressbook();
        });

        newEmployee.setOnAction((event)->{
            Pane root;
            try {
                root = (Pane) FXMLLoader.load(Controller.class.getResource("View/employeePage.fxml"));
                Stage stage = new Stage();
                stage.setTitle("Neuer Mitarbeiter");
                stage.setScene(new Scene(root));
                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        delete.setOnAction((event)->{

        });
    }
}
