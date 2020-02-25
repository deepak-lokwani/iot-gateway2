package neu.dlokwani.connecteddevices.labs.module05;

import neu.dlokwani.connecteddevices.common.ActuatorData;
import neu.dlokwani.connecteddevices.common.PersistenceUtil;

/*
 * @author: Deepak lokwani
 * NUID: 001316769
 * 
 */

/*
 * this class is responsible for the Data management from the gateway end
 */
public class GatewayDataManager extends Thread {
	
	//Creating Variables
	boolean enableEmulator = false;
	//Overriding run method of thread class 
	@Override
	public void run() {
		try {
			while (true) {
				
				if (enableEmulator) {
					PersistenceUtil persist_util = new PersistenceUtil();
					ActuatorData actuator_data = new ActuatorData();
					persist_util.writeSensorDataToDbms();
					persist_util.writeActuatorDataToDbms(actuator_data);
					
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
}
