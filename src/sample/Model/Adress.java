package sample.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Fabrice on 27.03.2017.
 */
public class Adress {

    private String name;
    private String surname;
    private String birthdate;
    private String address;
    private String email;
    private String telephone;
    private UUID ID;

    public Adress(String name, String forname, String birthdate, String adress, String email, String telephone){
        this.name = name;
        this.surname = forname;
        this.birthdate = birthdate;
        this.address = adress;
        this.email = email;
        this.telephone = telephone;
        this.ID = UUID.randomUUID();
    }

    public Adress() {

    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public UUID getID() {
        return ID;
    }
}
