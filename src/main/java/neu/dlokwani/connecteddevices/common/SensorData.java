/**
 * 
 */
package neu.dlokwani.connecteddevices.common;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author deepak
 * NUID: 001316769
 * 
 * This Class contains the sensor data and passes on to the TempEmulatorTask Class
 *
 */
public class SensorData implements Serializable
{
	private String timeStamp = null;
	private String name = "Temperature Attributes Java";
	private float curValue = 0.0f;
	private float avgValue = 0.0f;
	private float minValue = Float.MAX_VALUE;
	private float maxValue = 0.0f;
	private float totValue = 0.0f;
	private int sampleCount = 0;
	public SensorData()
	{
		super();
		
	}
	public void updateTimeStamp() {
		System.out.println("________________________________________________");
		LocalDate ld = LocalDate.now();
		LocalTime lt = LocalTime.now();
		System.out.print("Time:" + ld);
		System.out.println("\t" + lt);
		
	}
	public void addValue(float val)
	{
		updateTimeStamp();
		++this.sampleCount;
		this.curValue = val;
		this.totValue += val;
		if (this.curValue < this.minValue) {
		this.minValue = this.curValue;
		}
		if (this.curValue > this.maxValue) {
		this.maxValue = this.curValue;
		}
		if (this.totValue != 0 && this.sampleCount > 0) {
		this.avgValue = this.totValue / this.sampleCount;
	}
 }
	public String getSensorData() {

		String outputScreen ;
		outputScreen = name + "\n\tCurrent Value: " + curValue + "\n\tAverage Value: "
		+ avgValue + "\n\tMin Value: " + minValue + "\n\tMax Value: " + maxValue +  "\n\tSampleCount: " + sampleCount;
		return outputScreen;
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getCurValue() {
		return curValue;
	}
	public float getAvgValue() {
		return avgValue;
	}
	public float getMinValue() {
		return minValue;
	}
	public float getMaxValue() {
		return maxValue;
	}
	public float getTotValue() {
		return totValue;
	}
	public int getSampleCount() {
		return sampleCount;
	}
}
