package kr.ac.kookmin.oss.baseball;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
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
                textView.setText("타자의 BABIP는" + getBABIP(data) + "입니다."+ "BABIP는 타자의 인플레이 타구의 타율을 의미합니다."+ System.getProperty("line.separator")
                        + "타자의 SLG는" + getSLG(data) + "입니다." + "SLG는 장타율을 의미합니다. 1.0이상이면 에이스타자라고 평가받습니다.");
            }
        });

        pitcherPredictButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinkedHashMap<String, String> data = searchFragment.searchPitcher((pitcherEditText.getText().toString()));
                textView.setText("투수의 LOB는" + getLOB(data) + "입니다" + " left on bases 투수의 잔루율을 나타냄니다." + System.getProperty("line.separator")
                        + "투수의 FIP는" + getFIP(data) + "입니다" + "수비 무관 평균 자책점으로 투수가 가진 능력만을 평가기준입니다." + System.getProperty("line.separator")
                        + "투수의 KBB는" + getKBB(data) + "입니다." + "삼진을 볼넷으로 나눈값으로 3.0 이상이면 에이스투수라고 평가 받습니다");
            }
        });


        return view;
    }



    public String getBABIP(LinkedHashMap<String, String> data) {
        DecimalFormat format = new DecimalFormat("###.###");
        float h  = Float.parseFloat(data.get("H"));
        float hr  = Float.parseFloat(data.get("HR"));
        float ab  = Float.parseFloat(data.get("AB"));
        float k  = Float.parseFloat(data.get("K"));
        float sf  = Float.parseFloat(data.get("SF"));

        float babip = (h - hr) / (ab - k - hr +sf);
        String str = format.format(babip);

        return str; // "타자 : BABIP는 인플레이 타구의 타율을 의미합니다."


    }

    public String getSLG(LinkedHashMap<String, String> data) {
        DecimalFormat format = new DecimalFormat("###.###");
        float b1  = Float.parseFloat(data.get("1B"));
        float b2  = Float.parseFloat(data.get("2B"));
        float b3  = Float.parseFloat(data.get("3B"));
        float hr  = Float.parseFloat(data.get("HR"));
        float ab  = Float.parseFloat(data.get("AB"));

        float SLG = ((b1*1)+(b2*2)+(b3*3)+(hr*4))/ab;
        String str = format.format(SLG);

        return str; // 장타율 (Slugging percentage SLG)


    }



    public String getLOB(LinkedHashMap<String, String> data){
        DecimalFormat format = new DecimalFormat("###.###");
        double h  = Double.parseDouble(data.get("H"));
        double bb  = Double.parseDouble(data.get("BB"));
        double hbp  = Double.parseDouble(data.get("HBP"));
        double r  = Double.parseDouble(data.get("R"));
        double hr  = Double.parseDouble(data.get("HR"));
        double lob =(( h + bb + hbp - r) /  ((h + bb + hbp) - (1.4*hr)));

        String str = format.format(lob);
        return str;
    }

    public String getFIP(LinkedHashMap<String, String> data) {
        DecimalFormat format = new DecimalFormat("###.###");
        double hr = Double.parseDouble(data.get("HR"));
        double bb = Double.parseDouble(data.get("BB"));
        double ibb = Double.parseDouble(data.get("IBB"));
        double hbp = Double.parseDouble(data.get("HBP"));
        double k = Double.parseDouble(data.get("K"));
        double ip = Double.parseDouble(data.get("IP"));
        double fip = (((((13 * hr) + (3 * (bb + hbp - ibb))) - (2 * k)) / ip) + 3.2);

        String str = format.format(fip);
        return str;



    }

    public String getKBB(LinkedHashMap<String, String> data) {
        DecimalFormat format = new DecimalFormat("###.###");
        double k = Double.parseDouble(data.get("K"));
        double bb = Double.parseDouble(data.get("BB"));
        double kbb = k / bb;
        String str = format.format(kbb);
        return str; // "K/BB 삼진을 볼넷으로 나눈값으로 3.0 이상이면 에이스투수라고 평가 받습니다
    }
}