package hackathon.me.hackathon_proj.database.tables;


import com.google.firebase.database.DatabaseReference;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hackathon.me.hackathon_proj.database.data.UserData;

public class UserTable extends DatabaseTable<UserData>
{
	
	public UserTable()
	{
		super("users", UserData.class);
	}
	
	protected DatabaseReference newEntry(UserData entry)
	{
		return db.child(entry.email.replace(".", "-"));
	}
	
}
