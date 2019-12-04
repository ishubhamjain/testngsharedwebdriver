package automationframework;
/**
 * @author Shubham Jain
 *
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration 
{
    private Properties properties = new Properties();
    private static Configuration globalConfiguration = null;
    private final static String DEFAULT_CONFIG_PATH = "configuration/config.properties";

    protected Configuration()
    {
        // Load default configuration from framework specific location.
        loadAllProperties(DEFAULT_CONFIG_PATH);
    }

    private void loadAllProperties(String configFilePath) 
    {
        properties = new Properties();
        try 
        {
            properties.load(new FileInputStream(configFilePath));
        }
        catch (IOException e) 
        {
            throw new RuntimeException("Could not read the properties file");
        }
    }

    public void setGlobalConfigurationFile(String configFile)
    {
        reloadAllProperties(configFile);
    }

    private void reloadAllProperties(String configFile)
    {
        loadAllProperties(configFile);
    }

    public static Configuration globalConfiguration()
    {
        if (globalConfiguration == null)
        {
            globalConfiguration = new Configuration();
        }
        return globalConfiguration;
    }

    private String readConfigurationProperty(String propertyName) 
    {
        String defaultValue = "";
        return properties.getProperty(propertyName, defaultValue);
    }

    public static String getConfigurationValueForProperty(String propertyName)
    {
        return Configuration.globalConfiguration().readConfigurationProperty(propertyName);
    }

    public static String applicationUnderTestURL()
    {
    	return "http://" + Configuration.getConfigurationValueForProperty("applicationURL");
    }
    
    public static String getExcelFile()
    {
    	String excelvalue = Configuration.getConfigurationValueForProperty("Excelfile");
    	return excelvalue;		
    }
}
