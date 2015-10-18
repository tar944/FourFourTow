package Unit;


import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Random;

import DataModel.LeagueDataModel;
import DataModel.TeamDataModel;


public class AllFakeData {

    public static ArrayList<LeagueDataModel> ldmData;
    public static ArrayList<TeamDataModel> tdmData;

    public static JSONObject FillData(int wich,int datanum)
    {
        JSONObject json=null;

        switch (wich)
        {
            case 1://league Fake Data Maker
                ldmData=new ArrayList<LeagueDataModel>();
                LeagueDataModel ldm;
                for (int i=0;i<datanum;i++)
                {
                    ldm=new LeagueDataModel();
                    ldm.countryName="کشور تستی "+i+"";
                    ldm.name="لیگ تستی "+i+"";
                    ldm.leagueLogoUrl="";
                    ldmData.add(ldm);
                }

                break;
            case 2:
                tdmData=new ArrayList<TeamDataModel>();
                TeamDataModel tdm;
                for (int i=0;i<datanum;i++)
                {
                    tdm=new TeamDataModel();
                    tdm.like=false;
                    tdm.name="تست تیم شماره ی "+i+"";
                    tdm.teamLogoUrl="";
                    tdmData.add(tdm);
                }

                break;
        }
        return json;
    }



}
