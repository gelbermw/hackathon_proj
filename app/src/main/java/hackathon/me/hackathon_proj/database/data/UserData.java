package hackathon.me.hackathon_proj.database.data;


import android.annotation.SuppressLint;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;


public class UserData extends DatabaseData
{
	
	public String name;
	public String email;
	public int age;
	public boolean verified;
	public String occupation;
	public String password;
	
	public String getPassword()
	{
		return password;
	}
	
	public UserData()
	{
	
	}
	
	public UserData(String name, String email, String password, int age, boolean verified, String occupation)
	{
		this.name = name;
		this.email = email;
		this.age = age;
		this.verified = verified;
		this.occupation = occupation;
		this.password = password;
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
