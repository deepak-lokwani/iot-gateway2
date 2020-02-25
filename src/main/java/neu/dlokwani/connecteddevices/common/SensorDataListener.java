package neu.dlokwani.connecteddevices.common;
import neu.dlokwani.connecteddevices.common.DataUtil;

/*
 * @author: Deepak lokwani
 * NUID: 001316769
 * 
 */

public class SensorDataListener {

	public SensorDataListener() {
		// TODO Auto-generated constructor stub
	}

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
	}
}
