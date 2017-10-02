package fleetManager.hosts;

public class Host {
    private HostState hostState;
    private HostFactory hostFactory;

    public Host(String state){
        hostFactory=new HostFactory();
    }

}
