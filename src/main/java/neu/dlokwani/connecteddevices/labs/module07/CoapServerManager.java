package neu.dlokwani.connecteddevices.labs.module07;

/**
 * @author deepak
 * NUID: 001316769
 * 
 */

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.logging.Logger;
import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.CoapServer;
import org.eclipse.californium.core.network.CoapEndpoint;
import org.eclipse.californium.core.network.EndpointManager;

/**
 * 
 * This class is used to setup and start my local CoAp Server. It adds the requisite resources and end-points before starting it
 *
 * @param port = port number where the host is available for the CoAp communication
 * @param isServerRunning = is a boolean flag to know the running status of the server
 * @param areEndPointsAdded = is a boolean flag verify if the EndPoints are added or not
 * 
 */
public class CoapServerManager {

	//initializing my various instances
	private static final Logger log = Logger.getLogger(CoapServerManager.class.getName());
	private CoapServer coapServer ;
	private int port;
	public static boolean isServerRunning = false; 
	public static boolean areEndPointsAdded = false;
	
	/**
	 * Default Constructor
	 */
	public CoapServerManager() {
		super();
		this.port = 5683;
	}

	/**
	 * 
	 * @param resource: is an object of CoapResource required for CoAp communication
	 */
	public void addResource(CoapResource resource) {
		if (resource != null) {
			coapServer.add(resource);
		}
	}

	/**
	 * This method adds my end-points / sockets to the network interface for the CoAp server connection 
	 * And then toggles the areEndPointsAdded to true 
	 */
	public void addEndPoints() {
		for (InetAddress inetAddress : EndpointManager.getEndpointManager().getNetworkInterfaces()) {
			if (inetAddress.isLoopbackAddress()) {
				InetSocketAddress inetSocketAddress = new InetSocketAddress(inetAddress, port);
				coapServer.addEndpoint(new CoapEndpoint(inetSocketAddress));
				//toggling the flag
				areEndPointsAdded = true;
			}
		}
	}
	
	/**
	 * This method starts my CoAp server. Initial checks include null possibility of coapServer.
	 * It then adds the  resource and the end-points before start the server 
	 * After starting the server it toggles the isServerRunning flag to true 
	 */
	public void start() {
		if (coapServer == null) {
			coapServer = new CoapServer();
			log.info("Creating CoAP server instance and 'temperature' handler...");
			TempResourceHandler tempHandler = new TempResourceHandler("Temperature Resource");
			//adding my end-points
			addEndPoints();
			//adding my resource handler
			coapServer.add(tempHandler);
			
		}
		log.info("Starting CoAP server...");
		coapServer.start();
		//toggling the flag
		isServerRunning = true;
	}

	/**
	 * This method stops my CoAp server when called
	 * And then toggles the isServerRunning to false
	 * 
	 */
	public void stop() {
		log.info("Stopping CoAP server...");
		coapServer.stop();
		//toggling the flag
		isServerRunning = false;
	}

	
}
