package Adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fereshte.fourfourtow.R;

import Fragments.TutorialPageFragment;

public class TutorialVPagerAdapter extends PagerAdapter {

    private Activity activity;
    public TutorialVPagerAdapter(Activity activity) {
        this.activity=activity;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @SuppressLint("InflateParams")
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) container.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.fragment_tutorial_page, null);
        ImageView iv_img= (ImageView) v.findViewById(R.id.iv_tutrial_image);
        TextView tv_title= (TextView) v.findViewById(R.id.tv_tutrial_title);
        TextView tv_des= (TextView) v.findViewById(R.id.tv_tutorial_des);
        switch (position)
        {
            case 0:
                tv_title.setText(activity.getResources().getString(R.string.tt_step1));
                tv_des.setText(activity.getResources().getString(R.string.tt_des1));
                iv_img.setImageDrawable(activity.getResources().getDrawable(R.drawable.stp1));
                break;
            case 1:
                tv_title.setText(activity.getResources().getString(R.string.tt_step2));
                tv_des.setText(activity.getResources().getString(R.string.tt_des2));
                iv_img.setImageDrawable(activity.getResources().getDrawable(R.drawable.stp2));
                break;
            case 2:
                tv_title.setText(activity.getResources().getString(R.string.tt_step3));
                tv_des.setText(activity.getResources().getString(R.string.tt_des3));
                iv_img.setImageDrawable(activity.getResources().getDrawable(R.drawable.stp3));
                break;
            case 3:
                tv_title.setText(activity.getResources().getString(R.string.tt_step4));
                tv_des.setText(activity.getResources().getString(R.string.tt_des4));
                iv_img.setImageDrawable(activity.getResources().getDrawable(R.drawable.stp4));
                break;
            case 4:
                tv_title.setText(activity.getResources().getString(R.string.tt_step5));
                tv_des.setText(activity.getResources().getString(R.string.tt_des5));
                iv_img.setImageDrawable(activity.getResources().getDrawable(R.drawable.stp5));
                break;
        }

        ((ViewPager) container).addView(v, 0);
        return v;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((View)object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((View) object) ;
    }
}