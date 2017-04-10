package sample.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Filter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.Main;
import sample.Model.Adress;
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
    private Label outputTel;
    @FXML
    private Label outputEmail;
    @FXML
    private Button newEmployee;
    @FXML
    private Button delete;
    @FXML
    private Button apply;
    @FXML
    private Pane mainPane;

    private TableView table = new TableView();
    private int selectedItem;

    public void fillTableView(){
        table.setEditable(true);

        table.setMinWidth(489);
        table.setMinHeight(402);

        TableColumn name = new TableColumn("Nachname");
        TableColumn surname = new TableColumn("Vorname");
        TableColumn birthdate = new TableColumn("Geburtsdatum");
        TableColumn adress = new TableColumn("Adresse");

        name.setMinWidth(120);
        surname.setMinWidth(119);
        birthdate.setMinWidth(150);
        adress.setMinWidth(100);

        name.setCellValueFactory(
                new PropertyValueFactory<Adress, String>("name"));
        surname.setCellValueFactory(
                new PropertyValueFactory<Adress, String>("surname"));
        birthdate.setCellValueFactory(
                new PropertyValueFactory<Adress, String>("birthdate"));
        adress.setCellValueFactory(
                new PropertyValueFactory<Adress, String>("address"));

        table.setItems(Adressbook.adressbook);
        table.getColumns().addAll(name, surname, birthdate,adress);

        mainPane.getChildren().addAll(table);
    }

    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert save != null : "fx:id=\"myButton\" was not injected: check your FXML file 'simple.fxml'.";
        initializePane();

        apply.setOnAction((event)->{
            delete.setVisible(false);
            ObservableList<Adress> tempBook = table.getItems();
            sample.Filter.Filter filt = new sample.Filter.Filter(tempBook);

            if (!searchTel.getText().isEmpty()){
                String temp = searchTel.getText();
                table.setItems(filt.FilterPhone(temp));
            }
            if(!searchName.getText().isEmpty()){
                String temp = searchName.getText();
                table.setItems(filt.FilterName(temp));
            }
            if(searchName.getText().isEmpty() && searchTel.getText().isEmpty()){
                table.setItems(Adressbook.adressbook);
                delete.setVisible(true);
            }
            showDetailView();
        });

        table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                selectedItem= table.getSelectionModel().selectedIndexProperty().get();

                showDetailView();
            }
        });
        delete.setOnAction((event)->{
            deleteDataRow();
            table.getSelectionModel().clearSelection();
        });

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
    }

    private void initializePane() {
        fillTableView();
        selectedItem=0;
        showDetailView();
        table.getSelectionModel().clearSelection();
    }

    private void showDetailView() {
        outputEmail.setText(Adressbook.adressbook.get(selectedItem).getEmail());
        outputTel.setText(Adressbook.adressbook.get(selectedItem).getTelephone());
    }

    private void deleteDataRow() {
        Adressbook.adressbook.remove(selectedItem);
    }
}
