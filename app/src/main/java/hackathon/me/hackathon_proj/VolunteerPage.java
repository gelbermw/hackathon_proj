package hackathon.me.hackathon_proj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class VolunteerPage extends AppCompatActivity {

    Button submitButton;
    CheckBox box1;
    CheckBox box2;
    CheckBox box3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer_page);
        submitButton = findViewById(R.id.volunteerSearch);
        View v = submitButton;

        box1 = findViewById(R.id.checkBox1);
        box2 = findViewById(R.id.checkBox2);
        box3 = findViewById(R.id.checkBox3);

    }

    public void onSubmit(View v) {
        boolean box1Selected = box1.isChecked();
        boolean box2Selected = box2.isChecked();
        boolean box3Selected = box3.isChecked();

    }

}
