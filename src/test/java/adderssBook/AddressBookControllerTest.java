package adderssBook;

import org.junit.Assert;
import org.junit.Test;

public class AddressBookControllerTest {
    static AddressBookController controller = new AddressBookController();

    @Test
    public void forGivenProperName_AddressBookController_ShouldCreateNewBook() {
        boolean status = false;
        try {
            status = controller.createNewBook("test");
        } catch (AddressBookException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(status);
    }

    @Test
    public void forGivenDuplicateName_AddressBookController_ShouldThrowException() {
        try {
            controller.createNewBook("error");
        } catch (AddressBookException e) {
            Assert.assertEquals(AddressBookException.ExceptionType.DUPLICATE_NAME, e.type);
        }
    }

    @Test
    public void forGivenProperName_AddressBookController_ShouldReturnNumberOfRecords()  {
        int numberOfRecords = 0;
        try {
            numberOfRecords = controller.loadAddressBook("test");
        } catch (AddressBookException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(0,numberOfRecords);
    }

    @Test
    public void forGivenWrongFileName_AddressBookController_ShouldThrowException()  {
        try {
           controller.loadAddressBook("test1");
        } catch (AddressBookException e) {
            Assert.assertEquals(AddressBookException.ExceptionType.NO_ADDRESS_BOOK_FOUND, e.type);
        }
    }
}
