/**
 * 
 */
package neu.dlokwani.connecteddevices.common;
import neu.dlokwani.connecteddevices.common.*;

import static org.junit.Assert.assertTrue;

import org.hamcrest.core.IsInstanceOf;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for SensorData functionality.
 * 
 * Instructions:
 * 1) Rename 'testSomething()' method such that 'Something' is specific to your needs; add others as needed, beginning each method with 'test...()'.
 * 2) Add the '@Test' annotation to each new 'test...()' method you add.
 * 3) Import the relevant modules and classes to support your tests.
 * 4) Run this class as unit test app.
 * 5) Include a screen shot of the report when you submit your assignment.
 * 
 * Please note: While some example test cases may be provided, you must write your own for the class.
 */
public class SensorDataTest
{
	// setup methods
	SensorData  sensorData = new SensorData();
	
	
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
	
	@Test
	public void testSensorData()
	{
		assertTrue(sensorData.getCurValue()<=30.0f && sensorData.getCurValue()>=0.0f );
		assertTrue(sensorData.getAvgValue()<=30.0f && sensorData.getAvgValue()>=0.0f );
//		assertTrue(sensorData.getMinValue()<=30.0f && sensorData.getMinValue()>=0.0f );
		assertTrue(sensorData.getMaxValue()<=30.0f && sensorData.getMaxValue()>=0.0f );
		
	}
	
}
