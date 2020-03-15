package neu.dlokwani.connecteddevices.labs.module07;

import java.util.logging.Logger;
import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.coap.CoAP.ResponseCode;
import org.eclipse.californium.core.server.resources.CoapExchange;

/**
 * 
 * @author deepak lokwani
 * NUID: 001316769
 * Assignment no: 07
 *
 */

/**
 * 
 * This class inherits from the CoapResource. 
 * This class creates and manages my temperature resource 
 * 
 */
public class TempResourceHandler extends CoapResource {
	
	private static final Logger _Logger = Logger.getLogger(TempResourceHandler.class.getName());
	
	/**
	 * Default Constructor
	 * @param name: identifies the resource handler name for me
	 */
	public TempResourceHandler(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * this class is a constructor to different variables
	 * @param name: identifies the resource handler name for me
	 * 
	 */
	public TempResourceHandler(String name, boolean visible) {
		super(name, visible);
		}
	
	/**
	 * Override method of the CoapResource class
	 * This method is used to handle the GET exchange
	 * @param exchange: exchange the CoapExchange for the simple API
	 */
	@Override
	public void handleGET(CoapExchange exchange) {
		exchange.respond(ResponseCode.VALID, "Get resource ");
		_Logger.info("Get request：" + super.getName());
	}

	
	/**
	 * Override method of the CoapResource class
	 * This method is used to handle the POST exchange
	 * @param exchange: exchange the CoapExchange for the simple API
	 */
	@Override
	public void handlePOST(CoapExchange exchange) {
		exchange.respond(ResponseCode.CREATED, "Post resource ");
		_Logger.info("Post request：" + exchange.getRequestText());
	}

	/**
	 * Override method of the CoapResource class
	 * This method is used to handle the PUT exchange
	 * @param exchange: exchange the CoapExchange for the simple API
	 */
	@Override
	public void handlePUT(CoapExchange exchange) {
		exchange.respond(ResponseCode.CHANGED, "Put resource");
		_Logger.info("Put request：" + exchange.getRequestText());
	}

	/**
	 * Override method of the CoapResource class
	 * This method is used to handle the DELETE exchange
	 * @param exchange: exchange the CoapExchange for the simple API
	 */
	@Override
	public void handleDELETE(CoapExchange exchange) {
		exchange.respond(ResponseCode.DELETED, "Delete resource");
		_Logger.info("Delete request：" + super.getName());
	}

}
