/**
 * @author deepak
 * NUID: 001316769
 */
package neu.dlokwani.connecteddevices.labs.module01;

public class SystemPerformanceAdaptor implements Runnable {

	/*
	 * initializing the variables and the creating the instances of the CPU & Memory classes
	 */
	protected boolean done = false;
	SystemCpuUtilTask systemCpuUtilTask = new SystemCpuUtilTask();
	SystemMemUtilTask systemMemUtilTask = new SystemMemUtilTask();

	public SystemPerformanceAdaptor() {
		// TODO Auto-generated constructor stub

	}

	/*
	 * Run method for the thread
	 */
	public void run() {
		// TODO Auto-generated method stub
		while (!done) {
			doWork();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

	/*
	 * Do work while the thread is running
	 */
	private void doWork() {
		// TODO Auto-generated method stub
		systemCpuUtilTask.getDataFromSensor();
		systemMemUtilTask.getDataFromSensor();
	}

}
