/**
 * 
 */
package neu.dlokwani.connecteddevices.labs.module02;

/**
 * @author deepak
 * NUID:001316769
 * This class performs the task of gathering the Sensor data at the regular intervals whenever the thread is called
 *
 */
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import neu.dlokwani.connecteddevices.common.SensorData;
import neu.dlokwani.connecteddevices.labs.module02.*;

/*
* @param timeInterval:time in seconds between each data generation/collection
* @param alertDifference: difference value required for the alert generation
* @param lowValue:lowest value of the temperature achieved/expected
* @param highValue: highest value of the temperature expected/achieved
* @param curTemp: current value of the temperature    
* @param enableEmulator:boolean state of the emulator, initialized to False
*/
public class TempSensorEmulatorTask {
	private static final Logger _logger = Logger.getLogger(TempSensorEmulatorTask.class.getName());
	SensorData sensor = new SensorData();
	SMTPClientConnector smtpConnector = new SMTPClientConnector();
	Random random = new Random();
	float lowVal = 0;
	float highVal = 30;
	float alertDiff = 3;
	float curValue;
	boolean enableEmulator = false;
	int timeInterval = 60;
	
	/*
	 * This sets my emulator to ON
	 */
	public void setEmulator() {
		enableEmulator = true;
	}
	
	/*
	 * This method gets data from the sensor and calls for the email alerts when the conditions are fulfilled
	 */
	public void getDataFromSensor() {
		while (true) {
			if (enableEmulator == true) {
				float curValue = lowVal + random.nextFloat() * (highVal - lowVal);
				sensor.addValue(curValue);
				System.out.println("New Temperature Value: ");
				System.out.println(sensor.getSensorData());
				if(Math.abs(curValue - sensor.getAvgValue()) > alertDiff) {
					sendNotification();
				}
				try {
					TimeUnit.SECONDS.sleep(timeInterval);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	/*
	 * This method sends the email notification to the user using SMTP Server
	 */
	public void sendNotification()
	{
	 try {
	 sensor.getSensorData();
	 String subject = "Temperature above threshold";
	 // my publishMessage() API takes byte[] as the pay-load for flexibility
	 this.smtpConnector.publishMessage(subject, sensor.getSensorData().getBytes());
	 } 
	 catch (Exception e) {
	 _logger.log(Level.WARNING, "Failed to send SMTP message.", e);
	 }
	}

}
