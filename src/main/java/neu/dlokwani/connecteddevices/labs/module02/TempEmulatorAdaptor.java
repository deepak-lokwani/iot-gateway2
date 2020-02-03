/**
 * 
 */
package neu.dlokwani.connecteddevices.labs.module02;

/**
 * @author deepak
 * NUID:001316769
 * 
 * This class is created to periodically call the TempSensorEmulatorTask  class to update the sensor values and the  user notification if required 
 *
 */
public class TempEmulatorAdaptor implements Runnable{
	
	/*
	 * this class is made runnable for future purposes when the functionality will  increase 
	 */
	TempSensorEmulatorTask tempSen = new TempSensorEmulatorTask();
	private boolean done = false;
	
	/*
	 * Constructor
	 * Also used to set the Emulator ON
	 */
	public TempEmulatorAdaptor() {
		// TODO Auto-generated constructor stub
		tempSen.setEmulator();
	}

	/**
	 * @param args
	 */
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//	}

	/*
	 * Default thread.run method called when the thread starts
	 */
	public void run() {
		// TODO Auto-generated method stub
		while(!done) {
			doWork();
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private void doWork() {
		tempSen.getDataFromSensor();
	}

}
