package fleetManager.storage;

import fleetManager.hosts.Host;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class HostDAOFileSystem implements HostDAO{

    public HostDAOFileSystem(){

    }

    public void addHost(Host host){
        try
        {
            String filename= "Hosts.txt";
            FileWriter fw = new FileWriter(filename,true); //the true will append the new data
            fw.write("\n"+host.getIpv4()+","+host.getDNS()+","+host.getPort()+","+host.getState()+","+host.getSubnet());//appends the string to the file
            fw.close();
        }
        catch(IOException ioe)
        {
            System.err.println("IOException: " + ioe.getMessage());
        }
    }

    public void removeHost(Host host) {
    }

    public void enableHost(Host host) {

    }

    public void disableHost(Host host) {

    }

    public List<Host> getHosts() {
        return null;
    }
}
