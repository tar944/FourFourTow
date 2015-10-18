package Adapters;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.fereshte.fourfourtow.R;

import java.util.ArrayList;

import DataModel.TeamDataModel;

public class SelectTeamAdapter extends BaseAdapter{

    private ArrayList<TeamDataModel> arraytdm=new ArrayList<TeamDataModel>();
    private Activity activity;

    public SelectTeamAdapter(Activity activity,ArrayList<TeamDataModel> arraytdm)
    {
        this.arraytdm=arraytdm;
        this.activity=activity;
    }

    @Override
    public int getCount() {
        return arraytdm.size();
    }

    @Override
    public Object getItem(int i) {
        return arraytdm.get(i);
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
            row=inflater.inflate(R.layout.select_lv_team_cell,null);
            holder.ch_selected= (CheckBox) row.findViewById(R.id.ch_lv_select_cell);
            holder.tv_team_name= (TextView) row.findViewById(R.id.tv_lv_select_name);
            row.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) row.getTag();
        }

        if (arraytdm.get(position).like)
            holder.ch_selected.setChecked(true);
        else
            holder.ch_selected.setChecked(false);

        holder.tv_team_name.setText(arraytdm.get(position).name);

        return row;
    }

    static class ViewHolder
    {
        CheckBox ch_selected;
        TextView tv_team_name;
    }
}
