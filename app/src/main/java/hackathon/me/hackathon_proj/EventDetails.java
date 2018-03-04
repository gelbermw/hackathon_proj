package hackathon.me.hackathon_proj;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import hackathon.me.hackathon_proj.database.data.EventData;

public class EventDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        /**Home button from event details**/
        Button participantScreen = findViewById(R.id.to_participant);
        participantScreen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(EventDetails.this, MainActivity.class);
                EventDetails.this.startActivity(myIntent);
            }
        });
    }
}

