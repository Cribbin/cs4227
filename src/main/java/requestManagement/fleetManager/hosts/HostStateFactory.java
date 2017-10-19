package requestManagement.fleetManager.hosts;

/**
 * Factory method for Host state.
 *
 * This factory method is used to return a state object for a host.
 * We can easily add new states due to this class.
 */
public class HostStateFactory {

    public HostStateFactory() {}

    /** Return a HostState object implementation depending on input String */
    public HostState hostState(String state) {
        if (state.equals("active")) {
            return new ActiveHost();
        } else if (state.equals("inactive")) {
            return new InactiveHost();
        }
        throw new IllegalArgumentException(String.format("%s is not a valid state", state));
    }
}
