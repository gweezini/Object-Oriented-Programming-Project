public abstract class Activity implements Rewardable
{
	private String activityId;
	private String date;
	private int durationInMinutes;

	public Activity(String activityId, String date, int durationInMinutes)
	{
		this.activityId=activityId;
		this.date=date;
		this.durationInMinutes=durationInMinutes;
	}

	public void setActivityId(String activityId)
	{
		this.activityId=activityId;
	}

	public String getActivityId()
	{
		return activityId;
	}

	public void setDate(String date)
	{
		this.date=date;
	}

	public String getDate()
	{
		return date;
	}

	public void setDurationInMinutes(int durationInMinutes) throws InvalidDurationException
	{
		if(durationInMinutes<=0)
		{
			throw new InvalidDurationException("Duration must be greater than 0!");
		}
		this.durationInMinutes=durationInMinutes;
	}

	public int getDurationInMinutes()
	{
		return durationInMinutes;
	}

	//polymorphism
	public abstract double calculateCalories();

	public abstract double calculatePoints();

}