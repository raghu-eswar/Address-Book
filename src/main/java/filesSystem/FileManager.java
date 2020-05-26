package filesSystem;

import adderssBook.AddressBook;

import java.io.File;
import java.io.IOException;

public interface FileManager {

    boolean writeInto(File file, Object object)throws IOException;

    <E> E readFile(String path, Class<E> eClass)throws IOException;
}
