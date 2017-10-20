package requestManagement.fleetManager.storage;

import requestManagement.fleetManager.hosts.Host;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HostDAOFileSystem implements HostDAO {
    private static String hostFile = "hosts.txt";

    private FileWriter fw;
    private List<List<String>> fleetInformation;

    public HostDAOFileSystem() {}

    // For testing
    HostDAOFileSystem(String hostFilePath) {
        hostFile = hostFilePath;
    }

    @Override
    public void addHost(Host host) {
        this.fleetInformation = readFile();
        if (!hostIsPresentInFile(host.getIpv4())) {
            try {
                fw = new FileWriter(hostFile, true); //the true will append the new data
                fw.write(host.toString());//appends the string to the file
                fw.close();
            } catch (IOException ioe) {
                System.err.println("IOException: " + ioe.getMessage());
            }
        }
    }

    @Override
    public void removeHost(Host host) {
        this.fleetInformation = readFile();
        try {
            if (hostIsPresentInFile(host.getIpv4())) {
                fleetInformation.removeIf(s -> s.contains(host.getIpv4()));
                writeToFile();
            }
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void enableHost(Host host) {
        this.fleetInformation = readFile();
        setStateForHostInFile(host, "active");
    }

    @Override
    public void disableHost(Host host) {
        this.fleetInformation = readFile();
        setStateForHostInFile(host, "inactive");
    }

    @Override
    public List<Host> getHosts() {
        this.fleetInformation = readFile();
        List<Host> hosts = new ArrayList<>();
        try {
            fleetInformation.forEach( l -> hosts.add(parseHostData(l)));
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.err.println(e.getMessage());
        }
        return hosts;
    }

    private List<List<String>> readFile() {
        FileReader fr;
        List<String> listToBeAdded;
        List<List<String>> hostsFromFile = new ArrayList<>();
        /* Reads the file, splits each line into a List and adds these Lists to a List */
        try {
            fr = new FileReader(hostFile);
            BufferedReader br = new BufferedReader(fr);
            String s;
            while((s = br.readLine()) != null) {
                listToBeAdded = Arrays.asList(s.split(","));
                hostsFromFile.add(listToBeAdded);
            }
            fr.close();
        }
        catch(IOException ioe) {
            System.err.println("IOException: " + ioe.getMessage());
        }
        return hostsFromFile;
    }

    private void writeToFile() {
        try {
            fw = new FileWriter(hostFile);
            for(List<String> list: fleetInformation){
                fw.write(list.get(0)+","+list.get(1)+","+list.get(2)+","+list.get(3)+","+list.get(4)+"\n");
            }
            fw.close();
        }
        catch(IOException ioe) {
            System.err.println("IOException: " + ioe.getMessage());
        }
    }

    private boolean hostIsPresentInFile(String ip) {
        return fleetInformation.stream().anyMatch( l -> l.contains(ip));
    }

    public Host parseHostData(List<String> hostData){
        return new Host.HostBuilder(hostData.get(0)) // ip
            .withDns(hostData.get(1))
            .withPort(hostData.get(2))
            .withState(hostData.get(3))
            .build();
    }

    public void setStateForHostInFile(Host host, String state){
        try {
            if (hostIsPresentInFile(host.getIpv4())) {
                for(List<String> hostData : fleetInformation){
                    if (hostData.contains(host.getIpv4())) {
                        hostData.set(3, state);
                        host.setState(state);
                        break;
                    }
                }
                writeToFile();
            }
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.err.println(e.getMessage());
        }
    }
}
