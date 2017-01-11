package raphaelsantos.ramo_ieee_cefet_rj.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import raphaelsantos.ramo_ieee_cefet_rj.R;

/**
 * Created by raphaelsantos on 10/30/16.
 */

public class HistoryActivity extends AppCompatActivity {

    private Button applyingfor;

    private TextView histBody1;
    private TextView histBody2;
    private TextView histBody3;
    private TextView histBody4;
    private TextView histBody5;

    private String body1;
    private String body2;
    private String body3;
    private String body4;
    private String body5;
    DatabaseReference histRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        /** DECLARING TEXTVIEWS FOR BODY TEXTS **/
        histBody1 = (TextView) findViewById(R.id.histBody1);
        histBody2 = (TextView) findViewById(R.id.histBody2);
        histBody3 = (TextView) findViewById(R.id.histBody3);
        histBody4 = (TextView) findViewById(R.id.histBody4);
        histBody5 = (TextView) findViewById(R.id.histBody5);

        /** DECLARING BUTTONS **/
        applyingfor = (Button) findViewById(R.id.applyingfor);


        /** FIREBASE IMPLEMENTATION **/

        histRef = FirebaseDatabase.getInstance().getReference().child("Ramo").child("History");

        histRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                body1=dataSnapshot.child("Content").getValue(String.class);
                body2=dataSnapshot.child("Content_v2").getValue(String.class);
                body3=dataSnapshot.child("Leader").getValue(String.class);
                body4=dataSnapshot.child("Participant").getValue(String.class);
                body5=dataSnapshot.child("Sponsor").getValue(String.class);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        histBody1.setText(body1);
        histBody2.setText(body2);
        histBody3.setText(body3);
        histBody4.setText(body4);
        histBody5.setText(body5);
    }
}