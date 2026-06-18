import java.util.Scanner;

public class FitnessSystemUI
{
	private Scanner scanner;
	private User currentUser;
	private FitnessRecordManager recordManager;

	public FitnessSystemUI()
	{
		this.scanner=new Scanner(System.in);

		this.recordManager=new FitnessRecordManager("fitness_records.txt");
	}

	public static void main(String []args)
	{
		System.out.println("--- Welcome to Campus Fitness Tracking System ---");

		FitnessSystemUI ui=new FitnessSystemUI();
		ui.readInput();
	}

	public void readInput()
	{
		//Member C
		//1. print menu 1. 2. 3.
		//2. use scanner.nextInt to read input
		//3.use switch case to decide what will be executed 
		//4.use try-catch to handle exception
		System.out.print("Enter your username: ");
		String username=scanner.next();
		currentUser=new User(username);
		boolean running=true;

		while(running){
			System.out.println("\n---MENU---");
			System.out.println("1. Add Running Activity");
			System.out.println("2. Add Swimming Activity");
			System.out.println("3. Add Cycling Activity");
			System.out.println("4. View Dashboard");
			System.out.println("5. Save Data");
			System.out.println("6. Exit");
			System.out.println("Choose: ");

			try{
				int choice=scanner.nextInt();

				switch (choice){
					case 1:
						addRunning();
						break;

					case 2:
						addSwimming();
						break;

					case 3:
						addCycling();
						break;

					case 4:
						currentUser.displayDashboard();
						break;

					case 5:
						recordManager.saveUserData(currentUser);
						System.out.println("Data saved!!");
						break;

					case 6:
						running=false;
						System.out.println("Goodbye!!");
						break;

					default:
						System.out.println("Invalid choice. Try again.");
				}
			}catch (java.util.InputMismatchException e){
				System.out.println("Please enter a number!");
            	scanner.next();
			}



		}
	}

	private void addRunning(){
		try{
			System.out.print("Activity ID: ");
			String id=scanner.next();
			System.out.print("Date (e.g. 2026.6.18): ");
			String date=scanner.next();
			System.out.print("Duration (minutes): ");
			int duration=scanner.nextInt();
			System.out.print("Distance (km): ");
			double distance=scanner.nextDouble();

			Running r=new Running(id, date, duration, distance);
			r.setDurationInMinutes(duration);
			currentUser.addActivity(r);
			System.out.println("Running added!!!");
		} catch (InvalidDurationException e){
			System.out.println("Error: "+e.getMessage());
		}
	}

	private void addSwimming(){
		try{
			System.out.print("Activity ID: ");
			String id=scanner.next();
			System.out.print("Date (e.g. 2026.6.18): ");
			String date=scanner.next();
			System.out.print("Duration (minutes): ");
			int duration=scanner.nextInt();
			System.out.print("Laps: ");
			int laps=scanner.nextInt();

			Swimming s=new Swimming(id, date, duration, laps);
			s.setDurationInMinutes(duration);
			currentUser.addActivity(s);
			System.out.println("Swimming added!!!");
		} catch (InvalidDurationException e){
			System.out.println("Error: "+e.getMessage());
		}
	}

	private void addCycling(){
		try{
			System.out.print("Activity ID: ");
			String id=scanner.next();
			System.out.print("Date (e.g. 2026.6.18): ");
			String date=scanner.next();
			System.out.print("Duration (minutes): ");
			int duration=scanner.nextInt();
			System.out.print("Distance (km): ");
			double distance=scanner.nextDouble();
			System.out.print("Elevation Gain (m): ");
			double elevation=scanner.nextDouble();

			Cycling c=new Cycling(id, date, duration, distance, elevation);
			c.setDurationInMinutes(duration);
			currentUser.addActivity(c);
			System.out.println("Cycling added!!!");
		} catch (InvalidDurationException e){
			System.out.println("Error: "+e.getMessage());
		}
	}

}