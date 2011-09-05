package ciserv;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.IOCase;
import org.apache.commons.lang.SystemUtils;
import org.apache.commons.lang.StringUtils;


public class Util implements Constants
{
    protected static void printVersion(PrintStream out) throws IOException{
        InputStream in = Util.class.getClassLoader()
            .getResourceAsStream("META-INF/MANIFEST.MF"); 
        Manifest m = new Manifest(in);
        Attributes attr = m.getMainAttributes();
        String version = attr.getValue("Version");
        in.close();
        
        out.println(PROGRAM_NAME + " version " + version);
    }

    public static String getHostAddress()
    {
        try 
        {
            Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces();
            while(en.hasMoreElements()) 
            {
                NetworkInterface ni = en.nextElement();
                Enumeration<InetAddress> inetAddresses = ni.getInetAddresses();
                while(inetAddresses.hasMoreElements()) 
                {
                    InetAddress ia = inetAddresses.nextElement();
                    if (ia.getHostAddress() != null && ia.getHostAddress().indexOf(".") != -1) 
                    {
                        if(ia.isLoopbackAddress() == false) { return ia.getHostAddress();}
                    }
                }
            }
        }
        catch (SocketException e1) 
        {
            e1.printStackTrace();
        }
        return null;
    }

    public static boolean delete(File path) {
        if (path.isDirectory()) 
        {
            for (File child : path.listFiles()) 
            {
                delete(child);
            }
        }
        return path.delete();
    }

}
