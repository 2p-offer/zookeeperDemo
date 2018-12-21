package simple;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooKeeper;
/**
 * Created by 2P on 18-11-14.
 */
public class ZookeeperConnection {
    private ZooKeeper zoo;
    final CountDownLatch connectedSignal = new CountDownLatch(1);

    public ZooKeeper connect(String host) throws Exception {

        zoo = new ZooKeeper(host,5000,new Watcher() {

            public void process(WatchedEvent we) {

                if (we.getState() == KeeperState.SyncConnected) {
                    connectedSignal.countDown();
                }
            }
        });

        connectedSignal.await();
        return zoo;
    }

    // Method to disconnect from zookeeper server
    public void close() throws InterruptedException {
        zoo.close();
    }
}



