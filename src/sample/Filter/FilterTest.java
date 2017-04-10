package sample.Filter;

import sample.Model.Adress;

import java.util.ArrayList;

/**
 * Created by igorcetkovic on 03.04.17.
 */
public class FilterTest {
    public static void main(String[] args) {
        ArrayList<Adress> book = new ArrayList<>();

        Adress a = new Adress("Peter", "Hans", "23.23.2323", "SPrangle", "cetk", "123123");
        Adress b = new Adress("Hans", "Hans", "23.23.2323", "SPrangle", "cetk", "1234");
        Adress c = new Adress("Peter", "Hans", "23.23.2323", "SPrangle", "cetk", "123");

        book.add(a);
        book.add(c);
        book.add(b);

        Filter f = new Filter(book);
        f.FilterName("Peter");


        for (Adress s : f.getFilteredBook()) {
            System.out.println(s.getName());
        }
    }
}
