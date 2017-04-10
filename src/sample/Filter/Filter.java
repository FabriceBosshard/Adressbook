package sample.Filter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Model.Adress;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by igorcetkovic on 03.04.17.
 */
public class Filter {
    ObservableList<Adress> book = null;
    public ObservableList<Adress> filteredBook;
    public Filter(ObservableList<Adress> list) {
        book = list;
    }

    public ObservableList<Adress> FilterName(String name) {
        filteredBook = FXCollections.observableArrayList();

        for (Adress a : book) {
            if (a.getName().equals(name)) {
                filteredBook.add(a);
            }else if (a.getSurname().equals(name)){
                filteredBook.add(a);
            }
        }
        return filteredBook;
    }

    public ObservableList<Adress> FilterPhone(String phone){
        filteredBook = FXCollections.observableArrayList();
        for (Adress a : book) {
            if (a.getTelephone().equals(phone)) {
                filteredBook.add(a);
            }
        }
        return filteredBook;
    }
    public ObservableList<Adress> getFilteredBook(){
        return filteredBook;
    }
}
