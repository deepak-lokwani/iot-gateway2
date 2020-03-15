package neu.dlokwani.connecteddevices.labs.module07;

/**
 * 
 * @author deepak lokwani
 * NUID: 001316769
 * Assignment number: 07 
 *
 */

/**
 * This is my main class. The server program is called and starts here
 */

public class GatewayHandlerApp {

	/*
	 * My main method for the program
	 * This method instantiates and starts my start method
	 */
	public static void main(String[] args) {
		GatewayHandlerApp gatewayHandlerApp = new GatewayHandlerApp();
		
		//method to start my server is called here
		try {
			gatewayHandlerApp.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Default Constructor
	 */
	public GatewayHandlerApp() {
		super();
		// TODO Auto-generated constructor stub
	}

	/*
	 * Method to start my Coap local server
	 */
	public void start() {
		CoapServerManager coapServerManager = new CoapServerManager();
		coapServerManager.start();
	}

}
