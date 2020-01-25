/**
 * @author deepak
 * NUID: 001316769
 */
package neu.dlokwani.connecteddevices.labs.module01;

public class GatewayHandlerApp {

	SystemPerformanceAdaptor systemPerformanceAdaptor = new SystemPerformanceAdaptor();
	Thread threadA = new Thread(systemPerformanceAdaptor);

	public GatewayHandlerApp() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GatewayHandlerApp gatewayHandlerApp = new GatewayHandlerApp();
		gatewayHandlerApp.run();

	}

	private void run() {
		// TODO Auto-generated method stub
		threadA.start();
	}

}
