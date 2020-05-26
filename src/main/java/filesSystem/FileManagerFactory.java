package filesSystem;

public class FileManagerFactory {

    public FileManager getFileManager() {
        return new JsonFileManager();
    }
}
