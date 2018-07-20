package com.githup.platform.config.client.zookeeper;

import org.apache.curator.framework.api.CuratorWatcher;
import org.apache.zookeeper.WatchedEvent;

/**
 *
 */
public class ZookeeperWatcher implements CuratorWatcher {

    @Override
    public void process(WatchedEvent watchedEvent) throws Exception {
        if (watchedEvent.getPath() != null && Boolean.TRUE.equals(ZookeeperConstant.zookeeperConfigWatchEnable)) {

        }
    }
}
