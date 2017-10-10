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

    private static final String filename = "Hosts.txt";
    private FileWriter fw;
    private List<List<String>> dataFromFile;

    public HostDAOFileSystem(){

    }

    @Override
    public void addHost(Host host) {
        readFile();
        if(!dataFromFileContainsIp(host.getIpv4())) {
            try {
                fw = new FileWriter(filename, true); //the true will append the new data
                fw.write(hostToStringFormat(host));//appends the string to the file
                fw.close();
            } catch (IOException ioe) {
                System.err.println("IOException: " + ioe.getMessage());
            }
        }
    }

    @Override
    public void removeHost(Host host) {
        readFile();
        try {
            if (dataFromFileContainsIp(host.getIpv4())) {
                dataFromFile.removeIf(s -> s.contains(host.getIpv4()));
                writeToFile();
            }
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void enableHost(Host host) {
        readFile();
        try {
            if (dataFromFileContainsIp(host.getIpv4())) {
                for(List<String> listIterator : dataFromFile){
                    if (listIterator.contains(host.getIpv4())) {
                        listIterator.set(3, "active");
                        host.setState("active");
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

    @Override
    public void disableHost(Host host) {
        readFile();
        try {
            if (dataFromFileContainsIp(host.getIpv4())) {
                for(List<String> listIterator : dataFromFile){
                    if (listIterator.contains(host.getIpv4())) {
                        listIterator.set(3, "inactive");
                        host.setState("inactive");
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

    @Override
    public List<Host> getHosts() {
        readFile();
        List<Host> hosts = new ArrayList<Host>();
        Host hostToAdd;
        String state;
        String ipv4;
        String dns;
        String port;
        String subnet;
        boolean isPublic = false;
        try {
            for (List<String> hostData : dataFromFile) {
                state=hostData.get(3);
                ipv4=hostData.get(0);
                dns=hostData.get(1);
                port=hostData.get(2);
                subnet=hostData.get(4);
                if (subnet.equals("public"))
                    isPublic = true;
                hostToAdd = new Host(state, ipv4, dns, port, isPublic);
                hosts.add(hostToAdd);
            }
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.err.println(e.getMessage());
        }
        return hosts;
    }

    private void readFile() {
        FileReader fr;
        List<String> listToBeAdded;
        try {
            dataFromFile = new ArrayList<List<String>>();
            fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            String s;
            while((s = br.readLine()) != null) {
                listToBeAdded = Arrays.asList(s.split(","));
                dataFromFile.add(listToBeAdded);
            }
            fr.close();
        }
        catch(IOException ioe) {
            System.err.println("IOException: " + ioe.getMessage());
        }
    }

    private void writeToFile() {
        try {
            fw = new FileWriter(filename);
            for(List<String> list: dataFromFile){
                fw.write(list.get(0)+","+list.get(1)+","+list.get(2)+","+list.get(3)+","+list.get(4)+"\n");
            }
            fw.close();
        }
        catch(IOException ioe) {
            System.err.println("IOException: " + ioe.getMessage());
        }
    }

    private boolean dataFromFileContainsIp(String ip) {
        if(dataFromFile.stream().anyMatch( l -> l.contains(ip)))
            return true;
        return false;
    }

    private String hostToStringFormat(Host host){
        return host.getIpv4() + "," + host.getDNS() + "," + host.getPort() + "," + host.getState() + "," + host.getSubnet();
    }
}
