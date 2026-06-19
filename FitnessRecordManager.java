import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class FitnessRecordManager
{
	private String fileName;

	public FitnessRecordManager(String fileName)
	{
		this.fileName=fileName;
	}

	// Member D: FileWriter Logic
	public void saveUserData(User user)
	{
		try (FileWriter writer = new FileWriter(fileName))
		{
			writer.write("USERNAME:" + user.getUsername() + "\n");

			if(user.getProfile()!=null)
			{
				writer.write("HEALTHPROFILE,"+user.getProfile().getHeightCm()+","+user.getProfile().getWeightKg()+"\n");
			}
			ArrayList<Activity> activities = user.getActivityLog();
			for (Activity a : activities)
			{
				if (a instanceof Running)
				{
					Running r = (Running) a;
					writer.write("Running," + r.getActivityId() + "," + r.getDate() + ","
						+ r.getDurationInMinutes() + "," + r.getDistanceKm() + "\n");
				}
				else if (a instanceof Swimming)
				{
					Swimming s = (Swimming) a;
					writer.write("Swimming," + s.getActivityId() + "," + s.getDate() + ","
						+ s.getDurationInMinutes() + "," + s.getLaps() + "\n");
				}
				else if (a instanceof Cycling)
				{
					Cycling c = (Cycling) a;
					writer.write("Cycling," + c.getActivityId() + "," + c.getDate() + ","
						+ c.getDurationInMinutes() + "," + c.getDistanceKm() + "," + c.getElevationGain() + "\n");
				}
			}
		}
		catch (IOException e)
		{
			System.out.println("Error saving data: " + e.getMessage());
		}
	}

	// Member D: read file with Scanner, reconstruct User and all Activity objects
	public User loadUserData()
	{
		File file = new File(fileName);
		if (!file.exists())
		{
			return null;
		}

		User user = null;

		try (Scanner fileScanner = new Scanner(file))
		{
			// First line must be USERNAME:<name>
			if (!fileScanner.hasNextLine())
			{
				return null;
			}

			String firstLine = fileScanner.nextLine().trim();
			if (!firstLine.startsWith("USERNAME:"))
			{
				return null;
			}

			String username = firstLine.substring("USERNAME:".length());
			user = new User(username);

			// Read each activity line
			while (fileScanner.hasNextLine())
			{
				String line = fileScanner.nextLine().trim();
				if (line.isEmpty()) continue;

				String[] parts = line.split(",");

				try
				{
					switch (parts[0])
					{
						case "HEALTHPROFILE":
						{
							double height=Double.parseDouble(parts[1]);
							double weight=Double.parseDouble(parts[2]);
							user.setProfile(new HealthProfile(height,weight));
							break;
						}
						case "Running":
						{
							String id       = parts[1];
							String date     = parts[2];
							int    duration = Integer.parseInt(parts[3]);
							double distance = Double.parseDouble(parts[4]);
							Running r = new Running(id, date, duration, distance);
							user.addActivity(r);
							break;
						}
						case "Swimming":
						{
							String id       = parts[1];
							String date     = parts[2];
							int    duration = Integer.parseInt(parts[3]);
							int    laps     = Integer.parseInt(parts[4]);
							Swimming s = new Swimming(id, date, duration, laps);
							user.addActivity(s);
							break;
						}
						case "Cycling":
						{
							String id        = parts[1];
							String date      = parts[2];
							int    duration  = Integer.parseInt(parts[3]);
							double distance  = Double.parseDouble(parts[4]);
							double elevation = Double.parseDouble(parts[5]);
							Cycling c = new Cycling(id, date, duration, distance, elevation);
							user.addActivity(c);
							break;
						}
						default:
							System.out.println("Unknown activity type skipped: " + parts[0]);
					}
				}
				catch (NumberFormatException e)
				{
					System.out.println("Skipping malformed record: " + line);
				}
			}
		}
		catch (IOException e)
		{
			System.out.println("Error loading data: " + e.getMessage());
			return null;
		}

		return user;
	}

}