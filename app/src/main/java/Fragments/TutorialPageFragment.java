package Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fereshte.fourfourtow.R;

public class TutorialPageFragment extends Fragment {

//======================================Views=======================================================
    private TextView tv_title,tv_des;
    private ImageView iv_img;
//======================================Vars========================================================
    static int tt_pos;

    public static TutorialPageFragment Create(int pos) {
        TutorialPageFragment fragment = new TutorialPageFragment();
        Bundle args = new Bundle();
        tt_pos=pos;
        fragment.setArguments(args);
        return fragment;
    }

    public TutorialPageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_tutorial_page, container, false);
        Casting(view);
        switch (tt_pos)
        {
            case 0:
                tv_title.setText(getResources().getString(R.string.tt_step1));
                tv_des.setText(getResources().getString(R.string.tt_des1));
                iv_img.setImageDrawable(getResources().getDrawable(R.drawable.stp1));
                break;
            case 1:
                tv_title.setText(getResources().getString(R.string.tt_step2));
                tv_des.setText(getResources().getString(R.string.tt_des2));
                iv_img.setImageDrawable(getResources().getDrawable(R.drawable.stp2));
                break;
            case 2:
                tv_title.setText(getResources().getString(R.string.tt_step3));
                tv_des.setText(getResources().getString(R.string.tt_des3));
                iv_img.setImageDrawable(getResources().getDrawable(R.drawable.stp3));
                break;
            case 3:
                tv_title.setText(getResources().getString(R.string.tt_step4));
                tv_des.setText(getResources().getString(R.string.tt_des4));
                iv_img.setImageDrawable(getResources().getDrawable(R.drawable.stp4));
                break;
            case 4:
                tv_title.setText(getResources().getString(R.string.tt_step5));
                tv_des.setText(getResources().getString(R.string.tt_des5));
                iv_img.setImageDrawable(getResources().getDrawable(R.drawable.stp5));
                break;
        }
        return  view;
    }
    private void Casting(View view)
    {
        tv_title= (TextView) view.findViewById(R.id.tv_tutrial_title);
        tv_des= (TextView) view.findViewById(R.id.tv_tutorial_des);
        iv_img= (ImageView) view.findViewById(R.id.iv_tutrial_image);
    }
}
