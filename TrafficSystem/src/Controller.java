import java.util.*;

public class Controller {
	
	private static final int GREEN = 1;
	private static final int YELLOW = 2;
	private static final int RED = 3;
	private static final int LEFTTURNGREEN = 4;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner userInput = new Scanner(System.in);
		
		//command to be given to the Semi
		String command = "";
		
		//State defines 4 given states 1. Move Forward 2. Turn Right 3. Turn Left 4. Jack Knife to a Stop
		String state = "";
		
		//currentStateOfSemi tells the last state of the eighteenWheeler out of the four given states
		String currentStateOfSemi = "";
		boolean isJackKnifeToStop = false;
		
		System.out.println("Enter the intitial stop light signal\n 1 for Green\n 2 for Yellow\n 3 for Red\n 4 for Left-Turn Green");
		int currentSignal = userInput.nextInt();
		
		//initializing the vehicle and traffic stop light
		EighteenWheeler semi = null;
		TrafficLights trafLights = new TrafficLights(currentSignal);
		
		//Vehicle keeps on following commands until given the End command
		while(!command.equals("End")){
			
			System.out.println("\nEnter the command for the Vehicle");
			command = userInput.next();
			
			System.out.println("\nStop Light's Color before the command ------> "+trafLights.toString());
			
			//if jack knifing situation has ever happened then keep on moving forward i:e the state of the vehicle must not change
			if(isJackKnifeToStop)
				semi = new EighteenWheeler("moveForward", trafLights);
			else
				semi = new EighteenWheeler(command, trafLights);
			
			//if the given command is move forward but the vehicle was already moving then return the error otherwise get the state according to the stop light
			if(currentStateOfSemi.equals(command) && command.equals("moveForward")) {
				System.out.println("\n"+"ERROR! PLEASE TRY ANOTHER COMMAND AS SEMI IS ALREADY MOVING FORWARD"+"\n");
			}
			else
				state = semi.state();
			
			//saving the just previous state of the vehicle
			currentStateOfSemi = state;
			
			//making a note if ever jack knife to stop happened
			if(state.equals("jackKnifeToStop"))
				isJackKnifeToStop = true;
			
			System.out.println("state of Truck =====>> "+ state);
			System.out.println("Stop Light's color after the command changes to ------> "+trafLights.toString());
		}

	}

}
