package kr.ac.kookmin.oss.baseball;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;
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
    private TextView textView;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_search_result);
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

        textView = (TextView) findViewById(R.id.stat_text);


        LinkedHashMap<String, String> data = TeamSearchActivity.data3.get(0);
        String temp = "";

        Iterator<String> iterator = data.keySet().iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            temp = temp + " " + key + " " + data.get(key) + System.getProperty("line.separator");
        }

        textView.setText(temp);

        team_bears = (ImageView) findViewById(R.id.team_bears);
        team_bears.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (team_bears.isSelected()) {
                    team_bears.setSelected(false);
                    compareTeamList.clear();
                } else {
                    team_bears.setSelected(true);
                    compareTeamList.add(searchTeam("두산"));
                    if (compareTeamList.size() == 2) {
                        Intent i = new Intent(getApplicationContext(), CompareResult.class);
                        startActivity(i);
                        finish();
                    }
                }
            }
        });

        team_dinos = (ImageView) findViewById(R.id.team_dinos);
        team_dinos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (team_dinos.isSelected()) {
                    team_dinos.setSelected(false);
                    compareTeamList.clear();
                } else {
                    team_dinos.setSelected(true);
                    compareTeamList.add(searchTeam("NC"));
                    if (compareTeamList.size() == 2) {
                        Intent i = new Intent(getApplicationContext(), CompareResult.class);
                        i.putExtra("CompareTeam", compareTeamList);
                        startActivity(i);
                        finish();
                    }
                }
            }
        });

        team_eagles = (ImageView) findViewById(R.id.team_eagles);
        team_eagles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (team_eagles.isSelected()) {
                    team_eagles.setSelected(false);
                    compareTeamList.clear();
                } else {
                    team_eagles.setSelected(true);
                    compareTeamList.add(searchTeam("한화"));
                    if (compareTeamList.size() == 2) {
                        Intent i = new Intent(getApplicationContext(), CompareResult.class);
                        i.putExtra("CompareTeam", compareTeamList);
                        startActivity(i);
                        finish();
                    }
                }
            }
        });

        team_giants = (ImageView) findViewById(R.id.team_giants);
        team_giants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (team_giants.isSelected()) {
                    team_giants.setSelected(false);
                    compareTeamList.clear();
                } else {
                    team_giants.setSelected(true);
                    compareTeamList.add(searchTeam("롯데"));
                    if (compareTeamList.size() == 2) {
                        Intent i = new Intent(getApplicationContext(), CompareResult.class);
                        i.putExtra("CompareTeam", compareTeamList);
                        startActivity(i);
                        finish();
                    }
                }
            }
        });

        team_heroes = (ImageView) findViewById(R.id.team_heroes);
        team_heroes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (team_heroes.isSelected()) {
                    team_heroes.setSelected(false);
                    compareTeamList.clear();
                } else {
                    team_heroes.setSelected(true);
                    compareTeamList.add(searchTeam("넥센"));
                    if (compareTeamList.size() == 2) {
                        Intent i = new Intent(getApplicationContext(), CompareResult.class);
                        i.putExtra("CompareTeam", compareTeamList);
                        startActivity(i);
                        finish();
                    }
                }
            }
        });

        team_lions = (ImageView) findViewById(R.id.team_lions);
        team_lions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (team_lions.isSelected()) {
                    team_lions.setSelected(false);
                    compareTeamList.clear();
                } else {
                    team_lions.setSelected(true);
                    compareTeamList.add(searchTeam("삼성"));
                    if (compareTeamList.size() == 2) {
                        Intent i = new Intent(getApplicationContext(), CompareResult.class);
                        i.putExtra("CompareTeam", compareTeamList);
                        startActivity(i);
                        finish();
                    }
                }
            }
        });

        team_tigers = (ImageView) findViewById(R.id.team_tigers);
        team_tigers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (team_tigers.isSelected()) {
                    team_tigers.setSelected(false);
                    compareTeamList.clear();
                } else {
                    team_tigers.setSelected(true);
                    compareTeamList.add(searchTeam("KIA"));
                    if (compareTeamList.size() == 2) {
                        Intent i = new Intent(getApplicationContext(), CompareResult.class);
                        i.putExtra("CompareTeam", compareTeamList);
                        startActivity(i);
                        finish();
                    }
                }
            }
        });

        team_twins = (ImageView) findViewById(R.id.team_twins);
        team_twins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (team_twins.isSelected()) {
                    team_twins.setSelected(false);
                    compareTeamList.clear();
                } else {
                    team_twins.setSelected(true);
                    compareTeamList.add(searchTeam("LG"));
                    if (compareTeamList.size() == 2) {
                        Intent i = new Intent(getApplicationContext(), CompareResult.class);
                        i.putExtra("CompareTeam", compareTeamList);
                        startActivity(i);
                        finish();
                    }
                }
            }
        });

        team_wiz = (ImageView) findViewById(R.id.team_wiz);
        team_wiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (team_wiz.isSelected()) {
                    team_wiz.setSelected(false);
                    compareTeamList.clear();
                } else {
                    team_wiz.setSelected(true);
                    compareTeamList.add(searchTeam("kt"));
                    if (compareTeamList.size() == 2) {
                        Intent i = new Intent(getApplicationContext(), CompareResult.class);
                        i.putExtra("CompareTeam", compareTeamList);
                        startActivity(i);
                        finish();
                    }
                }
            }
        });

        team_wyvurns = (ImageView) findViewById(R.id.team_wyvurns);
        team_wyvurns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (team_wyvurns.isSelected()) {
                    team_wyvurns.setSelected(false);
                    compareTeamList.clear();
                } else {
                    team_wyvurns.setSelected(true);
                    compareTeamList.add(searchTeam("SK"));
                    if (compareTeamList.size() == 2) {
                        Intent i = new Intent(getApplicationContext(), CompareResult.class);
                        i.putExtra("CompareTeam", compareTeamList);
                        startActivity(i);
                        finish();
                    }
                }
            }
        });

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

}