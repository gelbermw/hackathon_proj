package hackathon.me.hackathon_proj.database.tables;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hackathon.me.hackathon_proj.database.data.UserData;

public class UserTable
{
	
	private Map<String, UserData> users;
	
	public UserTable()
	{
		users = new HashMap<>();
	}
	
}
