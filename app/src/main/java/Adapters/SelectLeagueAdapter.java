package Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fereshte.fourfourtow.R;

import java.util.ArrayList;

import DataModel.LeagueDataModel;

/**
 * Created by fereshte on 10/16/2015.
 */
public class SelectLeagueAdapter extends BaseAdapter {
    private ArrayList<LeagueDataModel> arrayldm=new ArrayList<LeagueDataModel>();
    private Activity activity;

    public SelectLeagueAdapter(Activity activity,ArrayList<LeagueDataModel> arrayldm)
    {
        this.arrayldm=arrayldm;
        this.activity=activity;
    }

    @Override
    public int getCount() {
        return arrayldm.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayldm.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View row, ViewGroup viewGroup) {
        ViewHolder holder;
        if (row==null)
        {
            LayoutInflater inflater = activity.getLayoutInflater();

            holder = new ViewHolder();
            row=inflater.inflate(R.layout.select_lv_league_cell,null);
            holder.iv_league_logo= (ImageView) row.findViewById(R.id.iv_league_logo);
            holder.tv_team_name= (TextView) row.findViewById(R.id.tv_lv_select_name);
            row.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) row.getTag();
        }


        holder.tv_team_name.setText(arrayldm.get(position).name);

        return row;
    }

    static class ViewHolder
    {
        ImageView iv_league_logo;
        TextView tv_team_name;
    }
}
