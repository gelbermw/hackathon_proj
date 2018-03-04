package hackathon.me.hackathon_proj.database.tables;

import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

import hackathon.me.hackathon_proj.database.data.DatabaseData;

public class DatabaseTable<T extends DatabaseData> implements ChildEventListener
{
	
	protected DatabaseReference db;
	
	
	protected Map<String, T> data;
	protected String table;
	
	public DatabaseTable(String table)
	{
		this.table = table;
		data = new HashMap<>();
		
		db = FirebaseDatabase.getInstance().getReference().child(table);
		db.addChildEventListener(this);
		
	}
	
	public Map<String, T> getData()
	{
		return data;
	}
	
	public void addEntry(T entry)
	{
		db.push().setValue(entry);
	}
	
	public void updateEntry(T entry)
	{
		db.child(entry.key).setValue(entry);
	}
	
	@Override
	public void onChildAdded(DataSnapshot dataSnapshot, String s)
	{
		DatabaseData child = (DatabaseData) dataSnapshot.getValue();
		child.key = dataSnapshot.getKey();
		data.put(child.key, (T) child);
		
	}
	
	@Override
	public void onChildChanged(DataSnapshot dataSnapshot, String s)
	{
		DatabaseData child = (DatabaseData) dataSnapshot.getValue();
		child.key = dataSnapshot.getKey();
		data.put(child.key, (T) child);
	}
	
	@Override
	public void onChildRemoved(DataSnapshot dataSnapshot)
	{
		data.remove(dataSnapshot.getKey());
	}
	
	@Override
	public void onChildMoved(DataSnapshot dataSnapshot, String s)
	{
	
	}
	
	@Override
	public void onCancelled(DatabaseError databaseError)
	{
		Log.w("DatabaseTable", databaseError.toException());
	}
}
