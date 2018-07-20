package com.githup.platform.config.client.zookeeper;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;


/**
 *
 */
public class ZookeeperClientFactory {

    private static final int MAX_RETRY = 3;
    private static final int SLEEP_TIME = 3000;
    private static CuratorFramework client;

    private ZookeeperClientFactory() {
    }

    public static CuratorFramework getInstance(String zookeeperAddress, String nameSpace) {
        if (client == null) {
            RetryPolicy retryPolicy = new ExponentialBackoffRetry(SLEEP_TIME, MAX_RETRY);
            client = CuratorFrameworkFactory.builder()
                    .retryPolicy(retryPolicy)
                    .connectString(zookeeperAddress)
                    .namespace(nameSpace)
                    .build();
            client.start();
        }
        return client;
    }
}
