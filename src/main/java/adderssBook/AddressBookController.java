package adderssBook;

import filesSystem.FileManager;

import java.io.File;
import java.io.IOException;

public class AddressBookController {

    static final String PATH = "./src/main/resources/";
    FileManager fileManager;

    public boolean createNewBook(String bookName) {
        File newBook = new File(PATH+bookName+".json");
        boolean isBookCreated = false;
        try {
            isBookCreated = newBook.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (isBookCreated) {

        }
        return isBookCreated;
    }
}
