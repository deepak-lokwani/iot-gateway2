/**
 * 
 */
package neu.dlokwani.connecteddevices.labs;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import neu.dlokwani.connecteddevices.labs.module06.MQTTClientConnector;
/**
 * Test class for all requisite Module06 functionality.
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
public class Module06Test
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
	 * 
	 */
	@Test
	public void testMqtt_Connect()
	{
		MQTTClientConnector mqttClientConnector = new MQTTClientConnector();
		assertTrue(mqttClientConnector.mqtt_connect());
	}
	@Test
	public void testMqtt_Subscribe()
	{
		MQTTClientConnector mqttClientConnector = new MQTTClientConnector();
		mqttClientConnector.mqtt_connect();
		assertTrue(mqttClientConnector.mqtt_subscribe());
	}
	@Test
	public void testMqtt_Unsubscribe()
	{
		MQTTClientConnector mqttClientConnector = new MQTTClientConnector();
		mqttClientConnector.mqtt_connect();
		assertTrue(mqttClientConnector.unSubscribe());
		
	}
	@Test
	public void testMqtt_Disconnect()
	{
		MQTTClientConnector mqttClientConnector = new MQTTClientConnector();
		mqttClientConnector.mqtt_connect();
		assertTrue(mqttClientConnector.disconnect());
	}

	
}
