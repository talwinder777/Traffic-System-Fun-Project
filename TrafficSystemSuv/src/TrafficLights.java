//The class represents a Stop-light that is either Green, Red, Yellow or LeftTurnGreen
public class TrafficLights {
	private int stopLightColor;
	
	public TrafficLights(int color) {
		this.stopLightColor = color;
	} 
	
	
	public int getColor() {
		return stopLightColor;
	}

	public void setColor(int color) {
		this.stopLightColor = color;
	}
	@Override
	public String toString() {
		String color = "";
		if(stopLightColor == 1)
			color = "Green";
		else if(stopLightColor == 2)
			color = "Yellow";
		else if(stopLightColor == 3)
			color = "Red";
		else
			color = "LeftTurnGreen";
		return color;
	}
}
