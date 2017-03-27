package sample.Load;

import sample.Model.Adress;
import sample.Load.LoadFromJson;
import sample.Model.Adress;
import sample.Model.Adressbook;

import java.io.FileNotFoundException;

/**
 * Created by igorcetkovic on 27.03.17.
 */
public class TestLoad {
    public static void main(String[] args) {
        LoadFromJson loader = new LoadFromJson();
        try {
            loader.Load("Desktop/AddressBookSample.json");

            for (Adress a : Adressbook.adressbook) {
                System.out.println("->Address");
                System.out.println("-->Name: "+a.name);
                System.out.println("-->Surname: "+a.surname);
                System.out.println("-->Birthdate: "+a.birthdate);
                System.out.println("-->Address: "+a.address);
                System.out.println("-->Email: "+a.email);
                System.out.println("-->Telephone: "+a.telephone);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
