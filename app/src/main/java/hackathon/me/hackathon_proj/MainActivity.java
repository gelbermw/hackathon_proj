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

        Button participantScreen = (Button) findViewById(R.id.to_participant);

        participantScreen.setOnClickListener(new View.OnClickListener() {           //Sets an onClickListener to make button click for intent
            public void onClick(View view) {

                Intent myIntent = new Intent(MainActivity.this, ParticipantPage.class);
                MainActivity.this.startActivity(myIntent);
            }
        });
    }

}
