package adderssBook;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

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

    @Test
    public void forGivenProperName_displayBook_ShouldCorrectRecords() {
        try {
            controller.loadAddressBook("test");
            List<PersonDTO> book = controller.displayBook("test");
            Assert.assertEquals(2,book.size());
        } catch (AddressBookException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void forGivenProperName_withoutLoadingData_ShouldThrowException() {
        try {
            controller.displayBook("test");
        } catch (AddressBookException e) {
            Assert.assertEquals(AddressBookException.ExceptionType.NO_DATA, e.type);
        }
    }

    @Test
    public void forGivenProperName_addNewDataWithSave_ShouldAddNewRecords() {
        try {
            controller.loadAddressBook("test");
            List<PersonDTO> book = controller.displayBook("test");
            controller.addNewData("test","raghu", "eswar", "7777777777", "guntur","ap","11111");
            controller.save("test");
            List<PersonDTO> newBook = controller.displayBook("test");
            Assert.assertEquals(book.size()+1, newBook.size());
        } catch (AddressBookException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void forGivenProperName_addNewDataWithOutSave_ShouldNotAddNewRecords() {
        try {
            controller.loadAddressBook("test");
            List<PersonDTO> book = controller.displayBook("test");
            controller.addNewData("test","raghu", "eswar", "7777777777", "guntur","ap","11111");
            AddressBookController controller1 = new AddressBookController();
            controller1.loadAddressBook("test");
            List<PersonDTO> newBook = controller1.displayBook("test");
            Assert.assertEquals(book.size(), newBook.size());
        } catch (AddressBookException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void forGivenDuplicateName_addNewDataWithSave_ShouldNotAddNewRecords() {
        try {
            controller.loadAddressBook("test");
            List<PersonDTO> book = controller.displayBook("test");
            controller.addNewData("test","raghu", "eswar", "7777777777", "guntur","ap","11111");
            controller.save("test");
            List<PersonDTO> newBook = controller.displayBook("test");
            Assert.assertEquals(book.size(), newBook.size());
        } catch (AddressBookException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void forGivenBookNamePhoneNumber_getPersonDetails_ShouldReturnCorrectRecord() {
        try {
            controller.loadAddressBook("test");
            PersonDTO person = controller.getPersonDetails("test", "8888888888");
            Assert.assertEquals("8888888888", person.phoneNumber);
        } catch (AddressBookException e) {
            e.printStackTrace();
        }
    }

}




