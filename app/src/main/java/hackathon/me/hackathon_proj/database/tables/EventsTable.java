package hackathon.me.hackathon_proj.database.tables;

import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hackathon.me.hackathon_proj.database.data.EventData;

public class EventsTable extends DatabaseTable<EventData>
{
	
	public EventsTable()
	{
		super("events", EventData.class);
	}
	
	
	protected DatabaseReference newEntry(EventData entry)
	{
		return db.child(entry.title);
	}
}
