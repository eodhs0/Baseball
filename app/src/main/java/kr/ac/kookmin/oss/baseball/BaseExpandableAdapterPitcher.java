package kr.ac.kookmin.oss.baseball;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class BaseExpandableAdapterPitcher extends BaseExpandableListAdapter {

    private ArrayList<String> groupList = null;
    private ArrayList<ArrayList<String>> childList = null;
    private LayoutInflater inflater = null;
    private ViewHolder viewHolder = null;
    private Context mContext;
    private Drawable myDrawable;

    public BaseExpandableAdapterPitcher(Context c, ArrayList<String> groupList,
                                 ArrayList<ArrayList<String>> childList) {
        super();
        this.inflater = LayoutInflater.from(c);
        this.groupList = groupList;
        this.childList = childList;
        mContext = c;
    }

    // 그룹 포지션을 반환한다.
    @Override
    public String getGroup(int groupPosition) {
        return groupList.get(groupPosition);
    }

    // 그룹 사이즈를 반환한다.
    @Override
    public int getGroupCount() {
        return groupList.size();
    }

    // 그룹 ID를 반환한다.
    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    // 그룹뷰 각각의 ROW
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            viewHolder = new ViewHolder();
            v = inflater.inflate(R.layout.list_row, parent, false);
            viewHolder.tv_groupName = (TextView) v.findViewById(R.id.tv_group);
            viewHolder.iv_image = (ImageView) v.findViewById(R.id.iv_image);
            v.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) v.getTag();
        }

        // 그룹을 펼칠때와 닫을때 아이콘을 변경해 준다.
        if (isExpanded) {
            //viewHolder.iv_image.setBackgroundColor(Color.GREEN);
        } else {
            //viewHolder.iv_image.setBackgroundColor(Color.WHITE);
        }

        viewHolder.tv_groupName.setText(getGroup(groupPosition));

        if (viewHolder.tv_groupName.getText().toString().equals("두산")) {
            myDrawable = mContext.getResources().getDrawable(R.drawable.team_bears);
        } else if (viewHolder.tv_groupName.getText().toString().equals("삼성")) {
            myDrawable = mContext.getResources().getDrawable(R.drawable.team_lions);
        } else if (viewHolder.tv_groupName.getText().toString().equals("NC")) {
            myDrawable = mContext.getResources().getDrawable(R.drawable.team_dinos);
        } else if (viewHolder.tv_groupName.getText().toString().equals("넥센")) {
            myDrawable = mContext.getResources().getDrawable(R.drawable.team_heroes);
        } else if (viewHolder.tv_groupName.getText().toString().equals("SK")) {
            myDrawable = mContext.getResources().getDrawable(R.drawable.team_wyvurns);
        } else if (viewHolder.tv_groupName.getText().toString().equals("한화")) {
            myDrawable = mContext.getResources().getDrawable(R.drawable.team_eagles);
        } else if (viewHolder.tv_groupName.getText().toString().equals("KIA")) {
            myDrawable = mContext.getResources().getDrawable(R.drawable.team_tigers);
        } else if (viewHolder.tv_groupName.getText().toString().equals("롯데")) {
            myDrawable = mContext.getResources().getDrawable(R.drawable.team_giants);
        } else if (viewHolder.tv_groupName.getText().toString().equals("LG")) {
            myDrawable = mContext.getResources().getDrawable(R.drawable.team_twins);
        } else if (viewHolder.tv_groupName.getText().toString().equals("kt")) {
            myDrawable = mContext.getResources().getDrawable(R.drawable.team_wiz);
        }
        viewHolder.iv_image.setImageDrawable(myDrawable);

        return v;
    }

    // 차일드뷰를 반환한다.
    @Override
    public String getChild(int groupPosition, int childPosition) {
        return childList.get(groupPosition).get(childPosition);
    }

    // 차일드뷰 사이즈를 반환한다.
    @Override
    public int getChildrenCount(int groupPosition) {
        return childList.get(groupPosition).size();
    }

    // 차일드뷰 ID를 반환한다.
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    // 차일드뷰 각각의 ROW
    @Override
    public View getChildView(int groupPosition, int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            viewHolder = new ViewHolder();
            v = inflater.inflate(R.layout.child_row, null);
            viewHolder.tv_childName = (TextView) v.findViewById(R.id.tv_child);
            viewHolder.cb_child = (CheckBox) v.findViewById(R.id.cb_child);
            v.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) v.getTag();
        }

        viewHolder.tv_childName.setText(getChild(groupPosition, childPosition));
        addCheckListener(viewHolder.cb_child, viewHolder.tv_childName.getText().toString());

        return v;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    class ViewHolder {
        public ImageView iv_image;
        public TextView tv_groupName;
        public TextView tv_childName;
        public CheckBox cb_child;
    }

    public void addCheckListener(final CheckBox cb, final String pitcherName) {
        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked) {
                    PitcherSelectActivity.comparePitcherList.clear();
                    cb.setSelected(false);
                } else {
                    cb.setSelected(true);
                    PitcherSelectActivity.comparePitcherList.add(searchPitcher(pitcherName));
                    if (PitcherSelectActivity.comparePitcherList.size() == 2) {
                        Intent i = new Intent(mContext, PitcherCompareResult.class);
                        mContext.startActivity(i);
                    }
                }
            }
        });


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

}