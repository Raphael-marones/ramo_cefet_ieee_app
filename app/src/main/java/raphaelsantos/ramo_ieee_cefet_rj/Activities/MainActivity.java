package raphaelsantos.ramo_ieee_cefet_rj.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import raphaelsantos.ramo_ieee_cefet_rj.R;

public class MainActivity extends AppCompatActivity {

    private Button exclusive;
    private Button history;
    private Button ieee;
    private Button projects;
    private Button study_with_branch;
    private Button quiz_game;


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
}

