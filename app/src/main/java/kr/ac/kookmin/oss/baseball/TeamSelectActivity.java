package kr.ac.kookmin.oss.baseball;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class TeamSelectActivity extends AppCompatActivity {

    ImageView team_bears;
    ImageView team_dinos;
    ImageView team_eagles;
    ImageView team_giants;
    ImageView team_heroes;
    ImageView team_lions;
    ImageView team_tigers;
    ImageView team_twins;
    ImageView team_wiz;
    ImageView team_wyvurns;

    static ArrayList<LinkedHashMap<String, String>> compareTeamList;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_select);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("비교 할 팀을 선택하세요");

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        compareTeamList = new ArrayList<LinkedHashMap<String, String>>();

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        team_bears = (ImageView) findViewById(R.id.team_bears);
        addClickListener(team_bears, "두산");

        team_dinos = (ImageView) findViewById(R.id.team_dinos);
        addClickListener(team_dinos, "NC");

        team_eagles = (ImageView) findViewById(R.id.team_eagles);
        addClickListener(team_eagles, "한화");

        team_giants = (ImageView) findViewById(R.id.team_giants);
        addClickListener(team_giants, "롯데");

        team_heroes = (ImageView) findViewById(R.id.team_heroes);
        addClickListener(team_heroes, "넥센");

        team_lions = (ImageView) findViewById(R.id.team_lions);
        addClickListener(team_lions, "삼성");

        team_tigers = (ImageView) findViewById(R.id.team_tigers);
        addClickListener(team_tigers, "KIA");

        team_twins = (ImageView) findViewById(R.id.team_twins);
        addClickListener(team_twins, "LG");

        team_wiz = (ImageView) findViewById(R.id.team_wiz);
        addClickListener(team_wiz, "kt");

        team_wyvurns = (ImageView) findViewById(R.id.team_wyvurns);
        addClickListener(team_wyvurns, "SK");

    }

    public LinkedHashMap<String, String> searchBatter(String name) {
        ArrayList<LinkedHashMap<String, String>> data = MainActivity.statData.BatterList;
        int len = data.size();
        for (int i = 0; i < len; i++) {
            if (data.get(i).get("NAME").equals(name)) {
                return data.get(i);
            }
        }
        return null;
    }

    public LinkedHashMap<String, String> searchPitcher(String name) {
        ArrayList<LinkedHashMap<String, String>> data = MainActivity.statData.PitcherList;
        int len = data.size();
        for (int i = 0; i < len; i++) {
            if (data.get(i).get("NAME").equals(name)) {
                return data.get(i);
            }
        }
        return null;
    }

    public LinkedHashMap<String, String> searchTeam(String team) {
        ArrayList<LinkedHashMap<String, String>> data = MainActivity.statData.TeamList;
        int len = data.size();
        for (int i = 0; i < len; i++) {
            if (data.get(i).get("TEAM").equals(team)) {
                return data.get(i);
            }
        }
        return null;
    }

    public void addClickListener(final ImageView iv, final String teamName) {
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (iv.isSelected()) {
                    iv.setSelected(false);
                    compareTeamList.clear();
                } else {
                    iv.setSelected(true);
                    compareTeamList.add(searchTeam(teamName));
                    if (compareTeamList.size() == 2) {
                        Intent i = new Intent(getApplicationContext(), CompareResult.class);
                        startActivity(i);
                        finish();
                    }
                }
            }
        });
    }

}