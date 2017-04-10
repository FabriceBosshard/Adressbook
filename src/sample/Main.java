package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.Load.LoadFromJson;
import sample.Model.Adress;
import sample.Model.Adressbook;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        try {
            Pane page = (Pane) FXMLLoader.load(Main.class.getResource("View/sample.fxml"));
            Scene scene = new Scene(page);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Adressbuch");
            primaryStage.show();
        }
        catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public static void main(String[] args) {
        LoadFromJson LFJ = new LoadFromJson();
        try{
            LFJ.Load("AddressBook.json");
        }catch(FileNotFoundException e){
            System.out.println("File not found");
        }

        launch(args);


    }
}
