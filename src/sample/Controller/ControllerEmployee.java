package sample.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
    @FXML
    public Button abbort;
    @FXML
    public Button newEmployee;


    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert name != null : "fx:id=\"myButton\" was not injected: check your FXML file 'simple.fxml'.";

        abbort.setOnAction((event)->{
            
        });
        newEmployee.setOnAction((event)->{

        });
    }
}
