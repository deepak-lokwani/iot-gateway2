package neu.dlokwani.connecteddevices.common;

/*
 * @author: Deepak lokwani
 * NUID: 001316769
 * 
 */
/*
 * this class is used to manipulate the Actuator Data and its commands
 */
public class ActuatorData {
	
	//Declaring Variables
	String name = "";
	String command = "";
	int value = 0;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "ActuatorData [name=" + name + ", command=" + command + ", value=" + value + "]";
	}
	
	
	

}