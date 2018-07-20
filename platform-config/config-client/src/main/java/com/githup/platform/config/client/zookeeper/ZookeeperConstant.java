package com.githup.platform.config.client.zookeeper;


/**
 *
 */
public class ZookeeperConstant {

    public static final String SEPARATOR = "/";
    public static final String UTF_8 = "UTF-8";
    public static final String NAME_SPACE = "sweet-config";
    public static final String PROPERTIES = "properties";

    public static final String ADDRESS = "zookeeper.config.address";
    public static final String ENVIRONMENT = "zookeeper.config.environment";
    public static final String APPLICATION = "zookeeper.config.application";
    public static final String WATCH_ENABLE = "zookeeper.config.watch.enable";

    /**
     * zookeeper 地址
     */
    public static String zookeeperConfigAddress;

    /**
     * 配置环境
     */
    public static String zookeeperConfigEnvironment;

    /**
     * 配置应用
     */
    public static String zookeeperConfigApplication;

    /**
     * 是否监听
     */
    public static Boolean zookeeperConfigWatchEnable = false;

}
