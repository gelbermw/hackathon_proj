package hackathon.me.hackathon_proj;

import android.app.Activity;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
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
	
	List<EventData> list = new ArrayList<>();
	boolean hack, make, robo;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search_results_v);
		hack = getIntent().getBooleanExtra("hackathon", false);
		make = getIntent().getBooleanExtra("makerspace", false);
		robo = getIntent().getBooleanExtra("robotics", false);
		
		
		ListView listView = (ListView) findViewById(R.id.srlist);
		ArrayAdapter adapter = new ArrayAdapter<EventData>(this, android.R.layout.simple_list_item_1, list);
		
		listView.setAdapter(adapter);
		
		DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("events");
		ref.addChildEventListener(new ChildEventListener()
		{
			@Override public void onChildAdded(DataSnapshot dataSnapshot, String s)
			{
				Log.d("RESULTS", "Item Added To List!");
				EventData edat = dataSnapshot.getValue(EventData.class);
				if (showItem(edat))
				{
					list.add(edat);
					adapter.notifyDataSetChanged();
				}
			}
			
			@Override public void onChildChanged(DataSnapshot dataSnapshot, String s)
			{
			
			}
			
			@Override public void onChildRemoved(DataSnapshot dataSnapshot)
			{
				Log.d("RESULTS", "Item Removed From List!");
				if (list.remove(dataSnapshot.getValue(EventData.class)))
				{
					adapter.notifyDataSetChanged();
				}
			}
			
			@Override public void onChildMoved(DataSnapshot dataSnapshot, String s)
			{
			
			}
			
			@Override public void onCancelled(DatabaseError databaseError)
			{
			
			}
		});
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
		{
			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
			{
				
				EventData item = (EventData) adapterView.getItemAtPosition(i);
				
				Intent intent = new Intent(SearchResultsV.this, EventDetails.class);
				//based on item add info to intent
				
				
				intent.putExtra("title", item.title);
				intent.putExtra("category", item.category);
				intent.putExtra("location", item.location);
				intent.putExtra("organization", item.organization);
				intent.putExtra("description", item.description);
				intent.putExtra("date", item.date);
				
				
				startActivity(intent);
			}
			
		});
	}
	
	private boolean showItem(EventData data)
	{
		return hack && data.category.equalsIgnoreCase("hackathon") ||
		       make && data.category.equalsIgnoreCase("maker/hacker space") ||
		       robo && data.category.equalsIgnoreCase("robotics");
	}
	
	public EventData getItem(int position)
	{
		return list.get(position);
	}
}
