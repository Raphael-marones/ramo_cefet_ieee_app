package raphaelsantos.ramo_ieee_cefet_rj.Activities;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Timer;
import java.util.TimerTask;

import raphaelsantos.ramo_ieee_cefet_rj.Entities.Project;
import raphaelsantos.ramo_ieee_cefet_rj.R;

/**
 * Created by raphaelsantos on 11/15/16.
 */


public class ProjectsActivity  extends AppCompatActivity{

    Project trekking_robot = new Project();
    Project sumo_robot = new Project();
    Project linefollower_robot = new Project();
    Project solar = new Project();
    Project school = new Project();
    Project mobile_coder = new Project();
    Project competition_coder = new Project();
    Project game_coder = new Project();
    Project rocket = new Project();
    String value = new String();
    private String TAG = new String();
    private Button applyingforbutton;


    private TextView mobile_title;
    private TextView mobile_members;
    private TextView mobile_leaader;

    private TextView game_title;
    private TextView game_members;
    private TextView game_leader;

    private TextView solar_title;
    private TextView solar_members;
    private TextView solar_leader;

    private TextView schoolieee_title;
    private TextView schoolieee_members;
    private TextView schoolieee_leader;

    private TextView sumo_title;
    private TextView sumo_members;
    private TextView sumo_leader;

    private TextView trekking_title;
    private TextView trekking_members;
    private TextView trekking_leader;

    private TextView competition_title;
    private TextView competition_members;
    private TextView competition_content;

    private TextView linefollower_title;
    private TextView linefollower_members;
    private TextView linefollower_leader;
    long counting = 0;
    private String titulo_teste = new String();
    public  Bundle datafromdatabase_coders;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects);

        competition_title = (TextView)findViewById(R.id.title_competition);
        competition_members = (TextView)findViewById(R.id.members_competition);
        competition_content = (TextView)findViewById(R.id.content_competition);
        mobile_members = (TextView) findViewById(R.id.members_mobile);
        applyingforbutton = (Button) findViewById(R.id.applyingfor);

