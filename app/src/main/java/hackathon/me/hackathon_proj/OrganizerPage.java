package hackathon.me.hackathon_proj;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

import hackathon.me.hackathon_proj.database.data.EventData;
import hackathon.me.hackathon_proj.database.tables.EventsTable;

public class OrganizerPage extends AppCompatActivity {
    private Spinner EventCatSpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organizer_page);

        addCatSpinnerItems();
        addListenerOnSpinnerItemSelection();

        /**Submit Button for Organizer**/
        Button participantScreen = findViewById(R.id.submitBtn);
        participantScreen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(OrganizerPage.this, OrganizerPage.class);
                OrganizerPage.this.startActivity(myIntent);


                TextView text = (TextView) findViewById(R.id.eventName);
                String name = text.getText().toString();
                text = findViewById(R.id.eventOrginization);
                String organization = text.getText().toString();
                text = findViewById(R.id.eventDate);
                String date = text.getText().toString();
                text = findViewById(R.id.eventLocation);
                String location = text.getText().toString();
                Spinner cat = findViewById(R.id.EventCatSpinner);
                String category = cat.getSelectedItem().toString();
                text = findViewById(R.id.eventDescription);
                String description = text.getText().toString();

                EventsTable eventsTable = new EventsTable();
                eventsTable.addEntry(new EventData(name,organization,date,location,category,description));
            }
        });

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