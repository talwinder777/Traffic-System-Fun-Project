//Main Parent class that support common movements of vehicles

public class Vehicle {
	
	private String moveForward;
	private String turnRight;
	private String turnLeft;
	
	public String getMoveForward() {
		return moveForward;
	}
	public void setMoveForward(String moveForward) {
		this.moveForward = moveForward;
	}
	public String getTurnRight() {
		return turnRight;
	}
	public void setTurnRight(String turnRight) {
		this.turnRight = turnRight;
	}
	public String getTurnLeft() {
		return turnLeft;
	}
	public void setTurnLeft(String turnLeft) {
		this.turnLeft = turnLeft;
	}
}
