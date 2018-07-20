package com.githup.platform.config.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 */
public class ConfigProperties {

    private static Logger logger = LoggerFactory.getLogger(ConfigProperties.class);

    private static final Map<String, String> pathKey = new ConcurrentHashMap<>();
    private static final Properties properties = new Properties();

    public static Properties getProperties() {
        return properties;
    }

    public static Object getPropertiesByKey(String key) {
        return properties.get(key);
    }

    public static void putProperties(String path, String key, String value) {
        pathKey.put(path, key);
        properties.put(key, value);
    }

}
