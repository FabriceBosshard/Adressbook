package sample.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.Model.Adressbook;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Fabrice on 27.03.2017.
 */
public class ControllerEmployee implements Initializable {

    @FXML
    public TextField name;
    @FXML
    public TextField surname;
    @FXML
    public TextField birthdate;
    @FXML
    public TextField adress;
    @FXML
    public TextField email;
    @FXML
    public TextField telephone;


    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert name != null : "fx:id=\"myButton\" was not injected: check your FXML file 'simple.fxml'.";
    }
}
