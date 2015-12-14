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

public class DictionaryFragment extends Fragment {

    private DictionaryFragment DictionaryFragment;
    private View view;
    private Button batterWordButton;
    private Button pitcherWordButton;
    private Button teamWordButton;

    public static DictionaryFragment newInstance() {
        DictionaryFragment fragment = new DictionaryFragment();
        return fragment;
    }

    public DictionaryFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_dictionary, container, false);
        // editText = (EditText) view.findViewById(R.id.serach_text);

        batterWordButton = (Button) view.findViewById(R.id.batterWord);
        pitcherWordButton = (Button) view.findViewById(R.id.pitcherWord);
        teamWordButton = (Button) view.findViewById(R.id.teamWord);

        batterWordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), DictionaryBatterWordActivity.class);
                startActivity(i);
            }
        });

        pitcherWordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), DictionaryPitcherWordActivity.class);
                startActivity(i);
            }
        });

        teamWordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), DictionaryTeamWordActivity.class);
                startActivity(i);
            }
        });

        return view;
    }

}