package hackathon.me.hackathon_proj.database.data;


import android.annotation.SuppressLint;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class UserData
{
	@Exclude
	public String key;
	
	public String name;
	public String email;
	public int age;
	public boolean verified;
	public String occupation;
	
	
	public UserData()
	{
	
	}
	
	public UserData(String name, String email, int age, boolean verified, String occupation)
	{
		this.name = name;
		this.email = email;
		this.age = age;
		this.verified = verified;
		this.occupation = occupation;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public boolean isVerified()
	{
		return verified;
	}
	
	public String getOccupation()
	{
		return occupation;
	}
	
	@SuppressLint("DefaultLocale")
	public String toString()
	{
		return String.format("User[%s, %s, %d, %b, %s]", name, email, age, verified, occupation);
	}
}
