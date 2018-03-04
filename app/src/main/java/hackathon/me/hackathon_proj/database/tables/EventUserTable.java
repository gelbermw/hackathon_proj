package hackathon.me.hackathon_proj.database.tables;

import hackathon.me.hackathon_proj.database.data.EventData;
import hackathon.me.hackathon_proj.database.data.EventUserData;

public class EventUserTable extends DatabaseTable<EventUserData>
{
	public EventUserTable(EventData eventData)
	{
		super("event_users/" + eventData.key, EventUserData.class);
	}
}
