package utils;

import org.apache.commons.lang3.StringUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class PropertyUtils{

   static  Properties prop = new Properties();
public static String getPropertyValue(String key) {

    //1. load data from properties file
    String propFilePath = System.getProperty("user.dir") + "/src/main/java/Config/Config.Properties";
    FileInputStream fis;
    try {
        fis = new FileInputStream(propFilePath);
        prop.load(fis);
    } catch (Exception e) {
        e.printStackTrace();
    }


    //2. read data
    String value = prop.get(key).toString();

    if (StringUtils.isEmpty(value)) {
        try {
            throw new RuntimeException("Value is not specified for key: " + key + " in properties file.");
        } catch (Exception e) {
        }
    }

    return value;
}

public static void setPropertyValue(String key, String value) {
    //1. load data from properties file
    String propFilePath = System.getProperty("user.dir") + "/src/main/java/Config/Config.Properties";
    Properties confprop = new Properties();
    FileOutputStream fos;
    try {
        fos = new FileOutputStream(propFilePath);
        confprop.setProperty(key, value);
        prop.store(fos, null);
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public static String getPropertyValue(String key, String configFile) {
    //1. load data from properties file
    String propFilePath = System.getProperty("user.dir") + "/src/main/java/Config/Config.Properties";
    FileInputStream fis;
    try {
        fis = new FileInputStream(propFilePath);
        prop.load(fis);
    } catch (Exception e) {
        e.printStackTrace();
    }


    //2. read data
    String value = prop.get(key).toString();

    if (StringUtils.isEmpty(value)) {
        try {
            throw new RuntimeException("Value is not specified for key: " + key + " in properties file.");
        } catch (Exception e) {
        }
    }

    return value;
}
}


