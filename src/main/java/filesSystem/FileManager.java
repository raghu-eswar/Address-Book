package filesSystem;

import adderssBook.AddressBook;

import java.io.File;

public interface FileManager {

    boolean writeInto(File file, AddressBook addressBook);
}
