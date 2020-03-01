/**
 * 
 */
package neu.dlokwani.connecteddevices.common;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;

/**
 * Test class for DataUtil functionality.
 * 
 * Instructions:
 * 1) Rename 'testSomething()' method such that 'Something' is specific to your needs; add others as needed, beginning each method with 'test...()'.
 * 2) Add the '@Test' annotation to each new 'test...()' method you add.
 * 3) Import the relevant modules and classes to support your tests.
 * 4) Run this class as unit test app
 * 5) Include a screen shot of the report when you submit your assignment
 * 
 * Please note: While some example test cases may be provided, you must write your own for the class.
 */
public class DataUtilTest
{
	// setup methods
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception
	{
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception
	{
	}
	
	// test methods
	
	/**
	 * this tests the Json conversion from the Actuator data instance  
	 */
	@Test
	public void testActuatorDataToJson()
	{
	ActuatorData act_data = new ActuatorData();
	DataUtil dataUtil = new DataUtil();
	Gson gson = new Gson();
	String jsonData = gson.toJson(act_data);
	ActuatorData actData = dataUtil.toActuatorDataFromJson(jsonData);

	assertTrue(act_data.getName().equals(actData.getName()));
	assertTrue(act_data.getCommand().equals(actData.getCommand()));
	}

	
	/**
	 * this tests the Json conversion from the Sensor data instance  
	 */
	@Test
	public void testSensorDataToJson()
	{
		SensorData sen_data = new SensorData();
		DataUtil dataUtil = new DataUtil();
		Gson gson = new Gson();
		String jsonData = gson.toJson(sen_data);
		SensorData senData = dataUtil.toSensorDataFromJson(jsonData);

		assertTrue(sen_data.getName().equals(senData.getName()));
		assertTrue(sen_data.getCurValue()==(senData.getCurValue()));
	}
	
	/**
	 * Test the functioning of the JSon to ActuatorData instance conversion 
	 */
	@Test
	public void testJsonToActuatorData()
	{
		String jsonSample = "{This: is; a: Sample; JSON: Data; for : testing}";
		Gson gson = new Gson();
		ActuatorData actuatorData = gson.fromJson(jsonSample, ActuatorData.class);
		assertTrue(actuatorData instanceof ActuatorData); 
	}
	
	
	
	/**
	 * Test the functioning of the JSon to SensorData instance conversion 
	 */
	@Test
	public void testJsonToSensorData()
	{
		String jsonSample = "{This: is; a: Sample; JSON: Data; for : testing}";
		Gson gson = new Gson();
		SensorData sensorData  = gson.fromJson(jsonSample, SensorData.class);
		assertTrue(sensorData instanceof SensorData);
	}
	
	/**
	 * Testing of the function to write the data in a file 
	 */
	@Test
	public void testWriteSensorDataToFile()
	{
		DataUtil dataUtil = new DataUtil();
		SensorData sensorData =  new SensorData();
		
		
		boolean x = dataUtil.writeSensorDatatoFile(sensorData);
		assertTrue(x);
		
	}
	
	/**
	 * Testing of the function to write the data in a file 
	 */
	@Test
	public void testWriteActuatorDataToFile()
	{
		DataUtil dataUtil = new DataUtil();
		SensorData sensorData =  new SensorData();
		ActuatorData actData = new ActuatorData();
		
		
		boolean y = dataUtil.writeActuatorDatatofile(actData);
		assertTrue(y);
	}
}
