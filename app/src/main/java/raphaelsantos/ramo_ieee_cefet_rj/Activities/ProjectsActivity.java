package raphaelsantos.ramo_ieee_cefet_rj.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import raphaelsantos.ramo_ieee_cefet_rj.Entities.Project;
import raphaelsantos.ramo_ieee_cefet_rj.R;

/**
 * Created by raphaelsantos on 11/15/16.
 */


public class ProjectsActivity  extends AppCompatActivity{

    Project autonomous_robot = new Project();
    Project sumo_robot = new Project();
    Project linefollower_robot = new Project();
    Project solar = new Project();
    Project school = new Project();
    Project mobile_coder = new Project();
    Project competition_coder = new Project();
    Project game_coder = new Project();
    String value = new String();
    private String TAG = new String();
    private Button applyingforbutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects);


        applyingforbutton = (Button) findViewById(R.id.applyingfor);

        // all access to database should be carried in asynctask to avoid overloading mainthread - to be implemented
        // Accessing Database - read firebase documentation for better understanding
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Ramo");
        DatabaseReference acesso_competition_coder = myRef.child("Projects").child("Coders").child("Competition");
        DatabaseReference acesso_mobile_coder = myRef.child("Projects").child("Coders").child("Mobile");
        DatabaseReference acesso_games_coder = myRef.child("Projects").child("Coders").child("Games");

        acesso_games_coder.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                game_coder.setTitle(dataSnapshot.child("Title").getValue(String.class));
                game_coder.setContent(dataSnapshot.child("Content").getValue(String.class));
                game_coder.setTeam_members(dataSnapshot.child("Participant").getValue(String.class));
                game_coder.setLeaders(dataSnapshot.child("Leader").getValue(String.class));
                game_coder.setSponsors(dataSnapshot.child("Sponsor").getValue(String.class));

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        acesso_mobile_coder.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                mobile_coder.setTitle(dataSnapshot.child("Title").getValue(String.class));
                mobile_coder.setContent(dataSnapshot.child("Content").getValue(String.class));
                mobile_coder.setTeam_members(dataSnapshot.child("Participant").getValue(String.class));
                mobile_coder.setLeaders(dataSnapshot.child("Leader").getValue(String.class));
                mobile_coder.setSponsors(dataSnapshot.child("Sponsor").getValue(String.class));

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        // Read from the database - testing with single value
        acesso_competition_coder.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                competition_coder.setTitle(dataSnapshot.child("Title").getValue(String.class));
                competition_coder.setContent(dataSnapshot.child("Content").getValue(String.class));
                competition_coder.setTeam_members(dataSnapshot.child("Participant").getValue(String.class));
                competition_coder.setLeaders(dataSnapshot.child("Leader").getValue(String.class));
                competition_coder.setSponsors(dataSnapshot.child("Sponsor").getValue(String.class));


                Log.d(TAG, "Value is: " + competition_coder.getTitle());
                Log.d(TAG, "Value is: " + competition_coder.getContent());
                Log.d(TAG, "Value is: " + competition_coder.getLeaders());
                Log.d(TAG, "Value is: " + competition_coder.getTeam_members());
                Log.d(TAG, "Value is: " + competition_coder.getSponsors());
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


    }

}
