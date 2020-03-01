package neu.dlokwani.connecteddevices.common;
import neu.dlokwani.connecteddevices.common.DataUtil;

/*
 * @author: Deepak lokwani
 * NUID: 001316769
 * 
 */

/*
 * This class listens to the sensor data on the DBMS and actuates the signal if the threshold are crossed
 */
public class SensorDataListener {

	public SensorDataListener() {
		// TODO Auto-generated constructor stub
	}
	/*
	 * This method print s and writes my sensor data to a file
	 */
	public void OnMessage(SensorData sensorData) {
		DataUtil dataUtil = new DataUtil();
		ActuatorData actuatordata = new ActuatorData();
		PersistenceUtil persistenceUtil = new PersistenceUtil();
		System.out.println("SensorData:  " + dataUtil.toJsonFromSensorData(sensorData));
		
		dataUtil.writeSensorDatatoFile(sensorData);
		
		if(sensorData.getCurValue()>20) {
			actuatordata.setCommand("Decrease temperature");
			persistenceUtil.writeActuatorDataToDbms(actuatordata);
		}
		else if(sensorData.getCurValue()<20) {
			actuatordata.setCommand("Increase Temperature");
			persistenceUtil.writeActuatorDataToDbms(actuatordata);
		}
	}
}
