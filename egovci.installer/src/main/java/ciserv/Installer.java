package ciserv;

import gnu.getopt.Getopt;
import gnu.getopt.LongOpt;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;



public class Installer implements Constants
{
    private static final String SHORT_OPTS = "a:w:W:c:s:hv";
    private static final LongOpt[] LONG_OPTS = new LongOpt[] {      
          new LongOpt("address",     LongOpt.OPTIONAL_ARGUMENT, null, 'a'),
          new LongOpt("webport",     LongOpt.OPTIONAL_ARGUMENT, null, 'w'),
          new LongOpt("controlport", LongOpt.OPTIONAL_ARGUMENT, null, 'c'),
          new LongOpt("svnport",     LongOpt.OPTIONAL_ARGUMENT, null, 's'),
          new LongOpt("version",     LongOpt.NO_ARGUMENT, null, 'v'),
          new LongOpt("help",        LongOpt.NO_ARGUMENT, null, 'h'),
    };
    private static void printUsage(PrintStream out) 
    {
          out.println("Usage: "+Util.PROGRAM_NAME+" [Options]");
          out.println();
          out.println("Options:");
          out.println(" -a [--address=]ARG     : host ip address.");
          out.println(" -w [--webport=]ARG     : web server's service port. default=" + Config.getPortWeb());
          out.println(" -c [--controlport=]ARG : web server's control port. default=" + Config.getPortControl());
          out.println(" -s [--svnport=]ARG     : svn server's service port. default=" + Config.getPortSVN());
          out.println(" -h [--help]            : print this help message");
          out.println(" -v [--version]         : print installer version.");
    }
    
    public static void main(String[] args) throws Exception
    {
        Getopt g = new Getopt(Util.PROGRAM_NAME, args, SHORT_OPTS, LONG_OPTS);
        int c;
        
        while ((c = g.getopt()) != -1) {
             switch (c) {
                case 'a':
                    Config.setHostAddress(g.getOptarg()); break;
                case 'w':
                    Config.setPortWeb(g.getOptarg()); break;   
                case 'c':
                    Config.setPortControl(g.getOptarg()); break;
                case 's':
                	Config.setPortSVN(g.getOptarg()); break;
                case 'v':
                    Util.printVersion(System.out); System.exit(0);
                case 'h' :
                    printUsage(System.err); System.exit(0);
                case '?':
                    printUsage(System.err); System.exit(1);
             }
        }
        if (args.length <= g.getOptind()) { printUsage(System.err); System.exit(1); }
        Config.setPrefix(args[g.getOptind()]).save();
        Config.printOn(System.out);
        
        new Installer().execute();
    }
    
	public void execute() throws Exception
	{
	    log("install " + Util.PROGRAM_NAME);
	    log("initialize bin..."); Template.build(BIN_TEMPLATES, BIN); 
	    log("initialize tomcat..."); Template.build(TOMCAT_TEMPLATES, TOMCAT_HOME); 
	    log("initialize hudson..."); Template.build(HUDSON_TEMPLATES, HUDSON_HOME); 
	    log("initialize maven...");  Template.build(MAVEN_TEMPLATES, MAVEN_HOME); 
		log("done.");
	}
	
	private void log(String message)
	{
	    System.out.println(message);
	}

}
