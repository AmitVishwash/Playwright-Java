package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
   static  Properties properties = null;


    public static String getPropertyValue(String key) {
        try (FileInputStream fileInputStream = new FileInputStream("app.properties")) {
            properties = new Properties();
            try {
                properties.load(fileInputStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
       return properties.getProperty(key);
    }
}
