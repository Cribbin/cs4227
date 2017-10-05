package requestManagement;

import requestManagement.fleet.FleetManager;
import requestManagement.loadBalancing.LoadBalancer;

public class RequestManagerBuilder {

    private Context context = null;
    private Dispatcher dispatcher = null;

    private LoadBalancer loadBalancer = null;
    private FleetManager fleetManager = null;

    protected RequestManagerBuilder() {

    }

    public RequestManagerBuilder withContext(Context context) {
        this.setContext(context);

        return this;
    }

    public RequestManagerBuilder withDispatcher(Dispatcher dispatcher) {
        this.setDispatcher(dispatcher);

        return this;
    }

    public RequestManagerBuilder withLoadBalancer(LoadBalancer loadBalancer) {
        this.setLoadBalancer(loadBalancer);

        return this;
    }

    public RequestManagerBuilder withFleetManager(FleetManager fleetManager) {
        this.setFleetManager(fleetManager);

        return this;
    }

    public RequestManagerImpl build() {
        return new RequestManagerImpl(this);
    }

    private void setContext(Context context) {
        this.context = context;
    }

    private void setDispatcher(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    private void setLoadBalancer(LoadBalancer loadBalancer) {
        this.loadBalancer = loadBalancer;
    }

    private void setFleetManager(FleetManager fleetManager) {
        this.fleetManager = fleetManager;
    }

    Context getContext() {
        return this.context;
    }

    Dispatcher getDispatcher() {
        return this.dispatcher;
    }

    LoadBalancer getLoadBalancer() {
        return loadBalancer;
    }

    FleetManager getFleetManager() {
        return fleetManager;
    }

}
