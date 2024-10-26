package passwordgen.app.passwordGenerator;

import java.io.*;
import java.util.Properties;

public class ConfigManager {
    private Properties properties;
    private final String filePath;

    public ConfigManager(String filePath) {
        this.filePath = filePath;
        properties = new Properties();
        load();
    }

    private void load() {
        try (InputStream input = new FileInputStream(filePath)) {
            properties.load(input);
        } catch (IOException e) {
            System.out.println("Could not load settings: " + e.getMessage());
        }
    }

    public void save() {
        try (OutputStream output = new FileOutputStream(filePath)) {
            properties.store(output, null);
        } catch (IOException e) {
            System.out.println("Could not save settings: " + e.getMessage());
        }
    }

    public String get(String key) {
        return properties.getProperty(key);
    }

    public void set(String key, String value) {
        properties.setProperty(key, value);
    }
}
