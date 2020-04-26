package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DataManager {

    private static String data;

    public static String getValue(String value) {
        Properties properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("resources/properties/properties.properties");
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        data = properties.getProperty(value);
        return data;
    }
}
