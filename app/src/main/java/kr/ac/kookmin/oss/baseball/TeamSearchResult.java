package kr.ac.kookmin.oss.baseball;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class TeamSearchResult extends AppCompatActivity {

    private TableLayout table_stat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_search_result);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("검색 결과");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        LinkedHashMap<String, String> data = TeamSearchActivity.data3.get(0);

        table_stat = (TableLayout) findViewById(R.id.table_stat);

        Iterator<String> iteratorLeft = data.keySet().iterator();

        while (iteratorLeft.hasNext()) {
            String key = (String) iteratorLeft.next();
            TableRow row = new TableRow(this);
            // create a new TextView for showing xml data
            TextView stat = new TextView(this);
            TextView info = new TextView(this);

            setTextViewLayout(stat, key, "color");
            setTextViewLayout(info, data.get(key), "white");

            row.addView(stat);
            row.addView(info);
            // add the TableRow to the TableLayout
            table_stat.addView(row, new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT));
        }

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
