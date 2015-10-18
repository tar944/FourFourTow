package com.example.fereshte.fourfourtow;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import com.cepheuen.progresspageindicator.ProgressPageIndicator;

import Adapters.TutorialVPagerAdapter;


public class AidPage extends FragmentActivity implements View.OnClickListener{
//========================================Views=====================================================
    private ViewPager vp_countainer;
    private ProgressPageIndicator dots_layout;
    private Button btn_next,btn_previus;
//========================================Vars======================================================

    private int currentPage=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aid_page);
        Casting();
        TutorialVPagerAdapter tutorialVPagerAdapter = new TutorialVPagerAdapter(AidPage.this);
        vp_countainer.setAdapter(tutorialVPagerAdapter);
        vp_countainer.setOffscreenPageLimit(1);
        dots_layout.setViewPager(vp_countainer);
        btn_previus.setText(getResources().getString(R.string.skip));
        btn_next.setOnClickListener(this);
        btn_previus.setOnClickListener(this);
        btn_previus.setVisibility(View.VISIBLE);
    }
    private void Casting()
    {
        vp_countainer= (ViewPager) findViewById(R.id.vpager_cuntainer);
        dots_layout= (ProgressPageIndicator) findViewById(R.id.dotsL);
        btn_next= (Button) findViewById(R.id.btn_ind_next);
        btn_previus= (Button) findViewById(R.id.btn_ind_pre);
    }

    @Override
    public void onClick(View view) {

        Intent intent=new Intent(AidPage.this,SignPage.class);
        switch (view.getId())
        {
            case R.id.btn_ind_next:
                if (btn_next.getText()==getString(R.string.tt_goto_next))
                {
                    startActivity(intent);
                    overridePendingTransition(R.anim.splash_transition, R.anim.main_activity_transition);
                    this.finish();
                }
                else
                {
                    currentPage++;
                    if (currentPage==1)
                        btn_previus.setText(getString(R.string.previus));
                    else if (currentPage==0)
                        btn_previus.setText(getString(R.string.skip));

                    if (currentPage==4)
                        btn_next.setText(getResources().getString(R.string.tt_goto_next));
                    vp_countainer.setCurrentItem(currentPage, true);
                }
                break;
            case R.id.btn_ind_pre:
                if (btn_previus.getText()==getResources().getString(R.string.skip))
                {
                    startActivity(intent);
                    overridePendingTransition(R.anim.splash_transition, R.anim.main_activity_transition);
                    this.finish();
                }
                else
                {
                    currentPage--;
                    if (currentPage==0)
                        btn_previus.setText(getResources().getString(R.string.skip));
                    vp_countainer.setCurrentItem(currentPage, true);
                }
                break;
        }
        switch (currentPage)
        {
            case 0:
                vp_countainer.setBackgroundColor(getResources().getColor(R.color.tt_page1));
                break;
            case 1:
                vp_countainer.setBackgroundColor(getResources().getColor(R.color.tt_page2));
                break;
            case 2:
                vp_countainer.setBackgroundColor(getResources().getColor(R.color.tt_page3));
                break;
            case 3:
                vp_countainer.setBackgroundColor(getResources().getColor(R.color.tt_page4));
                break;
            case 4:
                vp_countainer.setBackgroundColor(getResources().getColor(R.color.tt_page5));
                break;
        }
    }
}
