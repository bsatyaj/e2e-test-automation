package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static final Properties prop = new Properties();

    public static String getValueBy(String envFileName, String key) {
        String filePath = "../core/src/main/resources/envconfig/" + envFileName + ".properties";
        try {
            FileInputStream fis = new FileInputStream(filePath);
            prop.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return prop.getProperty(key);
    }
}