//        Intent i = getIntent();
//        datafromdatabase_coders = i.getExtras().getBundle("passing_Bundle");


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Ramo");

        DatabaseReference acesso_rocket = myRef.child("Projects").child("Rocket");

        DatabaseReference acesso_school = myRef.child("Projects").child("Schoolers");

        DatabaseReference acesso_solar = myRef.child("Projects").child("Solar");

        DatabaseReference acesso_robot = myRef.child("Projects").child("Robot");

        DatabaseReference acesso_coder = myRef.child("Projects").child("Coders");

        acesso_rocket.addChildEventListener(new ChildEventListener() {
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


        acesso_rocket.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                rocket.setTitle(dataSnapshot.child("Rocketproject").child("Title").getValue(String.class));
                rocket.setContent(dataSnapshot.child("Rocketproject").child("Content").getValue(String.class));
                rocket.setTeam_members(dataSnapshot.child("Rocketproject").child("Participant").getValue(String.class));
                rocket.setLeaders(dataSnapshot.child("Rocketproject").child("Leader").getValue(String.class));
                rocket.setSponsors(dataSnapshot.child("Rocketproject").child("Sponsor").getValue(String.class));

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        acesso_school.addChildEventListener(new ChildEventListener() {
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

        acesso_school.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                school.setTitle(dataSnapshot.child("Title").getValue(String.class));
                school.setContent(dataSnapshot.child("Content").getValue(String.class));
                school.setTeam_members(dataSnapshot.child("Participant").getValue(String.class));
                school.setLeaders(dataSnapshot.child("Leader").getValue(String.class));
                school.setSponsors(dataSnapshot.child("Sponsor").getValue(String.class));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

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

        // Read from the database - testing with single value
        acesso_coder.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                competition_coder.setTitle(dataSnapshot.child("Competition").child("Title").getValue(String.class));
                competition_coder.setContent(dataSnapshot.child("Competition").child("Content").getValue(String.class));
                competition_coder.setTeam_members(dataSnapshot.child("Competition").child("Participant").getValue(String.class));
                competition_coder.setLeaders(dataSnapshot.child("Competition").child("Leader").getValue(String.class));
                competition_coder.setSponsors(dataSnapshot.child("Competition").child("Sponsor").getValue(String.class));

                game_coder.setTitle(dataSnapshot.child("Games").child("Title").getValue(String.class));
                game_coder.setContent(dataSnapshot.child("Games").child("Content").getValue(String.class));
                game_coder.setTeam_members(dataSnapshot.child("Games").child("Participant").getValue(String.class));
                game_coder.setLeaders(dataSnapshot.child("Games").child("Leader").getValue(String.class));
                game_coder.setSponsors(dataSnapshot.child("Games").child("Sponsor").getValue(String.class));

                mobile_coder.setTitle(dataSnapshot.child("Mobile").child("Title").getValue(String.class));
                mobile_coder.setContent(dataSnapshot.child("Mobile").child("Content").getValue(String.class));
                mobile_coder.setTeam_members(dataSnapshot.child("Mobile").child("Participant").getValue(String.class));
                mobile_coder.setLeaders(dataSnapshot.child("Mobile").child("Leader").getValue(String.class));
                mobile_coder.setSponsors(dataSnapshot.child("Mobile").child("Sponsor").getValue(String.class));

                titulo_teste = competition_coder.getTitle();
                Log.d(TAG, "onDataChange: " + titulo_teste);

//                datafromdatabase_coders.putString("Title",titulo_teste);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        acesso_robot.addChildEventListener(new ChildEventListener() {
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
        acesso_robot.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                trekking_robot.setTitle(dataSnapshot.child("Trekking").child("Title").getValue(String.class));
                trekking_robot.setContent(dataSnapshot.child("Trekking").child("Content").getValue(String.class));
                trekking_robot.setLeaders(dataSnapshot.child("Trekking").child("Leaders").getValue(String.class));
                trekking_robot.setTeam_members(dataSnapshot.child("Trekking").child("Participant").getValue(String.class));

                sumo_robot.setTitle(dataSnapshot.child("Sumo").child("Title").getValue(String.class));
                sumo_robot.setContent(dataSnapshot.child("Sumo").child("Content").getValue(String.class));
                sumo_robot.setLeaders(dataSnapshot.child("Sumo").child("Leaders").getValue(String.class));
                sumo_robot.setTeam_members(dataSnapshot.child("Sumo").child("Participant").getValue(String.class));

                linefollower_robot.setTitle(dataSnapshot.child("LineFollower").child("Title").getValue(String.class));
                linefollower_robot.setContent(dataSnapshot.child("LineFollower").child("Content").getValue(String.class));
                linefollower_robot.setLeaders(dataSnapshot.child("LineFollower").child("Leaders").getValue(String.class));
                linefollower_robot.setTeam_members(dataSnapshot.child("LineFollower").child("Participant").getValue(String.class));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        acesso_solar.addChildEventListener(new ChildEventListener() {
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

        acesso_solar.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                solar.setTitle(dataSnapshot.child("Solars").child("Title").getValue(String.class));
                solar.setContent(dataSnapshot.child("Solars").child("Content").getValue(String.class));
                solar.setLeaders(dataSnapshot.child("Solars").child("Leaders").getValue(String.class));
                solar.setTeam_members(dataSnapshot.child("Solars").child("Participant").getValue(String.class));
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Log.w(TAG, "Value is: " + competition_coder.getTitle());
                Log.w(TAG, "Value is: " + competition_coder.getContent());
                Log.w(TAG, "Value is: " + competition_coder.getLeaders());
                Log.w(TAG, "Value is: " + competition_coder.getTeam_members());
                Log.w(TAG, "Value is: " + competition_coder.getSponsors());


            }
        }, 1100);

        //This timer gives time for the Thread to be loaded with
        // the desired information from firebase

        new CountDownTimer(1500, 1000) {

            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                competition_title.setText(competition_coder.getTitle());
                competition_content.setText(competition_coder.getContent());
                competition_members.setText(competition_coder.getTeam_members());
            }
        }.start();


    }

}
