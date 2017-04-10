package sample.Load;

import com.sun.jndi.cosnaming.IiopUrl;
import javafx.collections.ObservableList;
import sample.Model.Adress;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import sample.Model.Adress;
import sample.Model.Adressbook;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.MonthDay;
import java.util.ArrayList;
import java.util.Map.Entry;


/**
 * Created by igorcetkovic on 27.03.17.
 */
public class LoadFromJson {
    private JsonParser parser;


    public void Load(String path) throws FileNotFoundException {
        parser = new JsonParser();
        Object obj = parser.parse(new FileReader(path));

        JsonArray addressBook = (JsonArray) obj;

        for (JsonElement j : addressBook) {
            JsonObject jsonObject = j.getAsJsonObject();
            Adressbook.adressbook.add(
                new Adress(
                        jsonObject.get("name").getAsString(),
                        jsonObject.get("surname").getAsString(),
                        jsonObject.get("birthdate").getAsString(),
                        jsonObject.get("address").getAsString(),
                        jsonObject.get("email").getAsString(),
                        jsonObject.get("telephone").getAsString()
                )
            );

        }
    }
}
