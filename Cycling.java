public class Cycling extends Activity
{
	private double elevationGain;
	private double distanceKm;

	public Cycling(String activityId,String date,int durationInMinutes,double distanceKm, double elevationGain)
	{
		super(activityId,date,durationInMinutes);
		this.elevationGain=elevationGain;
		this.distanceKm=distanceKm;
	}

	public void setElevationGain(double elevationGain)
	{
		this.elevationGain=elevationGain;
	}

	public double getElevationGain()
	{
		return elevationGain;
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
		//Member B

		return 0.0;
	}

}