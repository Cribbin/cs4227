package fleetManager;

import fleetManager.command.*;
import fleetManager.hosts.Host;

import java.util.List;

public class HeathCheckImplementation implements HealthCheck {

    private Command addHostCommand;
    private Command removeHostCommand;
    private Command enableHostCommand;
    private Command disableHostCommand;
    private GetHostsCommand getHostsCommand;
    private Host host;
    private List<Host> allHosts;

    public HeathCheckImplementation(){
        host=new Host("1","127.0.0.2","1","1",true);
    }

    public void runHealthCheck(){
//        addHostCommand=new AddHostCommand(host);
//        removeHostCommand=new RemoveHostCommand(host);
//       disableHostCommand=new DisableHostCommand(host);
//        enableHostCommand=new EnableHostCommand(host);
        getHostsCommand= new GetHostsCommand();

//        addHostCommand.execute();
//        removeHostCommand.execute();
//        disableHostCommand.execute();
//        enableHostCommand.execute();
        getHostsCommand.execute();
        allHosts=getHostsCommand.getHosts();
    }
}
