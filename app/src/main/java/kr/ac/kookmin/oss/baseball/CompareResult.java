package kr.ac.kookmin.oss.baseball;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class CompareResult extends AppCompatActivity {

    ArrayList<LinkedHashMap<String, String>> compareTeamList;
    TextView textView1;
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare_result);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.setTitle("비교결과");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        compareTeamList = new ArrayList<LinkedHashMap<String, String>>();

        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);

        compareTeamList = TeamSelectActivity.compareTeamList;
        LinkedHashMap<String, String> data = compareTeamList.get(0);
        String temp = "";

        Iterator<String> iterator = data.keySet().iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            temp = temp + " " + key + " " + data.get(key) + System.getProperty("line.separator");
        }
        textView1.setText(temp);


        temp = "";
        data = compareTeamList.get(1);
        iterator = data.keySet().iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            temp = temp + " " + key + " " + data.get(key) + System.getProperty("line.separator");
        }

        textView2.setText(temp);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        TeamSelectActivity.compareTeamList.clear();
    }

}
