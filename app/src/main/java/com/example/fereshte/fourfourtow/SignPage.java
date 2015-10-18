package com.example.fereshte.fourfourtow;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class SignPage extends Activity implements View.OnClickListener{

    //======================================Views===================================================
    private Button btn_in,btn_up;
    private EditText et_1,et_2,et_3,et_4;
    private ImageView iv_2,iv_3,iv_4;
    private TextView tv_forgot;
    //======================================Vars====================================================

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_page);
        Casting();
        et_1.setHint(getResources().getString(R.string.sp_user_name));
        et_2.setHint(getResources().getString(R.string.sp_pass));
        et_3.setHint(getResources().getString(R.string.sp_email));
        et_4.setHint(getResources().getString(R.string.sp_rpass));

        btn_in.setOnClickListener(this);
        btn_up.setOnClickListener(this);
        tv_forgot.setOnClickListener(this);
    }

    private void Casting()
    {
        btn_in= (Button) findViewById(R.id.btn_signin);
        btn_up= (Button) findViewById(R.id.btn_signun);

        et_1= (EditText) findViewById(R.id.et_sign_1);
        et_2= (EditText) findViewById(R.id.et_sign_2);
        et_3= (EditText) findViewById(R.id.et_sign_3);
        et_4= (EditText) findViewById(R.id.et_sign_4);

        iv_2= (ImageView) findViewById(R.id.iv_sign_2);
        iv_3= (ImageView) findViewById(R.id.iv_sign_3);
        iv_4= (ImageView) findViewById(R.id.iv_sign_4);

        tv_forgot= (TextView) findViewById(R.id.tv_sign_forgot);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btn_signin:
                break;
            case R.id.btn_signun:
                if (btn_up.getText().equals(getString(R.string.sp_sign_up))) {
                    et_3.setVisibility(View.VISIBLE);
                    et_4.setVisibility(View.VISIBLE);
                    iv_3.setVisibility(View.VISIBLE);
                    iv_4.setVisibility(View.VISIBLE);
                    et_1.setHint(getString(R.string.sp_user));
                    tv_forgot.setVisibility(View.GONE);

                    btn_up.setText(getResources().getString(R.string.sp_sign_in));
                    btn_in.setText(getString(R.string.sp_save_up));
                }
                else if (btn_up.getText().equals(getString(R.string.sp_sign_in)))
                {
                    et_1.setHint(getString(R.string.sp_user_name));
                    et_3.setVisibility(View.GONE);
                    et_4.setVisibility(View.GONE);
                    iv_3.setVisibility(View.GONE);
                    iv_4.setVisibility(View.GONE);
                    tv_forgot.setVisibility(View.VISIBLE);
                    btn_in.setText(getResources().getString(R.string.sp_sign_in));
                    btn_up.setText(getString(R.string.sp_sign_up));
                }
                else if (btn_up.getText().equals(getString(R.string.sp_back)))
                {
                    et_1.setHint(getString(R.string.sp_user_name));
                    et_2.setVisibility(View.VISIBLE);
                    iv_2.setVisibility(View.VISIBLE);

                    et_3.setVisibility(View.GONE);
                    et_4.setVisibility(View.GONE);
                    iv_3.setVisibility(View.GONE);
                    iv_4.setVisibility(View.GONE);
                    tv_forgot.setText(getString(R.string.sp_forgot_pass));
                    btn_in.setText(getResources().getString(R.string.sp_sign_in));
                    btn_up.setText(getString(R.string.sp_sign_up));
                }
                break;
            case R.id.tv_sign_forgot:
                if (!tv_forgot.getText().equals(getString(R.string.sp_inter_email))) {
                    et_2.setVisibility(View.GONE);
                    et_3.setVisibility(View.GONE);
                    et_4.setVisibility(View.GONE);
                    iv_2.setVisibility(View.GONE);
                    iv_3.setVisibility(View.GONE);
                    iv_4.setVisibility(View.GONE);
                    et_1.setHint(getString(R.string.sp_email));
                    tv_forgot.setText(getString(R.string.sp_inter_email));
                    btn_in.setText(getString(R.string.sp_send_pass));
                    btn_up.setText(getString(R.string.sp_back));
                }
                break;
        }
    }
}
