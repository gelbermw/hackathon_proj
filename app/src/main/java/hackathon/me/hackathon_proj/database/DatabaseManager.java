package hackathon.me.hackathon_proj.database;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import hackathon.me.hackathon_proj.database.data.EventData;
import hackathon.me.hackathon_proj.database.data.EventUserData;
import hackathon.me.hackathon_proj.database.data.UserData;
import hackathon.me.hackathon_proj.database.tables.EventUserTable;
import hackathon.me.hackathon_proj.database.tables.EventsTable;
import hackathon.me.hackathon_proj.database.tables.UserTable;

public class DatabaseManager
{
	
	private EventsTable eventTable;
	private UserTable userTable;
	private EventUserTable eut;
	
	public DatabaseManager()
	{
		eventTable = new EventsTable();
		userTable = new UserTable();
	}
	
	/*******************************************************
	 User Data Stuffs
	 *******************************************************/
	public void loadUserData()
	{
		userTable.loadData();
	}
	
	public void registerUser(String name, int age, String email, String password, String occupation)
	{
		userTable.addEntry(new UserData(name, email, password, age, true, occupation));
	}
	
	public UserData getUserByEmail(String email)
	{
		for (Map.Entry<String, UserData> entries : userTable.getData().entrySet())
		{
			if (entries.getValue().email.equalsIgnoreCase(email))
			{
				return entries.getValue();
			}
		}
		return null;
	}
	
	public boolean canLogin(String email, String password)
	{
		UserData user = getUserByEmail(email);
		return user != null && user.password.equals(password);
	}
	
	public List<UserData> getAllUsers()
	{
		return new ArrayList<>(userTable.getData().values());
	}
	
	public boolean userExists(String email)
	{
		return userTable.containsKey(email);
	}
	
	/*******************************************************
	 Event Stuffs
	 *******************************************************/
	public void loadEventData()
	{
		eventTable.loadData();
	}
	
	public void registerEvent(String title, String desc, String category, String organization, String date, String location)
	{
		EventData eventData = new EventData(title, category, desc, date, organization, location);
		eventTable.addEntry(eventData);
	}
	
	public List<EventData> getAllEvents()
	{
		return new ArrayList<>(eventTable.getData().values());
	}
	
	public void addParticipant(String name, String event, String role)
	{
		eut = new EventUserTable(event);
		eut.addEntry(new EventUserData(name, role));
	}
}
