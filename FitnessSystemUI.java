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
	}

}