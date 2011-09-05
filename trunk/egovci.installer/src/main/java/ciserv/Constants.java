package ciserv;


public interface Constants {

    public static final String PROGRAM_NAME = "egov.ci";

    public static final String TEMPLATE_ROOT = "template";

    public static final String HUDSON_TEMPLATES = TEMPLATE_ROOT + "/hudson";
    public static final String HUDSON_HOME = "hudson";

    public static final String HUDSON_JOB_TEMPLATE = TEMPLATE_ROOT + "/hudson.job/%s";
    public static final String HUDSON_JOB_HOME = "hudson/jobs/%s";
    public static final String HUDSON_JOB_WORKSPACE = HUDSON_JOB_HOME + "/workspace";

    public static final String PROJECT_TEMPLATE = TEMPLATE_ROOT + "/projects/%s";
    public static final String TEMP     = "temp";

    public static final String MAVEN_TEMPLATES = TEMPLATE_ROOT + "/maven";
    public static final String MAVEN_HOME = "maven";

    public static final String TOMCAT_TEMPLATES = TEMPLATE_ROOT + "/tomcat";
    public static final String TOMCAT_HOME = "tomcat6";

    public static final String BIN_TEMPLATES = TEMPLATE_ROOT + "/bin";
    public static final String BIN = "bin";

}
