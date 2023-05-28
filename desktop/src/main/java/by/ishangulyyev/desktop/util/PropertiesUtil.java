package by.ishangulyyev.desktop.util;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

@UtilityClass
public class PropertiesUtil {
    private static final String FILENAME = "property.properties";

    @SneakyThrows
    public static void init() {
        File file = new File(FILENAME);
        file.createNewFile();
    }

    @SneakyThrows
    public static void setProperties(String key, String value) {
        Properties properties = new Properties();
        try (FileInputStream in = new FileInputStream(FILENAME)) {
            properties.load(in);
        }

        properties.setProperty(key, value);

        try (FileOutputStream out = new FileOutputStream(FILENAME)) {
            properties.store(out, null);
        }
    }

    @SneakyThrows
    public static String getPropertyValue(String key) {
        Properties properties = new Properties();
        try (FileInputStream in = new FileInputStream(FILENAME)) {
            properties.load(in);
        }
        return properties.getProperty(key);
    }
}
