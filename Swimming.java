public class Swimming extends Activity
{
	private int laps;

	public Swimming(String activityId, String date, int durationInMinutes, int laps)
	{
		super(activityId,date,durationInMinutes);
		this.laps=laps;
	}

	public void setLaps(int laps)
	{
		this.laps=laps;
	}

	public int getLaps()
	{
		return laps;
	}

	public double calculateCalories()
	{
		// Member B

		return 0.0;
	}

	public double calculatePoints()
	{
		// Member B

		return 0.0;
	}
}