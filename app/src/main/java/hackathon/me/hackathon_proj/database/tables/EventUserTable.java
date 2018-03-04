package hackathon.me.hackathon_proj.database.tables;

import com.google.firebase.database.DatabaseReference;

import hackathon.me.hackathon_proj.database.data.EventData;
import hackathon.me.hackathon_proj.database.data.EventUserData;

public class EventUserTable extends DatabaseTable<EventUserData>
{
	public EventUserTable(String eventTitle)
	{
		super("event_users/" + eventTitle, EventUserData.class);
		
	}
	
	protected DatabaseReference newEntry(EventUserData entry)
	{
		return db.child(entry.name.replace(".", "-"));
	}
}
