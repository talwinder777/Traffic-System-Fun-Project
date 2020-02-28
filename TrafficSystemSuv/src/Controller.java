import java.util.Scanner;

public class Controller {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner userInput = new Scanner(System.in);
		
		//command to be given to the Suv
		String command = "";
		
		//State defines 4 given states 1. Move Forward 2. Turn Right 3. Turn Left 4. Run Over Ford Pinto
		String state = "";
		
		//currentStateOfSuv tells the last state of the Suv out of the four given states
		String currentStateSuv = "";
		
		System.out.println("Enter the intitial stop light signal :- \n 1 for Green\n 2 for Yellow\n 3 for Red\n 4 for Left-Turn Green");
		int currentSignal = userInput.nextInt();
		
		//initializing the vehicle and traffic stop light
		Suv suv = null;
		TrafficLights trafLights = new TrafficLights(currentSignal);
		
		System.out.println("\nEnter the command for the Vehicle like :- \n moveForward\n turnLeft\n turnRight\n runOverFordPinto\n End");
		//Vehicle keeps on following commands until given the End command given to it
		while(!command.equals("End")){
			
			command = userInput.next();
			
			System.out.println("\nStop Light's Color before the command ------> "+trafLights.toString());
				
			//if the given command is move forward but the vehicle was already moving then return the error otherwise get the state according to the stop light
			if(currentStateSuv.equals(command) && command.equals("moveForward")) {
				System.out.println("\n"+"ERROR! PLEASE TRY ANOTHER COMMAND AS SUV IS ALREADY MOVING FORWARD"+"\n");
			}
			//the suv can only run over Ford Pinto if last command is moveForward otherwise it shows an error
			else if(!(currentStateSuv.equals("moveForward")) && command.equals("runOverFordPinto")) {
				System.out.println("\n"+"CAN'T DO THAT AS SUV LAST COMMAND WAS NOT MOVE FORWARD"+"\n");
			}
			else {
				suv = new Suv(command, trafLights);
				state = suv.state();
			}
			//saving the just previous state of the vehicle
			currentStateSuv = state;

			System.out.println("state of Truck =====>> "+ state);
			System.out.println("Stop Light's color after the command changes to ------> "+trafLights.toString());
		}
		
		System.out.println("\nThanks for Driving!!");
	}

}
