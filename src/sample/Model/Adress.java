package sample.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fabrice on 27.03.2017.
 */
public class Adress {

    String name;
    String forname;
    String birthdate;
    String adress;
    ArrayList<String> emails = new ArrayList<>();
    ArrayList<String> telephonicadresses = new ArrayList<>();


    public Adress(String name, String forname, String birthdate, String adress){
        this.name = name;
        this.forname = forname;
        this.birthdate = birthdate;
        this.adress = adress;
    }
}
