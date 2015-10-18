package Unit;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.example.fereshte.fourfourtow.R;


public class NetworkHandler {
    private Context mContext;

    public NetworkHandler(Context context) {
        this.mContext = context;
    }


    public boolean isOnline() {
        ConnectivityManager connectivityManager = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = connectivityManager.getActiveNetworkInfo();
        return netInfo != null && netInfo.isAvailable() && netInfo.isConnected();
    }


    @SuppressLint("InflateParams")
	public void noInternetDialog(String title, String msg, String positiveButton, String negativeButton,int color) {
    	Looper.prepare();
    	TextView txt = new TextView(mContext);
	    txt.setText(title);
	    txt.setBackgroundColor(color);
	    txt.setPadding(27, 27, 16,27);
	  
	    txt.setTextColor(Color.WHITE);
	    txt.setTextSize(22);
        AlertDialog.Builder showPrompt = new AlertDialog.Builder(mContext);
        showPrompt.setCustomTitle(txt);
        LayoutInflater inflater = (LayoutInflater) mContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View convertView = (View) inflater.inflate(R.layout.dialog_network,
				null);
		showPrompt.setView(convertView);
        showPrompt.setCancelable(false);
        final Dialog d = showPrompt.show();
		Button b1 = (Button) d.findViewById(R.id.btn_positive);
		b1.setText(positiveButton);
		b1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				 Intent wifiSettings = new Intent(android.provider.Settings.ACTION_WIFI_SETTINGS);
	                mContext.startActivity(wifiSettings);
			}
		});
		Button b2 = (Button) d.findViewById(R.id.btn_negative);
		b2.setText(negativeButton);
		b2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				d.cancel();
//				((Activity)mContext).finish();
			}
		});

		TextView textView = (TextView) d.findViewById(R.id.message);
		textView.setText(msg);
		int dividerId = d.getContext().getResources()
				.getIdentifier("android:id/titleDivider", null, null);
		View divider = d.findViewById(dividerId);
		divider.setBackgroundColor(color);
		Looper.loop();
    }
}