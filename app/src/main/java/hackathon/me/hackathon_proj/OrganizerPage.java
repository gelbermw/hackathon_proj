package hackathon.me.hackathon_proj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

public class OrganizerPage extends AppCompatActivity {
    private Spinner EventCatSpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organizer_page);

        addCatSpinnerItems();
        addListenerOnSpinnerItemSelection();

    }

    //adding items to spinner dynamically
    public void addCatSpinnerItems() {
        EventCatSpinner = (Spinner) findViewById(R.id.EventCatSpinner);
        //EventCatSpinner.setOnItemSelectedListener(this);
        List<String> catList = new ArrayList<String>();
        EventCatSpinner.setPrompt("Event Category");
        catList.isEmpty();
        catList.add("Select Category");
        catList.add("Maker/Hacker Space");
        catList.add("Hackathon");
        catList.add("Robotics");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, catList);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        EventCatSpinner.setAdapter(dataAdapter);
    }

    public void addListenerOnSpinnerItemSelection() {
        EventCatSpinner = (Spinner) findViewById(R.id.EventCatSpinner);
        EventCatSpinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }

}

class CustomOnItemSelectedListener implements AdapterView.OnItemSelectedListener {

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        Toast.makeText(parent.getContext(),
                "OnItemSelectedListener : " + parent.getItemAtPosition(pos).toString(),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub


    }

}