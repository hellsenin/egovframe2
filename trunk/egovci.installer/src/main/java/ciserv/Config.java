package ciserv;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

public class Config
{    
    private static Config instance = null;

    public static final String getPrefix()  {
        try 
        { 
            // ���ø����� prefix �� ó���� �� OS �� �������� ������� ��θ��� ����ؾ�
            // hudson �̳� svn-manager �� �������� �����ϰ� �ȴ�.
            return new File(getInstance().prefix).getCanonicalPath().replace('\\', '/'); 
        } 
        catch (IOException e) 
        {
            e.printStackTrace(); 
            return getInstance().prefix;
        }
    }

    public static final String getHostAddress(){
        return getInstance().address;
    }

    public static final String getPortWeb(){
        return getInstance().webport;
    }

    public static final String getPortControl(){
        return getInstance().controlPort;
    }

    public static final String getPortSVN(){
        return getInstance().svnport;
    }
    
    public static final int getPortSVNAsInt(){
        return Integer.parseInt(getInstance().svnport);
    }

    public static Config setPrefix(String prefix) { 
        getInstance().prefix = prefix; 
        return getInstance();
    }
    
    public static void setHostAddress(String address){
        getInstance().address = address;
    }

    public static void setPortWeb(String port){
        getInstance().webport = port;
    }

    public static void setPortControl(String port){
        getInstance().controlPort = port;
    }

    public static void setPortSVN(String port){
        getInstance().svnport = port;
    }
    
    public void save() throws IOException
    {
        FileUtils.writeStringToFile(
            new File(fullpath(FILE_NAME)), 
            getInstance().toString(), 
            FILE_ENCODING);
    }
    
    public static void read(String prefix) throws IOException
    {
        setPrefix(prefix);
        List<String> l = FileUtils.readLines(new File(fullpath(FILE_NAME)), FILE_ENCODING);
        for(String s : l)
        {
            String[] sa = s.split("=");
            if("prefix".equals(sa[0])) { setPrefix(sa[1]); }
            if("address".equals(sa[0])) { setHostAddress(sa[1]); }
            if("port.web".equals(sa[0])) { setPortWeb(sa[1]); }
            if("port.control".equals(sa[0])) { setPortControl(sa[1]); }
            if("port.svn".equals(sa[0])) { setPortSVN(sa[1]); }
        }
    }
    public String toString()
    {
        StringBuffer buffer = new StringBuffer();
        
        buffer.append("prefix=" + getPrefix() + "\n");
        buffer.append("address=" + getHostAddress() + "\n");
        buffer.append("port.web=" + getPortWeb() + "\n");
        buffer.append("port.control=" + getPortControl() + "\n");
        buffer.append("port.svn=" + getPortSVN() + "\n");
        
        return buffer.toString();
    }
    
    public Map<String, String> copyTo(Map<String, String> map) 
    {
        map.put("prefix", Config.getPrefix());
        map.put("host.address", Config.getHostAddress());
        map.put("port.web", Config.getPortWeb());
        map.put("port.control", Config.getPortControl());
        map.put("port.svn", Config.getPortSVN());
        
        return map;
    }
    
    public static void printOn(PrintStream out)
    {
        out.println(getInstance());
        out.println("saved on: " + fullpath(FILE_NAME));
    }
    
    private static final String FILE_ENCODING = "utf-8";
    private static final String FILE_NAME = "bin/config.ini";
    
    private String prefix = "";
    private String address = Util.getHostAddress();
    private String webport = "6060";
    private String controlPort = "6061";
    private String svnport = "3690";
    
    public static Config getInstance()
    {
        if (instance == null)
        {
            instance = new Config();
        }
        return instance;
    }
    

    public static String fullpath(String s){
        return getPrefix() + '/' + s;
    }
    
    public static String fullpath(String s1, String s2){
        return getPrefix() + '/' + s1 + '/' + s2;
    }
}
