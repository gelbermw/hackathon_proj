package hackathon.me.hackathon_proj.database.data;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public abstract class DatabaseData
{
	@Exclude
	public String key;
}
