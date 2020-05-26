package filesSystem;

import adderssBook.AddressBook;
import com.google.gson.Gson;

import java.io.*;

public class JsonFileManager implements FileManager {
    Gson gson = new Gson();

    @Override
    public boolean writeInto(File file, Object object) {

        try {
            Writer writer = new FileWriter(file);
            writer.write(gson.toJson(object));
            writer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public <E> E readFile(String path, Class<E> eClass) {
        try (Reader reader = new FileReader(new File(path))){
            BufferedReader bufferedReader = new BufferedReader(reader);
            return gson.fromJson(bufferedReader, eClass);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}





