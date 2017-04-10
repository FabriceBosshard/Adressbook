package sample.Filter;

import sample.Model.Adress;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by igorcetkovic on 03.04.17.
 */
public class Filter {
    ArrayList<Adress> book = null;
    ArrayList<Adress> filteredBook = new ArrayList<>();
    public Filter(ArrayList<Adress> list) {
        book = list;

        for (Adress a : book) {
            filteredBook.add(a);
        }
    }


    public void ResetFilter() {
        for (Adress a : book) {
            filteredBook.add(a);
        }
    }

    public void FilterName(String name) {
        filteredBook = new ArrayList<>();

        for (Adress a : book) {
            if (a.getName() == name) {
                filteredBook.add(a);
            }
        }
    }

    public void FilterPhone(String phone){
        filteredBook = new ArrayList<>();

        for (Adress a : book) {
            if (a.getTelephone() == phone) {
                filteredBook.add(a);
            }
        }
    }

    public ArrayList<Adress> getFilteredBook() {
        return filteredBook;
    }
}
