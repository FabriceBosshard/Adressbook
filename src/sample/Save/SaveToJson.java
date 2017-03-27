package sample.Save;

import com.google.gson.*;
import sample.Model.Adress;
import sample.Model.Adressbook;

import java.io.FileWriter;
import java.io.Writer;

/**
 * Created by igorcetkovic on 27.03.17.
 */
public class SaveToJson {

    public void Save() {
        try (Writer writer = new FileWriter("AddressBook.json")) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(Adressbook.adressbook, writer);
        }
        catch (Exception ex) {

        }
    }




}
