package adderssBook;

import filesSystem.FileManager;
import filesSystem.FileManagerFactory;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class AddressBookController {

    static final String PATH = "./src/main/resources/";
    FileManager fileManager;
    private Map<String, AddressBook> addressBooks;
    public AddressBookController() {
        this.fileManager = new FileManagerFactory().getFileManager();
        this.addressBooks = new LinkedHashMap<>();
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

    public int loadAddressBook(String bookName) {
        AddressBook book = fileManager.readFile(PATH+bookName+".json", AddressBook.class);
        addressBooks.put(book.bookName, book);
        return book.personsData.size();
    }

}
