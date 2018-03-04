package hackathon.me.hackathon_proj;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import hackathon.me.hackathon_proj.database.data.EventData;

public class EventDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);
    
        TextView text = findViewById(R.id.viewName);
        text.append(getIntent().getStringExtra("title"));
        text = findViewById(R.id.viewCategory);
        text.append(getIntent().getStringExtra("category"));
        text = findViewById(R.id.viewLocation);
        text.append(getIntent().getStringExtra("location"));
        text = findViewById(R.id.viewOrganization);
        text.append(getIntent().getStringExtra("organization"));
        text = findViewById(R.id.viewDescription);
        text.append(getIntent().getStringExtra("description"));
        text = findViewById(R.id.eventDate);
        text.append(getIntent().getStringExtra("date"));
        
        /**Home button from event details**/
        Button participantScreen = findViewById(R.id.homeBtn);
        participantScreen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(EventDetails.this, MainActivity.class);
                EventDetails.this.startActivity(myIntent);
            }
        });
    
    }
}

