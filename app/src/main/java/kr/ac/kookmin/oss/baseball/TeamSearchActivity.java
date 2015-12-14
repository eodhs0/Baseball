package kr.ac.kookmin.oss.baseball;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class TeamSearchActivity extends AppCompatActivity {

    static ArrayList<LinkedHashMap<String, String>> data3;
    private EditText editText;
    private Button searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_search_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("검색하고 싶은 팀을 입력하세요");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        editText = (EditText) findViewById(R.id.search_text);
        searchButton = (Button) findViewById(R.id.search_button);

        data3 = new ArrayList<LinkedHashMap<String, String>>();

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data3.clear();
                data3.add(searchTeam(editText.getText().toString()));
                Intent i = new Intent(getApplicationContext(), TeamSearchResult.class);
                startActivity(i);
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

