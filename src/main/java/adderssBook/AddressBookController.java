package adderssBook;

import filesSystem.FileManager;
import filesSystem.FileManagerFactory;

import java.io.File;
import java.io.IOException;

public class AddressBookController {

    static final String PATH = "./src/main/resources/";
    FileManager fileManager;
    public AddressBookController() {
        this.fileManager = new FileManagerFactory().getFileManager();
    }

    public boolean createNewBook(String bookName) {
        File newBook = new File(PATH+bookName+".json");
        boolean isBookCreated = false;
        try {
            isBookCreated = newBook.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (isBookCreated) {
            fileManager.writeInto(newBook, new AddressBook(bookName));
        }
        return isBookCreated;
    }

}
