package kr.ac.kookmin.oss.baseball;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class PitcherSelectActivity extends AppCompatActivity {

    private ArrayList<String> mGroupList = null;
    private ArrayList<ArrayList<String>> mChildList = null;
    private ArrayList<String> mChildListContentDoosan = null;
    private ArrayList<String> mChildListContentSamsung = null;
    private ArrayList<String> mChildListContentNc = null;
    private ArrayList<String> mChildListContentNexen = null;
    private ArrayList<String> mChildListContentSk = null;
    private ArrayList<String> mChildListContentHanhwa = null;
    private ArrayList<String> mChildListContentKia = null;
    private ArrayList<String> mChildListContentLotte = null;
    private ArrayList<String> mChildListContentLg= null;
    private ArrayList<String> mChildListContentKt = null;


    static ArrayList<LinkedHashMap<String, String>> comparePitcherList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pitcher_select);
        setLayout();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("비교 할 선수를 선택하세요");

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        comparePitcherList = new ArrayList<LinkedHashMap<String, String>>();

        mGroupList = new ArrayList<String>();
        mChildList = new ArrayList<ArrayList<String>>();
        mChildListContentDoosan = new ArrayList<String>();
        mChildListContentSamsung = new ArrayList<String>();
        mChildListContentNc = new ArrayList<String>();
        mChildListContentNexen = new ArrayList<String>();
        mChildListContentSk = new ArrayList<String>();
        mChildListContentHanhwa = new ArrayList<String>();
        mChildListContentKia = new ArrayList<String>();
        mChildListContentLotte = new ArrayList<String>();
        mChildListContentLg = new ArrayList<String>();
        mChildListContentKt = new ArrayList<String>();

        mGroupList.add("두산");
        mGroupList.add("삼성");
        mGroupList.add("NC");
        mGroupList.add("넥센");
        mGroupList.add("SK");
        mGroupList.add("한화");
        mGroupList.add("KIA");
        mGroupList.add("롯데");
        mGroupList.add("LG");
        mGroupList.add("kt");

        ArrayList<LinkedHashMap<String, String>> data = MainActivity.statData.PitcherList;
        int len = data.size();
        for (int i = 1; i < len; i++) {
            if (data.get(i).get("TEAM").equals("두산")) {
                mChildListContentDoosan.add(data.get(i).get("NAME"));
            } else if (data.get(i).get("TEAM").equals("삼성")) {
                mChildListContentSamsung.add(data.get(i).get("NAME"));
            } else if (data.get(i).get("TEAM").equals("NC")) {
                mChildListContentNc.add(data.get(i).get("NAME"));
            } else if (data.get(i).get("TEAM").equals("넥센")) {
                mChildListContentNexen.add(data.get(i).get("NAME"));
            } else if (data.get(i).get("TEAM").equals("SK")) {
                mChildListContentSk.add(data.get(i).get("NAME"));
            } else if (data.get(i).get("TEAM").equals("한화")) {
                mChildListContentHanhwa.add(data.get(i).get("NAME"));
            } else if (data.get(i).get("TEAM").equals("KIA")) {
                mChildListContentKia.add(data.get(i).get("NAME"));
            } else if (data.get(i).get("TEAM").equals("롯데")) {
                mChildListContentLotte.add(data.get(i).get("NAME"));
            } else if (data.get(i).get("TEAM").equals("LG")) {
                mChildListContentLg.add(data.get(i).get("NAME"));
            } else if (data.get(i).get("TEAM").equals("kt")) {
                mChildListContentKt.add(data.get(i).get("NAME"));
            }
        }

        mChildList.add(mChildListContentDoosan);
        mChildList.add(mChildListContentSamsung);
        mChildList.add(mChildListContentNc);
        mChildList.add(mChildListContentNexen);
        mChildList.add(mChildListContentSk);
        mChildList.add(mChildListContentHanhwa);
        mChildList.add(mChildListContentKia);
        mChildList.add(mChildListContentLotte);
        mChildList.add(mChildListContentLg);
        mChildList.add(mChildListContentKt);

        mListView.setAdapter(new BaseExpandableAdapterPitcher(this, mGroupList, mChildList));

    }

    /*
     * Layout
     */
    private ExpandableListView mListView;

    private void setLayout() {
        mListView = (ExpandableListView) findViewById(R.id.elv_list);
    }
}
