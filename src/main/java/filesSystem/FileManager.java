package filesSystem;

import java.io.File;

public interface FileManager {

    boolean writeInto(File file, Object object);

    <E> E readFile(String path, Class<E> eClass);
}
