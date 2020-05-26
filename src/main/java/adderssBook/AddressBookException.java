package adderssBook;

public class AddressBookException extends Throwable {
   enum  ExceptionType {
       NO_ADDRESS_BOOK_FOUND,FILE_PROBLEM, DUPLICATE_NAME;
   }
    ExceptionType type;
    public AddressBookException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}
