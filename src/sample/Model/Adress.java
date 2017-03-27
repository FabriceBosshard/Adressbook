package sample.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fabrice on 27.03.2017.
 */
public class Adress {

    public String name;
    public String surname;
    public String birthdate;
    public String address;
    public String email;
    public String telephone;


    public Adress(String name, String forname, String birthdate, String adress, String email, String telephone){
        this.name = name;
        this.surname = forname;
        this.birthdate = birthdate;
        this.address = adress;
        this.email = email;
        this.telephone = telephone;
    }

    public Adress CreateAdress(String name, String forname, String birthdate,String adress, String email, String telephone){
        Adress member = new Adress(name,forname,birthdate,adress,email,telephone);

        return member;
    }
}
