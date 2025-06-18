//package utils;
//
//import java.io.InputStream;
//import java.util.Properties;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//public class ConfigFileReader {
//    // Logger instance for logging messages
//    private static final Logger log = LogManager.getLogger(ConfigFileReader.class);
//
//    // Singleton instance
//    private static ConfigFileReader instance;
//    private Properties properties;
//
//    // Private constructor to prevent external instantiation
//    private ConfigFileReader() {
//        loadProperties();
//    }
//
//    /**
//     * Loads properties from the configuration file based on the environment.
//     */
//    private void loadProperties() {
//        properties = new Properties();
//        String env = System.getProperty("env", "qa"); // Default to "dev" if not set
//        String fileName = String.format("config_%s.properties", env);
//
//        log.info("Loading configuration for environment: {}", env);
//        log.info("Configuration file: {}", fileName);
//
//        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName)) {
//            if (inputStream == null) {
//                log.error("Configuration file not found: {}", fileName);
//                throw new RuntimeException("Configuration file not found: " + fileName);
//            }
//            properties.load(inputStream);
//            log.info("Configuration file loaded successfully: {}", fileName);
//        } catch (Exception e) {
//            log.error("Error loading configuration file: {}", fileName, e);
//            throw new RuntimeException("Error loading configuration file: " + fileName, e);
//        }
//    }
//
//    /**
//     * Retrieves the singleton instance of ConfigFileReader.
//     *
//     * @return The singleton ConfigFileReader instance.
//     */
//    public static synchronized ConfigFileReader getInstance() {
//        if (instance == null) {
//            log.info("Creating new instance of ConfigFileReader.");
//            instance = new ConfigFileReader();
//        }
//        return instance;
//    }
//
//    /**
//     * Reloads the ConfigFileReader singleton instance.
//     * Useful for switching environments during runtime.
//     */
//    public static synchronized void reloadInstance() {
//        log.info("Reloading ConfigFileReader instance.");
//        instance = null; // Clear the current instance
//        getInstance(); // Reinitialize the singleton
//    }
//
//    /**
//     * Retrieves the value of a property from the loaded configuration.
//     *
//     * @param key The property key to retrieve.
//     * @return The property value, or null if the key does not exist.
//     */
//    public String getProperty(String key) {
//        String value = properties.getProperty(key);
//        if (value == null) {
//            log.warn("Property '{}' not found in the configuration.", key);
//        } else {
//            log.info("Retrieved property '{}': {}", key, value);
//        }
//        return value;
//    }
//}

package utils;

import java.io.*;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConfigFileReader {
    // Logger instance for logging messages
    private static final Logger log = LogManager.getLogger(ConfigFileReader.class);

    // Singleton instance
    private static ConfigFileReader instance;
    private Properties properties;

    // Private constructor to prevent external instantiation
    private ConfigFileReader() {
        loadProperties();
    }

    /**
     * Loads properties from the configuration file based on environment or custom path.
     */
    private void loadProperties() {
        properties = new Properties();

        String env = System.getProperty("env", "qa");
        String fileName = "config_" + env + ".properties";

        // Hardcoded path (you can remove this if using -DconfigPath)
        String defaultConfigPath = "C:\\Users\\SQE Labs\\IdeaProjects\\Kade-Updated-Framework\\src\\main\\resources\\config_qa.properties";

        // Try to get config path from JVM arg (-DconfigPath=...) first
        String customConfigPath = System.getProperty("configPath"); // ✅ Correct property name
        if (customConfigPath == null || customConfigPath.isEmpty()) {
            customConfigPath = System.getenv("CONFIG_PATH"); // fallback to environment variable
        }

        // If no external path provided, use hardcoded default path
        if (customConfigPath == null || customConfigPath.isEmpty()) {
            customConfigPath = defaultConfigPath;
            log.info("Using default config path: {}", customConfigPath);
        }

        InputStream inputStream = null;

        try {
            File file = new File(customConfigPath);
            if (!file.exists()) {
                throw new RuntimeException("Config file not found at: " + customConfigPath);
            }

            inputStream = new FileInputStream(file);
            properties.load(inputStream);
            log.info("Loaded config file successfully from: {}", customConfigPath);

        } catch (Exception e) {
            log.error("Error loading configuration from: {}", customConfigPath, e);
            throw new RuntimeException("Failed to load config file from path: " + customConfigPath, e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    log.warn("Failed to close input stream", e);
                }
            }
        }
    }
    /**
     * Retrieves the singleton instance of ConfigFileReader.
     *
     * @return The singleton ConfigFileReader instance.
     */
    public static synchronized ConfigFileReader getInstance() {
        if (instance == null) {
            log.info("Creating new instance of ConfigFileReader.");
            instance = new ConfigFileReader();
        }
        return instance;
    }

    /**
     * Reloads the ConfigFileReader singleton instance.
     * Useful for switching environments during runtime.
     */
    public static synchronized void reloadInstance() {
        log.info("Reloading ConfigFileReader instance.");
        instance = null; // Clear the current instance
        getInstance(); // Reinitialize the singleton
    }

    /**
     * Retrieves the value of a property from the loaded configuration.
     *
     * @param key The property key to retrieve.
     * @return The property value, or null if the key does not exist.
     */
    public String getProperty(String key) {
//        String value = properties.getProperty(key);
//        if (value == null) {
//            log.warn("Property '{}' not found in the configuration.", key);
//        } else {
//            log.info("Retrieved property '{}': {}", key, value);
//        }
//        return value;
//    }

            String value = properties.getProperty(key);
            if (value == null) {
                throw new RuntimeException("Missing property in config: " + key);
            }
            return value;
        }
}