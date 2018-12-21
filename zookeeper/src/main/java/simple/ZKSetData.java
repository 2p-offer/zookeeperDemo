package simple;

import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.KeeperException;

/**
 * Created by 2P on 18-11-14.
 */
public class ZKSetData {
    private static ZooKeeper zk;
    private static ZookeeperConnection conn;

    public static void update(String path, byte[] data) throws
            KeeperException,InterruptedException {
        zk.setData(path, data, zk.exists(path,true).getVersion());
    }

    public static void main(String[] args) throws InterruptedException,KeeperException {
        String path= "/MyFirstZnode";
        byte[] data = "Success".getBytes(); //Assign data which is to be updated.

        try {
            conn = new ZookeeperConnection();
            zk = conn.connect("localhost");
            update(path, data); // Update znode data to the specified path
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}