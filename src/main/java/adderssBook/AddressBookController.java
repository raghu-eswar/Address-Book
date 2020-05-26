package adderssBook;

import filesSystem.FileManager;
import filesSystem.FileManagerFactory;

import java.io.File;
import java.io.FileNotFoundException;
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

    public boolean createNewBook(String bookName) throws AddressBookException {
        File newBook = new File(PATH+bookName+".json");
        try {
            boolean isBookCreated = newBook.createNewFile();
            if (!isBookCreated)
                throw new AddressBookException("Existing book with name "+bookName, AddressBookException.ExceptionType.DUPLICATE_NAME);
            fileManager.writeInto(newBook, new AddressBook(bookName));
        } catch (IOException e) {
            throw new AddressBookException(e.getMessage(), AddressBookException.ExceptionType.FILE_PROBLEM);
        }
        return true;
    }

    public int loadAddressBook(String bookName) throws AddressBookException {
        try {
            AddressBook book = fileManager.readFile(PATH + bookName + ".json", AddressBook.class);
            addressBooks.put(book.bookName, book);
            return book.personsData.size();
        } catch (FileNotFoundException e) {
            throw new AddressBookException(e.getMessage(), AddressBookException.ExceptionType.NO_ADDRESS_BOOK_FOUND);
        } catch (IOException e) {
            throw new AddressBookException(e.getMessage(), AddressBookException.ExceptionType.FILE_PROBLEM);
        }
    }

}
