package sample.Load

import sample.Model.Adress
import sample.Model.Adressbook
import sample.Save.SaveToJson

/**
 * Created by igorcetkovic on 01.05.17.
 */
class TestLoadTest extends GroovyTestCase {
    void testMain() {
        LoadFromJson loader = new LoadFromJson();
        try {
            loader.Load("AddressBook.json");

            for (Adress a : Adressbook.adressbook) {
                Assert(equals(a.getSurname(), "Cetkovic"));
                Assert(equals(a.getName(), "Igor"));
                Assert(equals(a.telephone, "044 444 44 44"));
            }

            SaveToJson saveToJson = new SaveToJson();
            saveToJson.Save();

        } catch (FileNotFoundException e) {
            File f = new File("AddressBook.json");
            try {
                f.createNewFile();
            } catch (Exception ex){
            }
            e.printStackTrace();
        }
    }
}
