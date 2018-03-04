package hackathon.me.hackathon_proj.database.data;

import android.annotation.SuppressLint;

public class EventUserData extends DatabaseData
{
	public String name;
	public String role;
	
	public EventUserData()
	{
	
	}
	
	public EventUserData(String name, String role)
	{
		this.name = name;
		this.role = role;
	}
	
	
	public String getName()
	{
		return name;
	}
	
	public String getRole()
	{
		return role;
	}
	
	@SuppressLint("DefaultLocale")
	public String toString()
	{
		return String.format("EventUser[%s, %s]", name, role);
	}
	
	
}
