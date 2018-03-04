package hackathon.me.hackathon_proj;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class ParticipantPage extends AppCompatActivity {

    Button submitButton;
    CheckBox box1;
    CheckBox box2;
    CheckBox box3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participant_page);


        box1 = findViewById(R.id.checkBox1);
        box2 = findViewById(R.id.checkBox2);
        box3 = findViewById(R.id.checkBox3);

        /**Button setup for search**/
        Button participantScreen = findViewById(R.id.participantSearch);
        participantScreen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(ParticipantPage.this, SearchResultsV.class);
                myIntent.putExtra("makerspace", box1.isChecked());
                myIntent.putExtra("hackathon", box2.isChecked());
                myIntent.putExtra("robotics", box3.isChecked());
                startActivity(myIntent);
            }
        });
    }

    public void onSubmit(View v) {
        boolean box1Selected = box1.isChecked();
        boolean box2Selected = box2.isChecked();
        boolean box3Selected = box3.isChecked();
    }



}