package fleetManager.command;

import fleetManager.hosts.Host;
import fleetManager.hosts.HostManager;

public class AddHostCommand implements Command{
    private Host host;
    private HostManager hostManager;
    public AddHostCommand(Host host){
        hostManager=new HostManager();
        this.host=host;
    }

    public void execute(){
        hostManager.addHost(host);
    }

}
