/**
 * 
 */
package neu.dlokwani.connecteddevices.labs;
import neu.dlokwani.connecteddevices.common.*;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for all requisite Module05 functionality.
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
public class Module05Test
{
	
	
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
		ActuatorData actData = new ActuatorData();
		
		
		boolean y = dataUtil.writeActuatorDatatofile(actData);
		assertTrue(y);
	}
	
	/**
	 * Testing of the function to write the data in the database
	 */
	@Test
	public void testWriteActuatorDataToDBMS()
	{
		ActuatorData actData = new ActuatorData();
		PersistenceUtil persistenceUtil = new PersistenceUtil();
		
		boolean y = persistenceUtil.writeActuatorDataToDbms(actData);
		assertTrue(y);
	}
}
