public class Running extends Activity
{
	private double distanceKm;

	public Running(String activityId, String date, int durationInMinutes, double distanceKm)
	{
		super(activityId,date,durationInMinutes);
		this.distanceKm=distanceKm;
	}

	public void setDistanceKm(double distanceKm)
	{
		this.distanceKm=distanceKm;
	}

	public double getDistanceKm()
	{
		return distanceKm;
	}

	public double calculateCalories()
	{
		//Member B
		
		return 0.0;
	}

	public double calculatePoints()
	{
		// Member B
		
		return 0.0;
	}
}