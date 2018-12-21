package serviceFind;

/**
 * Created by 2P on 18-11-14.
 */
public class GlobalConstants {
    // zk服务器列表
    public static final String zkhosts = "10.10.12.104:2181";
    // 连接的超时时间
    public static final int sessionTimeout = 2000;
    // 服务在zk下的路径
    public static final String parentZnodePath = "/servers";

}
