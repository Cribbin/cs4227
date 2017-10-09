package requestManagement.fleetManager.hosts;

public class HostStateFactory {

    HostStateFactory(){

    }

    public HostState hostState(String state){
        HostState hostState=null;
        if(state.equals("active")){
            hostState= new ActiveHost();
        }
        else if(state.equals("inactive")){
            hostState= new InactiveHost();
        }

        return hostState;
    }
}
