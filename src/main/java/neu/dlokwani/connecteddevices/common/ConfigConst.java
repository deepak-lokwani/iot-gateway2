/**
 * 
 */
package neu.dlokwani.connecteddevices.common;

/**
 * @author deepak
 * NUID:001316769
 * this class contains the key for the all the Configuration details in order to parse the config file Connectedevicesconfig.props
 *
 */
public class ConfigConst {

	public static final String SECTION_SEPARATOR  = ".";
	public static final String DEFAULT_CONFIG_FILE_NAME = "C:\\Users\\deepa\\git\\workspace\\iot-gateway\\config\\ConnectedDevicesConfig.props" ;
	
	public static final String CLOUD  = "cloud";
	public static final String SMTP  = "smtp";
	public static final String SMTP_CLOUD_SECTION   = SMTP + SECTION_SEPARATOR + CLOUD;
	public static final String COAP = "coap";
		    
	public static final String FROM_ADDRESS_KEY = "fromAddr";
	public static final String TO_ADDRESS_KEY   = "toAddr";
	
	public static final String HOST_KEY = "host";
	public static final String PORT_KEY = "port";
	public static final String USER_AUTH_TOKEN_KEY = "authToken";
	public static final String SMTP_PROP_HOST_KEY = "mail.smtp.host";
	public static final String SMTP_PROP_PORT_KEY = "mail.smtp.port";
	public static final String SMTP_PROP_AUTH_KEY = "mail.smtp.auth";
	public static final boolean ENABLE_AUTH_KEY = true;
	public static final String SMTP_PROP_ENABLE_TLS_KEY = "mail.smtp.starttls.enable";
	public static final boolean ENABLE_CRYPT_KEY = true;
	public static final String COAP_CLOUD = COAP + CLOUD;
	public static final String COAP_PROTOCOL = "coap";
	
	
	public ConfigConst() {
		
	}

}

