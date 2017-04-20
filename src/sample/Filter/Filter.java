package sample.Filter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Model.Adress;
import java.util.regex.Pattern;

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
            if (Pattern.matches(name,a.getName())) {
                filteredBook.add(a);
            }else if (Pattern.matches(name,a.getSurname())){
                filteredBook.add(a);
            }
        }
        return filteredBook;
    }

    public ObservableList<Adress> FilterPhone(String phone){
        filteredBook = FXCollections.observableArrayList();
        for (Adress a : book) {
            if (Pattern.matches(phone,a.getTelephone())) {
                filteredBook.add(a);
            }
        }
        return filteredBook;
    }
    public ObservableList<Adress> getFilteredBook(){
        return filteredBook;
    }

    public ObservableList FilterNamePhone(String tempName, String tempTel) {
        filteredBook = FXCollections.observableArrayList();

        for (Adress a : book) {
            if (Pattern.matches(tempTel,a.getTelephone()) && Pattern.matches(tempName,a.getName())) {
                filteredBook.add(a);
            }else if (Pattern.matches(tempTel,a.getTelephone()) && Pattern.matches(tempName,a.getSurname())){
                filteredBook.add(a);
            }
        }
        return filteredBook;
    }
}
