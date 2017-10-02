package fleetManager;

import fleetManager.command.AddHostCommand;
import fleetManager.command.DisableHostCommand;
import fleetManager.command.EnableHostCommand;
import fleetManager.command.RemoveHostCommand;
import fleetManager.hosts.Host;

public class FleetManager implements IFleetManager{

    FleetManager(){

    }

    public void addHost(Host host){
        AddHostCommand addHostCommand= new AddHostCommand(host);
        addHostCommand.execute();
    }

    public void removeHost(Host host){
        RemoveHostCommand removeHostCommand= new RemoveHostCommand(host);
        removeHostCommand.execute();
    }

    public void enableHost(Host host){
        EnableHostCommand enableHostCommand = new EnableHostCommand(host);
        enableHostCommand.execute();
    }

    public void disableHost(Host host){
        DisableHostCommand disableHostCommand= new DisableHostCommand(host);
        disableHostCommand.execute();
    }

    public void getHosts(){

    }


}
