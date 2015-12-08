package kr.ac.kookmin.oss.baseball;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class PredictFragment extends Fragment {

    private View view;
    private EditText batterEditText;
    private EditText pitcherEditText;
    private Button batterPredictButton;
    private Button pitcherPredictButton;
    private TextView textView;

    private SearchFragment searchFragment;


    public static PredictFragment newInstance() {
        PredictFragment fragment = new PredictFragment();
        return fragment;
    }

    public PredictFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View  onCreateView(LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_predict, container, false);
        batterEditText = (EditText) view.findViewById(R.id.serach_battertext);
        batterPredictButton = (Button) view.findViewById(R.id.search_batterbutton);
        pitcherEditText = (EditText) view.findViewById(R.id.serach_pitchertext);
        pitcherPredictButton = (Button) view.findViewById(R.id.search_pitcherbutton);

        textView = (TextView) view.findViewById(R.id.stat_text);

        searchFragment = searchFragment.newInstance();

        batterPredictButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinkedHashMap<String, String> data = searchFragment.searchBatter((batterEditText.getText().toString()));
                textView.setText("선수의 BABIP는" + getBABIP(data) + "입니다.");
            }
        });

        pitcherPredictButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinkedHashMap<String, String> data = searchFragment.searchPitcher((pitcherEditText.getText().toString()));
                textView.setText("투수의 LOB는" + getLOB(data) + "입니다" + System.getProperty("line.separator") + "투수의 FIP는" + getFIP(data) + "입니다");
            }
        });


        return view;
    }



    public float getBABIP(LinkedHashMap<String, String> data) {
        float h  = Integer.parseInt(data.get("H"));
        float hr  = Integer.parseInt(data.get("HR"));
        float ab  = Integer.parseInt(data.get("AB"));
        float k  = Integer.parseInt(data.get("K"));
        float sf  = Integer.parseInt(data.get("SF"));

        float babip = (h - hr) / (ab - k - hr +sf);

        return babip;


    }

    public double getLOB(LinkedHashMap<String, String> data){
        double h  = Integer.parseInt(data.get("H"));
        double bb  = Integer.parseInt(data.get("BB"));
        double hbp  = Integer.parseInt(data.get("HBP"));
        double r  = Integer.parseInt(data.get("R"));
        double hr  = Integer.parseInt(data.get("HR"));


        double lob =(( h + bb + hbp - r) /  ((h + bb + hbp) - (1.4*hr)));
        return lob;
    }

    public double getFIP(LinkedHashMap<String, String> data) {
        double hr = Integer.parseInt(data.get("HR"));
        double bb = Integer.parseInt(data.get("BB"));
        double ibb = Integer.parseInt(data.get("IBB"));
        double hbp = Integer.parseInt(data.get("HBP"));
        double k = Integer.parseInt(data.get("K"));
        double ip = Integer.parseInt(data.get("IP"));

        double fip = (((((13 * hr) + (3 * ((bb + hbp) - ibb))) - (2 * k)) / ip) + 3.2);
        return fip;

    }
}