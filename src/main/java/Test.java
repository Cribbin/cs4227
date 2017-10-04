import fleetManager.hosts.Host;
import fleetManager.storage.HostDAO;
import fleetManager.storage.HostDAOFileSystem;

import java.util.List;

public class Test {
    public static void main(String[]args){
        Host host=new Host("1","127.0.0.1","1","1",true);
        HostDAO file = new HostDAOFileSystem();
      //  file.addHost(host);
      //  file.removeHost(host);
        file.enableHost(host);
       // file.disableHost(host);
        List<Host> hosts=file.getHosts();
    }
}
