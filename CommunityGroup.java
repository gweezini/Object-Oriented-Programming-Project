import java.util.ArrayList;

public class CommunityGroup
{
	private String groupName;
	private ArrayList<User> groupMembers;//Associate with user

	//To initialize
	public CommunityGroup(String groupName)
	{
		this.groupName=groupName;
		this.groupMembers=new ArrayList<>();
	}

	public String getGroupName()
	{
		return groupName;
	}

	public void addMember(User user)
	{
		this.groupMembers.add(user);
	}

	public void displayGroupStats()
	{
		System.out.println("Group: "+groupName+" has "+groupMembers.size()+" members.");
	}
}