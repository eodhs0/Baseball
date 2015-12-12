package kr.ac.kookmin.oss.baseball;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class SearchFragment extends Fragment {

    private View view;
    private EditText editText;
    public Button searchButton1;
    private TextView textView;
    private Button batterSearchButton;
    private Button pitcherSearchButton;
    private Button teamSearchButton;

    public static SearchFragment newInstance() {
        SearchFragment fragment = new SearchFragment();
        return fragment;
    }

    public SearchFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_search, container, false);
       // editText = (EditText) view.findViewById(R.id.serach_text);
        searchButton1 = (Button) view.findViewById(R.id.search_button);
        batterSearchButton = (Button) view.findViewById(R.id.search_batterbutton);
        pitcherSearchButton = (Button) view.findViewById(R.id.search_pitcherbutton);
        teamSearchButton = (Button) view.findViewById(R.id.search_teambutton);
        textView = (TextView) view.findViewById(R.id.stat_text);




        batterSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), BetterSearchActivity.class);
                startActivity(i);
            }
        });

        pitcherSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), PitcherSearchActivity.class);
                startActivity(i);
            }
        });

        teamSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), TeamSearchActivity.class);
                startActivity(i);
            }
        });

        return view;
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