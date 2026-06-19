import java.util.Scanner;

public class FitnessSystemUI
{
	private Scanner scanner;
	private User currentUser;
	private FitnessRecordManager recordManager;
	private CommunityGroup campusGroup;

	public FitnessSystemUI()
	{
		this.scanner=new Scanner(System.in);

		this.recordManager=new FitnessRecordManager("fitness_records.txt");
		this.campusGroup=new CommunityGroup("UTM Camous Fitness Club");
	}

	public static void main(String []args)
	{
		System.out.println("--- Welcome to Campus Fitness Tracking System ---");

		FitnessSystemUI ui=new FitnessSystemUI();
		ui.readInput();
	}

	public void readInput()
	{

		// Member D: auto-load saved data on startup
		User savedUser = recordManager.loadUserData();
		if (savedUser != null)
		{
			currentUser = savedUser;
			System.out.println("Welcome back, " + currentUser.getUsername() + "! Your data has been loaded.");
			campusGroup.addMember(currentUser);//auto add dalam community group
		}
		else
		{
			System.out.print("Enter your username: ");
			String username = scanner.nextLine();
			currentUser = new User(username);
			campusGroup.addMember(currentUser);
		}

		boolean running=true;

		while(running){
			System.out.println("\n---MENU---");
			System.out.println("1. Add Running Activity");
			System.out.println("2. Add Swimming Activity");
			System.out.println("3. Add Cycling Activity");
			System.out.println("4. View Dashboard");
			System.out.println("5. Save Data");
			System.out.println("6. Setup/Update Health Profile");
			System.out.println("7. View Community Group Stats");
			System.out.println("8. Exit");
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
						updateHealthProfile();
						break;
					
					case 7:
						campusGroup.displayGroupStats();
						break;

					case 8:
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

			if(duration<=0)
			{
				throw new InvalidDataException("Duration must be greater than 0!");
			}
			System.out.print("Distance (km): ");
			double distance=scanner.nextDouble();
			if(distance<0)
			{
				throw new InvalidDataException("Distance cannot be negative!");
			}
			Running r=new Running(id, date, duration, distance);
			r.setDurationInMinutes(duration);
			currentUser.addActivity(r);
			System.out.println("Running added!!!");
		} catch (InvalidDataException e){
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
			if(duration<=0)
			{
				throw new InvalidDataException("Duration must be greater than 0!");
			}
			System.out.print("Laps: ");
			int laps=scanner.nextInt();
			if(laps<0)
			{
				throw new InvalidDataException("Laps cnnot be negative!");
			}

			Swimming s=new Swimming(id, date, duration, laps);
			s.setDurationInMinutes(duration);
			currentUser.addActivity(s);
			System.out.println("Swimming added!!!");
		} catch (InvalidDataException e){
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
			if(duration<=0)
			{
				throw new InvalidDataException("Duration must be greater than 0!");
			}
			System.out.print("Distance (km): ");
			double distance=scanner.nextDouble();
			if(distance<0)
			{
				throw new InvalidDataException("Distance cannot be negative!");
			}
			System.out.print("Elevation Gain (m): ");
			double elevation=scanner.nextDouble();
			if(elevation<0)
			{
				throw new InvalidDataException("Elevation Gain cannot be negative!");
			}

			Cycling c=new Cycling(id, date, duration, distance, elevation);
			c.setDurationInMinutes(duration);
			currentUser.addActivity(c);
			System.out.println("Cycling added!!!");
		} catch (InvalidDataException e){
			System.out.println("Error: "+e.getMessage());
		}
	}

	private void updateHealthProfile()
	{
		System.out.print("Enter Height (cm): ");
		double height=scanner.nextDouble();
		System.out.print("Enter Weight (kg): ");
		double weight=scanner.nextDouble();

		HealthProfile profile=new HealthProfile(height,weight);
		currentUser.setProfile(profile);
		System.out.println("Health Profile updated successfully!");
	}

}