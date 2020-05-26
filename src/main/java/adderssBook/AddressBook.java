package adderssBook;

import java.util.LinkedHashMap;
import java.util.Map;

public class AddressBook {
    public String bookName;
    public Map<String, PersonInfo> personsData;

    public AddressBook(String bookName) {
        this.bookName = bookName;
        this.personsData = new LinkedHashMap<>();
    }

    @Override
    public String toString() {
        return "AddressBook{" +
                "bookName='" + bookName + '\'' +
                ", personsData=" + personsData +
                '}';
    }
}
