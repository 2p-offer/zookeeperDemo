package simple;

import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.KeeperException;
/**
 * Created by 2P on 18-11-14.
 */
public class ZKDelete {
    private static ZooKeeper zk;
    private static ZookeeperConnection conn;

    // Method to check existence of znode and its status, if znode is available.
    public static void delete(String path) throws KeeperException,InterruptedException {
        zk.delete(path,zk.exists(path,true).getVersion());
    }

    public static void main(String[] args) throws InterruptedException,KeeperException {
        String path = "/second"; //Assign path to the znode

        try {
            conn = new ZookeeperConnection();
            zk = conn.connect("localhost");
            delete(path); //delete the node with the specified path
            System.out.println("success");
        } catch(Exception e) {
            System.out.println(e.getMessage()); // catches error messages
        }
    }
}