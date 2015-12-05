package kr.ac.kookmin.oss.baseball;

import android.content.Context;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * Created by insanity on 12/4/15.
 */
public class StatData {

    Context mContext;
    ArrayList<LinkedHashMap<String, String>> BatterList = new ArrayList<LinkedHashMap<String, String>>();
    ArrayList<LinkedHashMap<String, String>> PitcherList = new ArrayList<LinkedHashMap<String, String>>();
    ArrayList<LinkedHashMap<String, String>> TeamList = new ArrayList<LinkedHashMap<String, String>>();

    public StatData(Context mContext)
    {
        this.mContext = mContext;

        try
        {
            InputStream in = mContext.getAssets().open("BatterData.dat");
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            String line = null;

            while ((line = reader.readLine()) != null)
            {
                BatterList.add(CreateBatterList(line));
            }

            in = mContext.getAssets().open("PitcherData.dat");
            reader = new BufferedReader(new InputStreamReader(in));

            line = null;

            while ((line = reader.readLine()) != null)
            {
                PitcherList.add(CreatePitcherList(line));
            }

            in = mContext.getAssets().open("TeamData.dat");
            reader = new BufferedReader(new InputStreamReader(in));

            line = null;

            while ((line = reader.readLine()) != null)
            {
                TeamList.add(CreateTeamList(line));
            }

            reader.close();

        }
        catch (Exception e)
        {
            System.out.println("Can't Initiate!");
        }

    }

    public LinkedHashMap<String, String> CreateBatterList(String line)
    {
        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
        String[] column = { "NAME", "TEAM", "G", "PA", "AB", "H", "1B", "2B", "3B", "HR", "R", "RBI", "BB", "IBB",
                "HBP", "K", "SF", "SH", "GIDP", "SB", "CB", "AVG" };
        String[] info;
        info = line.split("\t");

        for (int i = 0; i < info.length; i++)
        {
            map.put(column[i], info[i]);
        }

        return map;
    }

    public LinkedHashMap<String, String> CreatePitcherList(String line)
    {
        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
        String[] column = { "NAME", "TEAM", "G", "GS", "CG", "SHO", "QS", "TBF", "H", "2B", "3B", "HR", "R", "ER", "K", "BB", "IBB", "HBP", "WP", "BK", "IP" };
        String[] info;
        info = line.split("\t");

        for (int i = 0; i < info.length; i++)
        {
            map.put(column[i], info[i]);
        }

        return map;
    }

    public LinkedHashMap<String, String> CreateTeamList(String line)
    {
        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
        String[] column = { "TEAM", "W", "L", "D", "Win%", "10G", "SW", "Home", "Away", "AVG", "G", "AB", "H", "2B", "3B", "HR", "SB", "R", "IP", "ER" };
        String[] info;
        info = line.split("\t");

        for (int i = 0; i < info.length; i++)
        {
            map.put(column[i], info[i]);
        }

        return map;
    }

}