
/*
 * This class is made for Suv Vehicle that helps tracks its movements according to the Traffic Stop light and the command.
 */
public class Suv extends Vehicle{
	private String RunOverFordPinto;
	private String command;
	private TrafficLights color;
	
	//constructor accepting the command and stop light's object
	public Suv(String command, TrafficLights currentSignal) {
		this.command = command;
		this.color = currentSignal;
	}
	
	//Return the state of the vehicle according to the Stop Light and the command given to the vehicle
	public String state() {
		String currentState = "StandingStill";
		
		switch (command) {
		case "moveForward":
			// 1 implies Green Color
			if(color.getColor() == 1) {
				setMoveForward(command);
				currentState = getMoveForward();
				}
			break;
		case "turnRight":
			if(color.getColor() == 1) {
				setTurnRight(command);
				currentState = getTurnRight();
			}
			break;
		case "turnLeft":
			//only turning left if currentSignal is leftTurnGreen and 4 implies leftTurnGreen
			if(color.getColor() == 4) {
				setTurnLeft(command);
				currentState = getTurnLeft();
			}
			else
				currentState = "Cant turn Left as Light is not Left-Turn Green";
			break;
		case "runOverFordPinto":
			
			if(color.getColor() == 1) {
				setMoveForward(command);
				currentState = getMoveForward();
			}
			break;		
		default:
			currentState = "Wrong Move";
			break;
		}
		color.setColor(1); 
		return currentState;
	}

	public String getRunOverFordPinto() {
		return RunOverFordPinto;
	}

	public void setRunOverFordPinto(String runOverFordPinto) {
		RunOverFordPinto = runOverFordPinto;
	}

	
	
	
}
