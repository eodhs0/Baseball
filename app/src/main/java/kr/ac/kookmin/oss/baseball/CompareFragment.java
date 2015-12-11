package kr.ac.kookmin.oss.baseball;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class CompareFragment extends Fragment {

    private View view;

    private Button batterButton;
    private Button pitcherButton;
    private Button teamButton;

    public static CompareFragment newInstance() {
        CompareFragment fragment = new CompareFragment();
        return fragment;
    }

    public CompareFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_compare, container, false);

        batterButton = (Button) view.findViewById(R.id.batter_button);
        pitcherButton = (Button) view.findViewById(R.id.pitcher_button);
        teamButton = (Button) view.findViewById(R.id.team_button);

        batterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), TeamSelectActivity.class);
                startActivity(i);
            }
        });

        pitcherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), TeamSelectActivity.class);
                startActivity(i);
            }
        });

        teamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), TeamSelectActivity.class);
                startActivity(i);
            }
        });

        return view;
    }

}
