package com.githup.platform;

import com.githup.platform.config.client.zookeeper.ZookeeperConfig;

import java.util.Enumeration;
import java.util.Properties;

/**
 *
 */
public class ConfigCenter {

    public static void main(String[] args){
        try {
            ZookeeperConfig config = new ZookeeperConfig("10.200.4.74:2181,10.200.4.75:2181,10.200.4.76:2181", "ARK", "emc-b2b-scenic", "true");
            Properties properties = config.getProperties(new Properties());
            Enumeration<?> e = properties.propertyNames();
            while (e.hasMoreElements()) {
                String key = (String) e.nextElement();
                String value = properties.getProperty(key);
                System.out.println(key + "=" + value);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
