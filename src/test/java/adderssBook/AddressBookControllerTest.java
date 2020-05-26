package adderssBook;

import org.junit.Assert;
import org.junit.Test;

public class AddressBookControllerTest {
    static AddressBookController controller = new AddressBookController();

    @Test
    public void forGivenProperName_AddressBookController_ShouldCreateNewBook() {
        boolean status = controller.createNewBook("test");
        Assert.assertTrue(status);
    }

    @Test
    public void forGivenDuplicateName_AddressBookController_ShouldNotCreateNewBook() {
        boolean status = controller.createNewBook("error");
        Assert.assertFalse(status);
    }

    @Test
    public void forGivenProperName_AddressBookController_ShouldReturnNumberOfRecords() {
       int numberOfRecords = controller.loadAddressBook("test");
        Assert.assertEquals(0,numberOfRecords);
    }

}
