package SetUp;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

class Configuration {

    private static File configFile = new File("config.properties");

    static String getBaseUrl() {
        try {
            FileReader fileReader = new FileReader(configFile);
            Properties properties = new Properties();
            properties.load(fileReader);
            return properties.getProperty("baseUrl");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    static String getLogin() {

        try {
            FileReader fileReader = new FileReader(configFile);
            Properties properties = new Properties();
            properties.load(fileReader);
            return properties.getProperty("login");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    static String getPassword() {

        try {
            FileReader fileReader = new FileReader(configFile);
            Properties properties = new Properties();
            properties.load(fileReader);
            return properties.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

