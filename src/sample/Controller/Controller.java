package sample.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.UUID;
import java.util.logging.Filter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
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
    private Label outputDate;
    @FXML
    private Label outputName;
    @FXML
    private Label outputSurname;
    @FXML
    private Label outputAdress;
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
    @FXML
    private MenuItem info;
    @FXML
    private MenuItem about;
    @FXML
    private Button deleteFilter;

    private TableView table = new TableView();
    private int selectedItem;
    public static Boolean IsAlter = false;
    public static UUID ID;

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

        deleteFilter.setOnAction((event) -> {
            table.setItems(Adressbook.adressbook);
            searchName.setText("");
            searchTel.setText("");
            selectedItem = 0;

            showDetailView();
        });

        apply.setOnAction((event) -> {

            ObservableList<Adress> tempBook = Adressbook.adressbook;
            sample.Filter.Filter filt = new sample.Filter.Filter(tempBook);

            if (!searchTel.getText().isEmpty() && searchName.getText().isEmpty()) {
                String temp = searchTel.getText();
                table.setItems(filt.FilterPhone(temp));
            }
            if (!searchName.getText().isEmpty() && searchTel.getText().isEmpty()) {
                String temp = searchName.getText();
                table.setItems(filt.FilterName(temp));
            }
            if (!searchName.getText().isEmpty() && !searchTel.getText().isEmpty())
            {
                String tempTel = searchTel.getText();
                String tempName = searchName.getText();
                table.setItems(filt.FilterNamePhone(tempName,tempTel));
            }
            selectedItem = 0;
            showDetailView();
        });

        table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                selectedItem = table.getSelectionModel().selectedIndexProperty().get();

                showDetailView();
            }
        });

        table.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
                    selectedItem = table.getSelectionModel().selectedIndexProperty().get();

                    ID = Adressbook.adressbook.get(selectedItem).getID();
                    IsAlter = true;

                    Stage employeeStage = new Stage();
                    try {
                        Pane page = (Pane) FXMLLoader.load(Main.class.getResource("View/employeePage.fxml"));
                        Scene scene = new Scene(page);
                        employeeStage.setScene(scene);
                        employeeStage.setTitle("Mitarbeiter Bearbeiten");
                        employeeStage.setResizable(false);
                        employeeStage.show();
                    } catch (Exception ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        delete.setOnAction((event) -> {
            deleteDataRow();
            table.getSelectionModel().clearSelection();
        });

        save.setOnAction((event) -> {
            SaveToJson.Save();
        });

        newEmployee.setOnAction((event) -> {
            Stage employeeStage = new Stage();
            try {
                Pane page = (Pane) FXMLLoader.load(Main.class.getResource("View/employeePage.fxml"));
                Scene scene = new Scene(page);
                employeeStage.setScene(scene);
                employeeStage.setTitle("Neuer Mitarbeiter");
                employeeStage.show();
            } catch (Exception ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        info.setOnAction((event) -> {
            Stage infoStage = new Stage();

            try {
                Pane page = (Pane) FXMLLoader.load(Main.class.getResource("View/infoStage.fxml"));
                Scene scene = new Scene(page);

                infoStage.setScene(scene);
                infoStage.setTitle("Info");
                infoStage.setResizable(false);
                infoStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        about.setOnAction((event) -> {
            Stage aboutStage = new Stage();


            try {
                Pane page = (Pane) FXMLLoader.load(Main.class.getResource("View/about.fxml"));
                Scene scene = new Scene(page);

                aboutStage.setScene(scene);
                aboutStage.setTitle("About");
                aboutStage.setResizable(false);
                aboutStage.show();
            } catch (Exception ex) {
                ex.printStackTrace();
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
        Adress sample;
        ObservableList<Adress> temp;
        temp = table.getItems();
        sample = temp.get(selectedItem);

        outputAdress.setText(sample.getAddress());
        outputDate.setText(sample.getBirthdate());
        outputEmail.setText(sample.getEmail());
        outputName.setText(sample.getName());
        outputSurname.setText(sample.getSurname());
        outputTel.setText(sample.getTelephone());

    }

    private void deleteDataRow() {
        Adress sample;
        ObservableList<Adress> temp;
        temp = table.getItems();
        sample = temp.get(selectedItem);
        Adressbook.adressbook.remove(sample);
        temp.remove(sample);

        table.setItems(temp);
    }
}
