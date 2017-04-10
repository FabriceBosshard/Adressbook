package sample.Controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Model.Adress;
import sample.Model.Adressbook;
import sample.Save.SaveToJson;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Fabrice on 27.03.2017.
 */
public class ControllerEmployee implements Initializable {

    @FXML
    private TextField name;
    @FXML
    private TextField surname;
    @FXML
    private TextField birthdate;
    @FXML
    private TextField adress;
    @FXML
    private TextField email;
    @FXML
    private TextField telephone;
    @FXML
    private Button abbort;
    @FXML
    private Button createEmployee;

    String inputName;
    String inputSurname;
    String inputAdress;
    String inputEmail;
    String inputTelephone;
    String inputBirthdate;


    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert name != null : "fx:id=\"name\" was not injected: check your FXML file 'simple.fxml'.";

        abbort.setOnAction((event)->{
            Stage stage = (Stage) abbort.getScene().getWindow();
            stage.close();
        });

        createEmployee.setOnAction((event)->{
            inputAdress = adress.getText();
            inputBirthdate = birthdate.getText();
            inputEmail = email.getText();
            inputName = name.getText();
            inputSurname = surname.getText();
            inputTelephone = telephone.getText();

            if (checkValidation()){
                createNew(inputAdress,inputBirthdate,inputEmail,inputSurname,inputTelephone,inputName);
                Stage stage = (Stage) createEmployee.getScene().getWindow();
                stage.close();
            }
        });
    }
    public void createNew(String adress,String birthdate,String email,String surname, String telephone,String name){
        Adressbook.adressbook.add(new Adress(name,surname,birthdate,adress,email,telephone));
        System.out.println(adress+birthdate+email+surname+telephone+name);
        for (Adress a: Adressbook.adressbook){
            System.out.println(a.getBirthdate());
            System.out.println(a.getAddress());
            System.out.println(a.getEmail());
            System.out.println(a.getSurname());
            System.out.println(a.getTelephone());
        }
        SaveToJson.Save();
    }
    public Boolean checkValidation(){
        adress.setStyle("-fx-background-color: #FFFFFF;");
        name.setStyle("-fx-background-color: #FFFFFF;");
        telephone.setStyle("-fx-background-color: #FFFFFF;");
        birthdate.setStyle("-fx-background-color: #FFFFFF;");
        surname.setStyle("-fx-background-color: #FFFFFF;");
        email.setStyle("-fx-background-color: #FFFFFF;");

        Boolean flag = false;
        if (adress.getText().isEmpty() || birthdate.getText().isEmpty()
                || email.getText().isEmpty() || name.getText().isEmpty()
                ||surname.getText().isEmpty()|| telephone.getText().isEmpty()){
            if (adress.getText().isEmpty()){
                adress.setStyle("-fx-background-color: #FF69B4;");
            }
            if (telephone.getText().isEmpty()){
                telephone.setStyle("-fx-background-color: #FF69B4;");
            }
            if (surname.getText().isEmpty()){
                surname.setStyle("-fx-background-color: #FF69B4;");
            }
            if (email.getText().isEmpty()){
                email.setStyle("-fx-background-color: #FF69B4;");
            }
            if (name.getText().isEmpty()){
                name.setStyle("-fx-background-color: #FF69B4;");
            }
            if (birthdate.getText().isEmpty()){
                birthdate.setStyle("-fx-background-color: #FF69B4;");
            }
            flag=true;
        }
        if (!isValidEmailAddress(email.getText())){
            email.setStyle("-fx-background-color: #FF69B4;");
            flag=true;
        }if (!isValidTelephone(telephone.getText())){
            telephone.setStyle("-fx-background-color: #FF69B4;");
            flag=true;
        }if (!isValidDate(birthdate.getText())){
            birthdate.setStyle("-fx-background-color: #FF69B4;");
            flag=true;
        }
        if (flag){
            return false;
        }else{
            return true;
        }
    }
    public boolean isValidEmailAddress(String emailAddress){
        String  expression="^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = emailAddress;
        Pattern pattern = Pattern.compile(expression,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        return matcher.matches();

    }
    public boolean isValidTelephone(String tel) {
        Pattern pattern = Pattern.compile("\\d{3} \\d{3} \\d{2} \\d{2}");
        Matcher matcher = pattern.matcher(tel);

        Pattern pattern2 = Pattern.compile("\\d{3}\\d{3}\\d{2}\\d{2}");
        Matcher matcher2 = pattern2.matcher(tel);

        Boolean flag = false;

        if (matcher.matches()){
            flag=true;
        }
        else if (matcher2.matches()){
            flag=true;
        }
        if (flag){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean isValidDate(String date){
        Pattern pattern = Pattern.compile("\\d{2}.\\d{2}.\\d{4}");
        Matcher matcher = pattern.matcher(date);
        return matcher.matches();
    }
}
