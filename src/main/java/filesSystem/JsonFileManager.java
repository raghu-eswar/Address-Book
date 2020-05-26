package filesSystem;

import adderssBook.AddressBook;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class JsonFileManager implements FileManager {
    Gson gson = new Gson();

    @Override
    public boolean writeInto(File file, AddressBook addressBook) {

        try {
            Writer writer = new FileWriter(file);
            writer.write(gson.toJson(addressBook));
            writer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
