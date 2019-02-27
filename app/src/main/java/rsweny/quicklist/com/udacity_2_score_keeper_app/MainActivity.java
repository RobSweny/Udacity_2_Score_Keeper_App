package rsweny.quicklist.com.udacity_2_score_keeper_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Declaring views
    private Button team_a_goal;
    private Button team_a_yellow_card;
    private Button team_a_red_card;
    private Button team_a_corner;
    private Button team_b_goal;
    private Button team_b_yellow_card;
    private Button team_b_red_card;
    private Button team_b_corner;
    private Button reset_button;

    private TextView score_team_a_textview;
    private TextView current_players_team_a_textview;
    private TextView corner_kicks_team_a_textview;
    private TextView yellow_cards_team_a_textview;
    private TextView score_team_b_textview;
    private TextView current_players_team_b_textview;
    private TextView corner_kicks_team_b_textview;
    private TextView yellow_cards_team_b_textview;

     int team_a_players = 11;
     int team_b_players = 11;
     int team_a_score = 0;
     int team_b_score = 0;
     int team_a_yellow_cards = 0;
     int team_b_yellow_cards = 0;
     int team_a_corners = 0;
     int team_b_corners = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initializing team A buttons
        team_a_goal = findViewById(R.id.team_a_goal);
        team_a_yellow_card = findViewById(R.id.team_a_yellow_card);
        team_a_red_card = findViewById(R.id.team_a_red_card);
        team_a_corner = findViewById(R.id.team_a_corner);

        // Initializing team B buttons
        score_team_a_textview = findViewById(R.id.score_team_a_textview);
        current_players_team_a_textview = findViewById(R.id.current_players_team_a_textview);
        corner_kicks_team_a_textview = findViewById(R.id.corner_kicks_team_a_textview);
        yellow_cards_team_a_textview = findViewById(R.id.yellow_cards_team_a_textview);

        // Initializing team A textviews
        score_team_b_textview = findViewById(R.id.score_team_b_textview);
        current_players_team_b_textview = findViewById(R.id.current_players_team_b_textview);
        corner_kicks_team_b_textview = findViewById(R.id.corner_kicks_team_b_textview);
        yellow_cards_team_b_textview = findViewById(R.id.yellow_cards_team_b_textview);

        // Initializing team B textviews
        team_b_goal = findViewById(R.id.team_b_goal);
        team_b_yellow_card = findViewById(R.id.team_b_yellow_card);
        team_b_red_card = findViewById(R.id.team_b_red_card);
        team_b_corner = findViewById(R.id.team_b_corner);

        // Initializing reset button
        reset_button = findViewById(R.id.reset_button);

        // Setting scores
        set_scores();

        // TEAMS SCORING GOAL INCREMENTER
        team_a_goal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                team_a_score++;
                score_team_a_textview.setText((Integer.toString(team_a_score)));
            }
        });

        team_b_goal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                team_b_score++;
                score_team_b_textview.setText(Integer.toString(team_b_score));
            }
        });

        // TEAMS RED CARD INCREMENTER
        team_a_red_card.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(team_a_players < 8){
                    Toast.makeText(MainActivity.this, "Can't have less than 7 players! Game over! TEAM B WINS!", Toast.LENGTH_LONG).show();
                    reset_game();
                    set_scores();
                } else {
                    team_a_players--;
                    current_players_team_a_textview.setText(Integer.toString(team_a_players));
                }
            }
        });

        team_b_red_card.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(team_b_players < 8){
                    Toast.makeText(MainActivity.this, "Can't have less than 7 players! Game over! TEAM A WINS!", Toast.LENGTH_LONG).show();
                    reset_game();
                    set_scores();
                } else {
                    team_b_players--;
                    current_players_team_b_textview.setText(Integer.toString(team_b_players));
                }
            }
        });

        // TEAMS YELLOW CARD INCREMENTER
        team_a_yellow_card.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                team_a_yellow_cards++;
                yellow_cards_team_a_textview.setText(Integer.toString(team_a_yellow_cards));
            }
        });

        team_b_yellow_card.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                team_b_yellow_cards++;
                yellow_cards_team_b_textview.setText(Integer.toString(team_b_yellow_cards));
            }
        });

        // TEAMS YELLOW CARD INCREMENTER
        team_a_corner.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                team_a_corners++;
                corner_kicks_team_a_textview.setText(Integer.toString(team_a_corners));
            }
        });

        team_b_corner.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                team_b_corners++;
                corner_kicks_team_b_textview.setText(Integer.toString(team_b_corners));
            }
        });

        reset_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Check who won the game
                if(team_a_score == team_b_score){
                    Toast.makeText(MainActivity.this, "Game reset, the game was a draw", Toast.LENGTH_LONG).show();
                } else if (team_a_score > team_b_score){
                    Toast.makeText(MainActivity.this, "Game reset, Team A won!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "Game reset, Team B won!", Toast.LENGTH_LONG).show();
                }
                reset_game();
                set_scores();
            }
        });

    } // End onCreate

    public void reset_game(){
        team_a_score = 0;
        team_a_yellow_cards = 0;
        team_a_corners =0;
        team_a_players = 11;

        team_b_score = 0;
        team_b_yellow_cards = 0;
        team_b_corners =0;
        team_b_players = 11;
    }

    public void set_scores() {
        score_team_a_textview.setText(Integer.toString(team_a_score));
        score_team_b_textview.setText(Integer.toString(team_b_score));
        current_players_team_a_textview.setText(Integer.toString(team_a_players));
        current_players_team_b_textview.setText(Integer.toString(team_b_players));
        yellow_cards_team_a_textview.setText(Integer.toString(team_a_yellow_cards));
        yellow_cards_team_b_textview.setText(Integer.toString(team_b_yellow_cards));
        corner_kicks_team_a_textview.setText(Integer.toString(team_a_corners));
        corner_kicks_team_b_textview.setText(Integer.toString(team_b_corners));
    }


}
