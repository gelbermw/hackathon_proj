package hackathon.me.hackathon_proj.database.data;


import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.List;

@IgnoreExtraProperties
public class EventData extends DatabaseData
{
	
	public String title;
	public String category;
	public String description;
	public String date;
	public String organization;
	public String location;
	
	
	public EventData()
	{
	}
	
	public EventData(String title, String category, String description, String date, String organization, String location)
	{
		this.title = title;
		this.category = category;
		this.description = description;
		this.date = date;
		this.organization = organization;
		this.location = location;
	}
	
	public String getTitle()
	{
		
		return title;
	}
	
	public String getCategory()
	{
		return category;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public String getLocation()
	{
		return location;
	}
	
	public String getDate()
	{
		return date;
	}
	
	public String getOrganization()
	{
		return organization;
	}
	
	public String toString()
	{
		return title;//String.format("Event[%s, %s, %s, %s, %s]", title, category, description, date, organization);
	}
}
