package neu.dlokwani.connecteddevices.common;

import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;

/*
 * @author: Deepak lokwani
 * NUID: 001316769
 * 
 */

/*
 * this class is used to  manipulate the all the data received and transmitted for the database management system
 */
public class DataUtil {

	private static FileWriter file;
	public DataUtil() {
		// TODO Auto-generated constructor stub
	}

	public String toJsonFromSensorData (SensorData sensorData) {
		
		String jsonData = null;
		if(sensorData!=null) {
			Gson gson = new Gson();
			jsonData = gson.toJson(sensorData);
		}
		return jsonData;
	}
	
	public SensorData toSensorDataFromJson(String jsonData) {
		SensorData sensorData = null;
		if(jsonData != null && jsonData.trim().length() > 0) {
			Gson gson = new Gson();
			sensorData = gson.fromJson(jsonData, SensorData.class);
		}
		return sensorData;
	}
	
	public boolean writeSensorDatatoFile(SensorData sensorData) {
		String jsonData = null;
		if(sensorData != null) {
			Gson gson = new Gson();
			jsonData = gson.toJson(sensorData);
		}
		try {
			file = new FileWriter("json_SensorData.txt", utf-8);
			file.append(jsonData);
			return true;
		}catch(IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public String toJsonFromActuatorData(ActuatorData actuatorData) {
		String jsonData = null;
		if(actuatorData != null) {
			Gson gson = new Gson();
			jsonData  =  gson.toJson(actuatorData);
		}
		return jsonData;
	}
	
	public ActuatorData toActuatorDataFromJson(String jsonData)
	{
		ActuatorData actuatorData = null;
		if (jsonData != null && jsonData.trim().length() > 0) {
			Gson gson = new Gson();
			actuatorData = gson.fromJson(jsonData, ActuatorData.class);
		}
		return actuatorData;
	}
	
	public boolean writeActuatorDatatofile(ActuatorData actuatorData) {
		String jsonData = null;
		if(actuatorData != null) {
			Gson gson = new Gson();
			jsonData = gson.toJson(actuatorData);
		}
		try {
			file = new FileWriter("json_ActuatorData.txt");
			file.append(jsonData);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
}
