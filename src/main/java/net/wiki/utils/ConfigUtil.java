package net.wiki.utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigUtil {

    public static Properties prop;

    public static String retrieveConfigValue(String configName) throws Exception {
        if (prop == null) {
            prop = new Properties();
        }
        try {
            InputStream config = ConfigUtil.class.getClassLoader().getResourceAsStream("config.properties");
            prop.load(config);
            return prop.getProperty(configName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new Exception("Config with name " + configName + " not found");
    }
}
