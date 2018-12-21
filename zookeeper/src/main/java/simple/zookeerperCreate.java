package simple;

import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
/**
 * Created by 2P on 18-11-14.
 */
public class zookeerperCreate {
    private static ZooKeeper zk;

    private static ZookeeperConnection conn;

    public static void create(String path, byte[] data) throws
            KeeperException,InterruptedException {
        String s = zk.create(path, data, ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.PERSISTENT);
        System.out.println(s+"????????????????");
    }

    public static void main(String[] args) {

        // znode path
        String path = "/MyFirstZnode/second/third";

        // data in byte array
        byte[] data = "My first zookeeper app".getBytes(); // Declare data

        try {
            conn = new ZookeeperConnection();
            zk = conn.connect("localhost");
            create(path, data); // Create the data to the specified path
            System.out.println("success--- path:"+path+"data:"+data);
            conn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage()); //Catch error message
        }
    }
}