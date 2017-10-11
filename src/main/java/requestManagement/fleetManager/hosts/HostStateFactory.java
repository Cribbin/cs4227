package requestManagement.fleetManager.hosts;

/**
 * Factory method for Host state.
 *
 * This factory method is ued to return a state object for a host.
 * We can easily add new states due to this class.
 */
public class HostStateFactory {

    public HostStateFactory() {}

    /** Return a HostState object implementation depending on input String */
    public HostState hostState(String state) {
        HostState hostState = null;
        if(state.equals("active")) {
            hostState = new ActiveHost();
        }
        else if(state.equals("inactive")) {
            hostState = new InactiveHost();
        }
        return hostState;
    }
}
