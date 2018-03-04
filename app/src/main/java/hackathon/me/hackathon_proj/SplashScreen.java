package hackathon.me.hackathon_proj;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        /**Button setup for participant screen**/
        Button participantScreen = findViewById(R.id.Enter);
        participantScreen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(SplashScreen.this, MainActivity.class);
                SplashScreen.this.startActivity(myIntent);
            }
        });
    }
}
