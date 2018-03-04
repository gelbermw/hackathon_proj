package hackathon.me.hackathon_proj.database.data;

import android.annotation.SuppressLint;

public class EventUserData extends DatabaseData
{
	public int uid;
	public String name;
	public String role;
	
	public EventUserData(int uid, String name, String role)
	{
		this.uid = uid;
		this.name = name;
		this.role = role;
	}
	
	public int getUid()
	{
		return uid;
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
		return String.format("EventUser[%d, %s, %s]", uid, name, role);
	}
	
	
}
