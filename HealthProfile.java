public class HealthProfile
{
	private double heightCm;
	private double weightKg;

	public HealthProfile(double heightCm,double weightKg)
	{
		this.heightCm=heightCm;
		this.weightKg=weightKg;
	}

	public void setHeightCm(double heightCm)
	{
		this.heightCm=heightCm;
	}

	public double getHeightCm()
	{
		return heightCm;
	}

	public void setWeightKg(double weightKg)
	{
		this.weightKg=weightKg;
	}

	public double getWeightKg()
	{
		return weightKg;
	}

	public double calculateBMI()
	{
		double heightM=heightCm/100;
		
		return weightKg/(heightM*heightM);
	}
}