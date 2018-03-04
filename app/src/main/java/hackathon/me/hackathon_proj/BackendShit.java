package hackathon.me.hackathon_proj;

import android.os.Handler;
import android.util.Log;

import com.google.firebase.database.FirebaseDatabase;

import hackathon.me.hackathon_proj.database.DatabaseManager;
import hackathon.me.hackathon_proj.database.data.UserData;
import hackathon.me.hackathon_proj.database.tables.EventsTable;
import hackathon.me.hackathon_proj.database.tables.UserTable;

public class BackendShit
{
	public BackendShit()
	{
		FirebaseDatabase.getInstance().getApp().setAutomaticResourceManagementEnabled(false);
		DatabaseManager db = new DatabaseManager();
		//db.registerEvent();
		
		db.loadUserData();
		db.loadEventData();
		Handler handler = new Handler();
		
		handler.postDelayed(() ->
		                    {
			                    Log.d("USERS", db.getAllUsers().toString());
			                    Log.d("EVENTS", db.getAllEvents().toString());


		                    }, 3000);
		
		
	}
}
