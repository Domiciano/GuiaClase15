package co.domi.guiaclase15;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class NewRegisterActivity extends AppCompatActivity {

    //Views
    private EditText patientNameET;
    private EditText patientIDET;
    private RadioGroup ulcerGroup;
    private RadioGroup groupingGroup;
    private RadioGroup locationGroup;
    private RadioGroup sightingGroup;
    private Button regBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_register);

        patientNameET = findViewById(R.id.patientIDET);
        patientIDET = findViewById(R.id.patientIDET);
        ulcerGroup = findViewById(R.id.ulcerGroup);
        groupingGroup = findViewById(R.id.groupingGroup);
        locationGroup = findViewById(R.id.locationGroup);
        sightingGroup = findViewById(R.id.sightingGroup);
        regBtn = findViewById(R.id.regBtn);
    }
}