package neu.dlokwani.connecteddevices.labs.module05;

import neu.dlokwani.connecteddevices.labs.module05.GatewayDataManager;
/*
 * @author: Deepak lokwani
 * NUID: 001316769
 * 
 */

/*
 * this class is the main class and starts the thread
 */


public class GatewayHandlerApp {
	
	//Main Method
	public static void main(String[] args) {
		
		GatewayDataManager gateway_manager = new GatewayDataManager();
		gateway_manager.enableEmulator=true;
		gateway_manager.start();
	}

}
