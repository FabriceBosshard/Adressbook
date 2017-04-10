package sample.Load;

import sample.Model.Adress;
import sample.Load.LoadFromJson;
import sample.Model.Adress;
import sample.Model.Adressbook;
import sample.Save.SaveToJson;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created by igorcetkovic on 27.03.17.
 */
public class TestLoad {
    public static void main(String[] args) {
        LoadFromJson loader = new LoadFromJson();
        try {
            loader.Load("AddressBook.json");

            for (Adress a : Adressbook.adressbook) {
                System.out.println("->Address");
                System.out.println("-->Name: "+a.getName());
                System.out.println("-->Surname: "+a.getSurname());
                System.out.println("-->Birthdate: "+a.getBirthdate());
                System.out.println("-->Address: "+a.getAddress());
                System.out.println("-->Email: "+a.getEmail());
                System.out.println("-->Telephone: "+a.getTelephone());
            }

            SaveToJson saveToJson = new SaveToJson();
            saveToJson.Save();

        } catch (FileNotFoundException e) {
            File f = new File("AddressBook.json");
            try {
                f.createNewFile();
            } catch (Exception ex){

            }
                        e.printStackTrace();
        }
    }
}
