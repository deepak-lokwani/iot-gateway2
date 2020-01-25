/**
 * @author deepak
 * NUID: 001316769
 */
package neu.dlokwani.connecteddevices.labs;

import neu.dlokwani.connecteddevices.labs.module01.*;

import static org.junit.Assert.assertTrue;
import java.lang.reflect.Type;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * Test class for all requisite Module01 functionality.
 * 
 * Instructions: 1) Rename 'testSomething()' method such that 'Something' is
 * specific to your needs; add others as needed, beginning each method with
 * 'test...()'. 2) Add the '@Test' annotation to each new 'test...()' method you
 * add. 3) Import the relevant modules and classes to support your tests. 4) Run
 * this class as unit test app. 5) Include a screen shot of the report when you
 * submit your assignment.
 * 
 * Please note: While some example test cases may be provided, you must write
 * your own for the class.
 */
public class Module01Test {
	SystemCpuUtilTask systemCpuUtilTask = new SystemCpuUtilTask();
	SystemMemUtilTask systemMemUtilTask = new SystemMemUtilTask();

	
	/**
	 * Test Method to verify unit test classes for the SystemCpuUtilTask class
	 * Condition 1: return value >	0.0%
	 * Condition 2: return value <	100%
	 */
	@Test
	public void testSystemCpuUtilTask() {
		assertTrue("The CPU Utilization is below 0%: 		", 	systemCpuUtilTask.getDataFromSensor()	>=  0.0	);
		assertTrue("The CPU Utilization is above 100%: 		", 	systemCpuUtilTask.getDataFromSensor()	<= 	100.0);
	}
	
	/**
	 * Test Method to verify unit test classes for the SystemMemUtilTask class
	 * Condition 1: return value >	0.0%
	 * Condition 2: return value <	100%
	 */
	@Test
	public void testSystemMemUtilTask() {
		assertTrue("The Memory Utilization is below 0%: 	", systemMemUtilTask.getDataFromSensor() 	>= 	0.0);
		assertTrue("The Memory Utilization is above 100%: 	", systemMemUtilTask.getDataFromSensor() 	<= 	100.0);
	}
}
