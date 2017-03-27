package sample.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.Model.Adress;
import sample.Model.Adressbook;

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

    String inputName;
    String inputSurname;
    String inputAdress;
    String inputEmail;
    String inputTelephone;
    String inputBirthdate;


    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert name != null : "fx:id=\"name\" was not injected: check your FXML file 'simple.fxml'.";

        abbort.setOnAction((event)->{

        });
        newEmployee.setOnAction((event)->{
            inputAdress = adress.getText();
            inputBirthdate = birthdate.getText();
            inputEmail = email.getText();
            inputName = email.getText();
            inputSurname = email.getText();
            inputTelephone = telephone.getText();

            createNew(inputAdress,inputBirthdate,inputEmail,inputSurname,inputTelephone,inputName);
        });
    }
    public void createNew(String adress,String birthdate,String email,String surname, String telephone,String name){
        Adressbook.adressbook.add(new Adress(name,surname,birthdate,adress,email,telephone));
    }
    public void checkValidation(){}
}
