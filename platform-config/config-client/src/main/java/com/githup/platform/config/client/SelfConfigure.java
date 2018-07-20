package com.githup.platform.config.client;

/**
 *
 */
public interface SelfConfigure {

    /**
     * 配置中心地址
     * @return
     */
    String address();

    /**
     * 环境
     * @return
     */
    String environment();

    /**
     * 应用
     * @return
     */
    String application();

    /**
     * 是否监听
     * @return
     */
    Boolean watchEnable();



}
