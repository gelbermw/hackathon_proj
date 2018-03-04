package hackathon.me.hackathon_proj;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import hackathon.me.hackathon_proj.database.data.EventData;

public class SearchResultsV extends AppCompatActivity
{
	
	List<String> list = new ArrayList<>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search_results_v);
		String[] fromColumns = {ContactsContract.Data.DISPLAY_NAME};
		int[] toViews = {android.R.id.text1}; // The TextView in simple_list_item_1
		ListView listView = (ListView) findViewById(R.id.srlist);
		ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
		
		listView.setAdapter(adapter);
		Log.d("Fuck", "Page Loaded bitch");
		
		DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("events");
		ref.addChildEventListener(new ChildEventListener()
		{
			@Override public void onChildAdded(DataSnapshot dataSnapshot, String s)
			{
				Log.d("RESULTS", "Item Removed From List!");
				list.add(dataSnapshot.getValue(EventData.class).title);
				adapter.notifyDataSetChanged();
			}
			
			@Override public void onChildChanged(DataSnapshot dataSnapshot, String s)
			{
			
			}
			
			@Override public void onChildRemoved(DataSnapshot dataSnapshot)
			{
				Log.d("RESULTS", "Item Removed From List!");
			}
			
			@Override public void onChildMoved(DataSnapshot dataSnapshot, String s)
			{
			
			}
			
			@Override public void onCancelled(DatabaseError databaseError)
			{
			
			}
		});
	}
}
