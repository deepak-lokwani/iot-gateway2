/**
 * 
 */
package neu.dlokwani.connecteddevices.labs.module06;
import neu.dlokwani.connecteddevices.labs.module06.GatewayDataManager;

/**
 * @author Deepak Lokwani
 * NUID: 001316769
 */

/**
 * This class is the main class and it starts my thread to the GatwayDataManager which in turns 
 * instantiates and connects to the MQTT broker
 */
public class GatewayHandlerApp {

	/**
	 * @param enableEmulator = Setting the thread emulator
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GatewayDataManager gateway_manager = new GatewayDataManager();
		gateway_manager.enableEmulator=true;
		gateway_manager.start();
	}

}
