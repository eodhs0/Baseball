package kr.ac.kookmin.oss.baseball;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class PitcherSearchResult extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pitcher_search_result);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Pitcher Search Result");
        setSupportActionBar(toolbar);

        textView = (TextView) findViewById(R.id.stat_text);


        LinkedHashMap<String, String> data = PitcherSearchActivity.data2.get(0);
        String temp = "";

        Iterator<String> iterator = data.keySet().iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            temp = temp + " " + key + " " + data.get(key) + System.getProperty("line.separator");
        }

        textView.setText(temp);

    }

}
