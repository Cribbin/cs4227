package fleetManager.storage;

import fleetManager.hosts.Host;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HostDAOFileSystem implements HostDAO{

    private String filename= "Hosts.txt";
    private FileWriter fw;
    private FileReader fr;
    private List<List<String>> dataFromFile;
    private List<String> temp;

    public HostDAOFileSystem(){

    }

    public void addHost(Host host){
        readFile();
        if(!contains(host.getIpv4())) {
            try {
                fw = new FileWriter(filename, true); //the true will append the new data
                fw.write("\n" + host.getIpv4() + "," + host.getDNS() + "," + host.getPort() + "," + host.getState() + "," + host.getSubnet());//appends the string to the file
                fw.close();
            } catch (IOException ioe) {
                System.err.println("IOException: " + ioe.getMessage());
            }
        }
    }

    public void removeHost(Host host) {
        readFile();
        try {
            if (contains(host.getIpv4())) {
                for (int i = 0; i < dataFromFile.size(); i++) {
                    if (dataFromFile.get(i).contains(host.getIpv4())) {
                        dataFromFile.remove(i);
                    }
                }
                writeToFile();
            }
        }
        catch (ArrayIndexOutOfBoundsException e){

        }
    }

    public void enableHost(Host host) {
        readFile();
        try {
            if (contains(host.getIpv4())) {
                for (int i = 0; i < dataFromFile.size(); i++) {
                    if (dataFromFile.get(i).contains(host.getIpv4())) {
                        dataFromFile.get(i).set(3, "active");
                        host.setState("active");
                    }
                }
                writeToFile();
            }
        }
        catch (ArrayIndexOutOfBoundsException e){

        }
    }

    public void disableHost(Host host) {
        readFile();
        try {
            if (contains(host.getIpv4())) {
                for (int i = 0; i < dataFromFile.size(); i++) {
                    if (dataFromFile.get(i).contains(host.getIpv4())) {
                        dataFromFile.get(i).set(3, "inactive");
                        host.setState("inactive");
                    }
                }
                writeToFile();
            }
        }
        catch (ArrayIndexOutOfBoundsException e){

        }
    }

    public List<Host> getHosts() {
        readFile();
        List<Host> hosts=new ArrayList<Host>();
        Host tempHost;
        boolean isPublic=false;
        try {
            for (List<String> hostData : dataFromFile) {
                if (hostData.get(4) == "public")
                    isPublic = true;
                tempHost = new Host(hostData.get(3), hostData.get(0), hostData.get(1), hostData.get(2), isPublic);
                hosts.add(tempHost);
            }
        }
        catch (ArrayIndexOutOfBoundsException e){

        }
        return hosts;
    }

    private void readFile(){
        try
        {
            dataFromFile=new ArrayList<List<String>>();
            fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            String s;
            while((s = br.readLine()) != null) {
                temp=new ArrayList<String>(Arrays.asList(s.split(",")));
                dataFromFile.add(temp);
            }
            fr.close();
        }
        catch(IOException ioe)
        {
            System.err.println("IOException: " + ioe.getMessage());
        }
    }

    private void writeToFile(){
        try
        {
            fw = new FileWriter(filename);
            for(List<String> list: dataFromFile){
                fw.write(list.get(0)+","+list.get(1)+","+list.get(2)+","+list.get(3)+","+list.get(4)+"\n");
            }
            fw.close();
        }
        catch(IOException ioe)
        {
            System.err.println("IOException: " + ioe.getMessage());
        }
    }

    private boolean contains(String ip){
        boolean contains = false;
        for(List<String> list: dataFromFile){
            if(list.contains(ip))
                contains=true;
        }
        return contains;
    }
}
