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

public class PitcherSearchActivity extends AppCompatActivity {

    static ArrayList<LinkedHashMap<String, String>> data2;
    private EditText editText;
    private Button searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pitcher_search_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Pitcher Search");
        setSupportActionBar(toolbar);

        editText = (EditText) findViewById(R.id.search_text);
        searchButton = (Button) findViewById(R.id.search_button);

        data2 = new ArrayList<LinkedHashMap<String, String>>();

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data2.clear();
                data2.add(searchPitcher(editText.getText().toString()));
                Intent i = new Intent(getApplicationContext(), PitcherSearchResult.class);
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

