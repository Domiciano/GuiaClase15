package co.domi.guiaclase15;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class DashboardActivity extends AppCompatActivity {

    private Button signoutBtn;
    private Button newRegBtn;
    private ListView registersList;
    private User myuser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        signoutBtn = findViewById(R.id.signupBtn);
        signoutBtn.setOnClickListener(this::signout);

        newRegBtn = findViewById(R.id.newRegBtn);
        newRegBtn.setOnClickListener(this::goToNewReg);

        registersList = findViewById(R.id.registersList);


        resolveMyUser();
    }

    private void goToNewReg(View view) {
        Intent i = new Intent(this, NewRegisterActivity.class);
        startActivity(i);
    }

    private void resolveMyUser() {
        String id = FirebaseAuth.getInstance().getUid();
        FirebaseFirestore.getInstance().collection("clase15users").document(id).get().addOnCompleteListener(
                task -> {
                    myuser = task.getResult().toObject(User.class);
                    Toast.makeText(this, "Hola "+myuser.getNombre(), Toast.LENGTH_LONG).show();
                }
        );
    }

    private void signout(View view) {
        FirebaseAuth.getInstance().signOut();
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
        finish();
    }
}