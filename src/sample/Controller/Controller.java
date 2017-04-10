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
import sample.Save.SaveToJson;

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
            SaveToJson.Save();
        });

        newEmployee.setOnAction((event)->{
            Stage employeeStage = new Stage();
            try {
                Pane page = (Pane) FXMLLoader.load(Main.class.getResource("View/employeePage.fxml"));
                Scene scene = new Scene(page);
                employeeStage.setScene(scene);
                employeeStage.setTitle("Neuer Mitarbeiter");
                employeeStage.show();
            }
            catch (Exception ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        delete.setOnAction((event)->{

        });
    }
}
