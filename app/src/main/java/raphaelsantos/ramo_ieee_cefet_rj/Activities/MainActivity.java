package raphaelsantos.ramo_ieee_cefet_rj.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;

import raphaelsantos.ramo_ieee_cefet_rj.Entities.Project;
import raphaelsantos.ramo_ieee_cefet_rj.R;

public class MainActivity extends AppCompatActivity {

    private Button exclusive;
    private Button history;
    private Button ieee;
    private Button projects;
    private Button study_with_branch;
    private Button quiz_game;
    private String TAG = new String();
    Project Competition_coders = new Project();

    public  Bundle datafromdatabase_coders;
    long counting = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        exclusive = (Button) findViewById(R.id.gotoareaofmembers);
        history = (Button) findViewById(R.id.gotocheckhistory);
        ieee = (Button) findViewById(R.id.gotoIEEE);
        projects = (Button) findViewById(R.id.gotocheckprojects);
        study_with_branch = (Button) findViewById(R.id.gototests);
        quiz_game = (Button) findViewById(R.id.gotoquizgame);


        isOnline();

        if (isOnline() == true){
            Log.w(TAG, "CONECTADOOOOOOOO!!!!!!!!!!!!!");
        }


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Ramo");

        DatabaseReference acesso_coder = myRef.child("Projects").child("Coders").child("Competition");

        acesso_coder.addChildEventListener(new ChildEventListener(){

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s){

                counting = dataSnapshot.getChildrenCount();

            }

            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                counting = dataSnapshot.getChildrenCount();
            }
            public void onChildRemoved(DataSnapshot dataSnapshot) {
            }
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            }

            public void onCancelled(DatabaseError databaseError) {

            }
        });



        acesso_coder.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

//                Competition_coders.setTitle(dataSnapshot.getValue(String.class));
//                Log.d(TAG, "Valoooooooooooooooor é" + Competition_coders.getTitle());

//                datafromdatabase_coders.putString("title_coders_competition",Competition_coders.getTitle());
//                datafromdatabase_coders.putString("content_coders_competition", dataSnapshot.child("Content").getValue(String.class));
//                datafromdatabase_coders.putString("leader_coders_competition", dataSnapshot.child("Leader").getValue(String.class));
//                datafromdatabase_coders.putString("participant_coders_competition", dataSnapshot.child("Participant").getValue(String.class));
//
//                datafromdatabase_coders.putString("title_coders_mobile", dataSnapshot.child("Mobile").child("Title").getValue(String.class));
//                datafromdatabase_coders.putString("content_coders_mobile", dataSnapshot.child("Mobile").child("Content").getValue(String.class));
//                datafromdatabase_coders.putString("leader_coders_mobile", dataSnapshot.child("Mobile").child("Leader").getValue(String.class));
//                datafromdatabase_coders.putString("participant_coders_mobile", dataSnapshot.child("Mobile").child("Participant").getValue(String.class));
//
//                datafromdatabase_coders.putString("title_coders_games", dataSnapshot.child("Games").child("Title").getValue(String.class));
//                datafromdatabase_coders.putString("content_coders_games", dataSnapshot.child("Games").child("Content").getValue(String.class));
//                datafromdatabase_coders.putString("leader_coders_games", dataSnapshot.child("Games").child("Leader").getValue(String.class));
//                datafromdatabase_coders.putString("participant_coders_games", dataSnapshot.child("Games").child("Participant").getValue(String.class));

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



        exclusive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Go to excluvive area
            }
        });


        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Go to IEEE history

                Intent go_to_history = new Intent(MainActivity.this, HistoryActivity.class);
                startActivity(go_to_history);

            }
        });


        ieee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Go to IEEE zone
            }
        });


        projects.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Go to projects zone
                Intent go_to_projects = new Intent(MainActivity.this, ProjectsActivity.class);
                startActivity(go_to_projects);
                go_to_projects.putExtra("passing_Bundle",datafromdatabase_coders);
            }
        });

        study_with_branch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Go to lists and tests zone
            }
        });

        quiz_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Go to quiz game
            }
        });



    }

    public boolean isOnline() {

        Runtime runtime = Runtime.getRuntime();
        try {

            Process ipProcess = runtime.exec("/system/bin/ping -c 1 8.8.8.8");
            int     exitValue = ipProcess.waitFor();
            return (exitValue == 0);

        } catch (IOException e)          { e.printStackTrace(); }
        catch (InterruptedException e) { e.printStackTrace(); }

        return false;
    }

}

