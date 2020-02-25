package neu.dlokwani.connecteddevices.common;


/*
 * @author: Deepak lokwani
 * NUID: 001316769
 * 
 */

/*
 * this class is responsible for the writing the actuator data on the file
 */
public class ActuatorDataListener {

	public ActuatorDataListener() {
		// TODO Auto-generated constructor stub
	}
	
	public void OnMessage() {
		DataUtil dataUtil = new DataUtil();
		ActuatorData actuatorData = new ActuatorData();
		System.out.println("Actuator Data sent to DBMS");
		dataUtil.writeActuatorDatatofile(actuatorData);
	}

}
