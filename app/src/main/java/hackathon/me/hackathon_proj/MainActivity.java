package hackathon.me.hackathon_proj;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**Button setup for participant screen**/
        Button participantScreen = findViewById(R.id.to_participant);
        participantScreen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, ParticipantPage.class);
                MainActivity.this.startActivity(myIntent);
            }
        });

        /**Button setup for Volunteer screen**/
        Button volunteerScreen = findViewById(R.id.to_volunteer);
        volunteerScreen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, VolunteerPage.class);
                MainActivity.this.startActivity(myIntent);
            }
        });

        /**Button setup for participant screen**/
        Button organizerScreen = findViewById(R.id.to_organizer);
        organizerScreen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, OrganizerPage.class);
                MainActivity.this.startActivity(myIntent);
            }
        });

    }
}
