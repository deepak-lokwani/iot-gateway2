/**
 * @author deepak
 * NUID: 001316769
 * this class creates the configuration file to get the properties and section for SMTP
 */
package neu.dlokwani.connecteddevices.common;

import java.io.File;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.configuration.*;
import neu.dlokwani.connecteddevices.common.ConfigConst;

/*
 * @author: Deepak lokwani
 * NUID: 001316769
 * 
 */
/*
 *@param isLoaded: is a boolean indicator to verify if the configurations are loaded  
 */
public class ConfigUtil {

	private static final Logger _logger = Logger.getLogger(ConfigUtil.class.getName());

	private static final ConfigUtil _Instance = new ConfigUtil();

	private boolean isLoaded = false;

	Properties props = new Properties();

	private HierarchicalINIConfiguration section_props = null;

	/*
	 * Creates a singleton pattern for the configuration file to ensure the instance
	 * singularity
	 */
	public static final ConfigUtil getInstance() {
		return _Instance;
	}

	/*
	 * Defining getProperties in order to read the java INI files
	 */
	public String getProperty(String section, String Key) {

		SubnodeConfiguration subnodeConfig = section_props.getSection(section);
		return subnodeConfig.getString(Key);
	}

	/*
	 * returns the state of the configuration file, whether loaded or not
	 */
	public boolean isConfigDataLoaded() {
		return isLoaded;
	}

	public synchronized boolean section_check(String section) {
		SubnodeConfiguration subnode = section_props.getSection(section);
		return (subnode != null);
	}

	/*
	 * loads my configuration file with the default file
	 */
	public synchronized boolean loadConfig() {
		return loadConfig(ConfigConst.DEFAULT_CONFIG_FILE_NAME);
	}

	public void set_props() {
		section_props = new HierarchicalINIConfiguration();
	}

	/*
	 * loads my configuration file is a new configuration file location is specified
	 */
	public synchronized boolean loadConfig(String configfile) {
		boolean flag = false;
		try {
			/*
			 * checks for the requisite file conditions and logs the warning
			 */
			if (configfile == null || configfile.trim().length() == 0) {
				configfile = ConfigConst.DEFAULT_CONFIG_FILE_NAME;

				_logger.warning("File is invalid. Using default file:" + configfile);
			}
			/*
			 * creates a new file-reader to read config file and repeat the same process
			 */
			File file = new File(configfile);
			if (file.exists() && file.canRead()) {
				set_props();
				section_props.load(configfile);
				isLoaded = true;
				flag = true;
			} else {
				_logger.warning("File doesn't exist");
			}
		}

		catch (ConfigurationException e) {
			_logger.log(Level.WARNING, "Failed to load Configuration file");
		}
		return flag;
	}

	/*
	 * constructor which automatically loads the default config fle upon class being called
	 */
	public ConfigUtil() {
		super();
		loadConfig();
	}

}
