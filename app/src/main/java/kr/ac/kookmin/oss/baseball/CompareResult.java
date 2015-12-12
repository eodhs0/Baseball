package kr.ac.kookmin.oss.baseball;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class CompareResult extends AppCompatActivity {

    ArrayList<LinkedHashMap<String, String>> compareTeamList;
    TableLayout table_stat;

    ImageView team_left;
    ImageView team_right;

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

        team_left = (ImageView) findViewById(R.id.team_left);
        team_right = (ImageView) findViewById(R.id.team_right);

        table_stat = (TableLayout) findViewById(R.id.table_stat);

        compareTeamList = TeamSelectActivity.compareTeamList;
        LinkedHashMap<String, String> teamLeftHashMap = compareTeamList.get(0);
        LinkedHashMap<String, String> teamRightHashMap = compareTeamList.get(1);

        Iterator<String> iteratorLeft = teamLeftHashMap.keySet().iterator();

        if (iteratorLeft.hasNext()) {
            String key = (String) iteratorLeft.next();
            TableRow row = new TableRow(this);
            // create a new TextView for showing xml data
            TextView teamLeft = new TextView(this);
            TextView stat = new TextView(this);
            TextView teamRight = new TextView(this);

            setTextViewLayout(teamLeft, teamLeftHashMap.get(key), "color");
            setTextViewLayout(stat, "기록", "color");
            setTextViewLayout(teamRight, teamRightHashMap.get(key), "color");

            row.addView(teamLeft);
            row.addView(stat);
            row.addView(teamRight);
            // add the TableRow to the TableLayout
            table_stat.addView(row, new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT));

        }

        while (iteratorLeft.hasNext()) {
            String key = (String) iteratorLeft.next();
            TableRow row = new TableRow(this);
            // create a new TextView for showing xml data
            TextView teamLeft = new TextView(this);
            TextView stat = new TextView(this);
            TextView teamRight = new TextView(this);

            setTextViewLayout(teamLeft, teamLeftHashMap.get(key), "white");
            setTextViewLayout(stat, key, "color");
            setTextViewLayout(teamRight, teamRightHashMap.get(key), "white");

            row.addView(teamLeft);
            row.addView(stat);
            row.addView(teamRight);
            // add the TableRow to the TableLayout
            table_stat.addView(row, new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT));
        }

        team_left.setImageDrawable(TeamSelectActivity.team_left);
        team_right.setImageDrawable(TeamSelectActivity.team_right);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        TeamSelectActivity.compareTeamList.clear();
        TeamSelectActivity.team_left = null;
        TeamSelectActivity.team_right = null;
    }

    public void setTextViewLayout(TextView tv, String str, String color) {
        tv.setText(str);
        if (color.equals("white")) {
            tv.setBackgroundResource(R.color.white);
        } else {
            tv.setBackgroundResource(R.color.table);
            tv.setTextColor(Color.parseColor("#000000"));
        }
        tv.setGravity(Gravity.CENTER_HORIZONTAL);
        TableRow.LayoutParams tsm = new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f);
        tsm.setMargins(3, 3, 3, 3); // setMargins(left, top, right, bottom);
        tv.setLayoutParams(tsm);
    }
}