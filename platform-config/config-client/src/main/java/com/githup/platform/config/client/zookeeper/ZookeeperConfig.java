package com.githup.platform.config.client.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Properties;

/**
 *
 */
public class ZookeeperConfig {
    private static Logger logger = LoggerFactory.getLogger(ZookeeperConfig.class);
    private Properties properties = new Properties();
    public ZookeeperConfig(){}

    public ZookeeperConfig(String address, String environment, String application, String watchEnable) throws Exception{
        properties.put(ZookeeperConstant.ADDRESS, address);
        properties.put(ZookeeperConstant.ENVIRONMENT, environment);
        properties.put(ZookeeperConstant.APPLICATION, application);
        properties.put(ZookeeperConstant.WATCH_ENABLE, watchEnable);
    }

    private void init(Properties prop) {
        properties.putAll(prop);
        ZookeeperConstant.zookeeperConfigAddress = properties.getProperty(ZookeeperConstant.ADDRESS);
        ZookeeperConstant.zookeeperConfigEnvironment = properties.getProperty(ZookeeperConstant.ENVIRONMENT);
        ZookeeperConstant.zookeeperConfigApplication = properties.getProperty(ZookeeperConstant.APPLICATION);
        ZookeeperConstant.zookeeperConfigWatchEnable = Boolean.valueOf(properties.getProperty(ZookeeperConstant.WATCH_ENABLE));
    }

    public Properties getProperties(Properties prop) throws Exception{
        init(prop);
        Properties properties = new Properties();
        CuratorFramework client = ZookeeperClientFactory.getInstance(ZookeeperConstant.zookeeperConfigAddress, ZookeeperConstant.NAME_SPACE);
        ZookeeperWatcher watcher = new ZookeeperWatcher();

        /**
         * 加载公共配置和应用配置
         */
        String[] applicationNames = {"common", ZookeeperConstant.zookeeperConfigApplication};
        //应用
        for (String application : applicationNames) {
            String appNamePath = getAppNamePath(application);
            if (client.checkExists().forPath(appNamePath) != null) {
                //组
                List<String> childrenGroup = client.getChildren().forPath(appNamePath);
                if (childrenGroup != null || !childrenGroup.isEmpty()) {
                    for (String groupPath : childrenGroup) {
                        groupPath = appNamePath + ZookeeperConstant.SEPARATOR + groupPath;
                        if (client.checkExists().forPath(groupPath) != null) {
                            //属性
                            List<String> childrenProp = client.getChildren().forPath(groupPath);
                            if (childrenProp != null && childrenProp.size() > 0) {
                                for (String propName : childrenProp) {
                                    String propPath = groupPath + ZookeeperConstant.SEPARATOR + propName;
                                    String propValue = "";
                                    if (client.checkExists().forPath(propPath) != null) {
                                        byte[] data = client.getData().usingWatcher(watcher).forPath(propPath);
                                        propValue = data == null ? "" : new String(data, ZookeeperConstant.UTF_8);
                                        logger.info("disconf read prop: {}={} ", propName, propValue);
                                     }
                                    properties.put(propName, propValue);
                                }
                            }
                        }
                    }
                }
            }
        }

        return properties;
    }

    private String getAppNamePath(String application) {
        return new StringBuilder(ZookeeperConstant.SEPARATOR)
                .append(ZookeeperConstant.PROPERTIES)
                .append(ZookeeperConstant.SEPARATOR)
                .append(ZookeeperConstant.zookeeperConfigEnvironment)
                .append(ZookeeperConstant.SEPARATOR)
                .append(application).toString();
    }
}
