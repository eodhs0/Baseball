package kr.ac.kookmin.oss.baseball;

import android.content.Context;
import android.widget.Toast;

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
    ArrayList<LinkedHashMap<String, String>> statList = new ArrayList<LinkedHashMap<String, String>>();

    public StatData(Context mContext)
    {
        this.mContext = mContext;

        try
        {
            InputStream in = mContext.getAssets().open("stat.dat");
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            String line = null;

            while ((line = reader.readLine()) != null)
            {
                statList.add(CreateLinkedHashMap(line));
            }
            reader.close();

        }
        catch (Exception e)
        {
            System.out.println("Can't Initiate!");
        }

    }

    public LinkedHashMap<String, String> CreateLinkedHashMap(String line)
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

}