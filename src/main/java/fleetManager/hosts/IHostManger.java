package fleetManager.hosts;

public interface IHostManger {
    void addHost(Host host);
    void removeHost(Host host);
    void enableHost(Host host);
    void disableHost(Host host);
}
