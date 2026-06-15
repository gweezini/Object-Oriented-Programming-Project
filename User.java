import java.util.ArrayList;

public class User
{
	private String username;
	private double totalPoints;
	private HealthProfile profile;
	private ArrayList<Activity> activityLog;

	public User(String username)
	{
		this.username=username;
		this.totalPoints=0.0;
		this.activityLog=new ArrayList<>();
	}

	public String getUsername()
	{
		return username;
	}

	public double getTotalPoints()
	{
		return totalPoints;
	}

	public void addPoints(double points)
	{
		//Member B
	}

	public void addActivity(Activity activity)
	{
		//Member B
	}

	public void displayDashboard()
	{
		//Member B
	}
}