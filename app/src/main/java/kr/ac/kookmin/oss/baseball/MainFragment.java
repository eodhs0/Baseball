package kr.ac.kookmin.oss.baseball;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainFragment extends Fragment {

    private View view;
    private EditText batterEditText;
    private EditText pitcherEditText;
    private Button batterPredictButton;
    private Button pitcherPredictButton;
    private TextView textView;
    private MainFragment MainFragment;

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        return fragment;
    }

    public MainFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_main, container, false);
        // editText = (EditText) view.findViewById(R.id.serach_text);
        textView = (TextView) view.findViewById(R.id.stat_text);

        return view;
    }
}