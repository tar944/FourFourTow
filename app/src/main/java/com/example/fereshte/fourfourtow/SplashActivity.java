package com.example.fereshte.fourfourtow;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import java.util.logging.Handler;

public class SplashActivity extends Activity implements View.OnClickListener {

    private Button btn_sign,btn_firstStart;
    private ProgressBar pbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final android.os.Handler handler = new android.os.Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run()
            {
                pbar.setVisibility(View.GONE);
                btn_sign.setVisibility(View.VISIBLE);
                btn_firstStart.setVisibility(View.VISIBLE);
            }
        }, 3000);
        btn_firstStart.setOnClickListener(this);
        btn_sign.setOnClickListener(this);
    }
    public void Casting()
    {
        btn_firstStart= (Button) findViewById(R.id.btn_splash_first_start);
        btn_sign= (Button) findViewById(R.id.btn_splash_sign);
        pbar= (ProgressBar) findViewById(R.id.pbar_splash);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btn_splash_first_start:
                break;
            case R.id.btn_splash_sign:
                break;
        }
    }
}
