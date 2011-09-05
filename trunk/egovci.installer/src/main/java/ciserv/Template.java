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


public class Template implements Constants
{
    private static final String DEFAULT_ENCODING = "utf-8";
    private static final String[] TEXT_TARGETS = new String[] {
        "*.sh", "*.bat",
        "*.xml", "*.dtd", "*.tld",
        "*.conf", "*.properties",
        ".project", ".classpath", "*.prefs",
        "*.html", "*.css", "*.js" ,"*.jsp", "*.jspf",
        "*.java",
        "*.txt",
        "README"
    };

    static private void merge(File f, Map<String, String> map, String encoding) 
        throws FileNotFoundException, IOException
    {
        String[] keys = (String[])map.keySet().toArray(new String[map.keySet().size()]);
        String[] vals = new String[keys.length];
        
        for(int i = 0; i < keys.length; i++)
        {
            vals[i] = map.get(keys[i]); //[����] �Ʒ��� �� �ٲٸ� �ȵȴ�.
            keys[i] = "$${" + keys[i] + "}$$";
        }
        
        String lines = FileUtils.readFileToString(f, DEFAULT_ENCODING);
    
        lines = StringUtils.replaceEach(lines, keys, vals);
    
        FileUtils.writeStringToFile(f, lines, encoding);
    }

    static protected void build(String from, String to) 
        throws FileNotFoundException, IOException
    {
        build(from, to, new HashMap<String, String>());
    }

    static protected void build(String from, String to, Map<String, String> map) 
        throws FileNotFoundException, IOException
    {
        build(from, to, map, DEFAULT_ENCODING);
    }
    
    @SuppressWarnings("unchecked")
    static protected void build(String from, String to, Map<String, String> map, String encoding) 
        throws FileNotFoundException, IOException
    {
        Config.getInstance().copyTo(map);

        File tempRoot = new File(SystemUtils.getJavaIoTmpDir(), "ci");
        FileUtils.deleteDirectory(tempRoot);

        FileUtils.copyDirectory(new File(Config.fullpath(from)), tempRoot);

        Collection<File> files = FileUtils.listFiles(tempRoot, 
            new WildcardFileFilter(TEXT_TARGETS, IOCase.INSENSITIVE),
            FileFilterUtils.makeSVNAware(null));
        if (files != null)
        {
            for(File f : files)
            {
                System.out.println("\t[" + to + "] <== " + removePrefix(f, tempRoot));
                if (f.isFile())
                {
                    try
                    {
                        merge(f, map, encoding);
                    }
                    catch (Exception e)
                    {
                        System.err.println("config failed : " + f);
                        e.printStackTrace(System.err);
                    }
                }
            }
        }

        FileUtils.copyDirectory(tempRoot, new File(Config.fullpath(to)));
        FileUtils.deleteDirectory(tempRoot); 
    }

    static private String removePrefix(File f, File from)
    {
        if ( f == null ) return null;
        String s = f.getAbsolutePath();

        if ( from == null ) return s;
        String prefix = from.getAbsolutePath();

        s =  s.substring(prefix.length()); 
        
        return s;
    }
}
