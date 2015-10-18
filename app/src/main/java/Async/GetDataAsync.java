package Async;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import Unit.RequestSender;


public class GetDataAsync extends AsyncTask<String, Void, JSONObject> {

    private Context mContext;
    private String url;
    private RequestSender requestSender;

    private AsyncTaskCompleteListener mCallback;

    public GetDataAsync(Context context, Fragment activity){
        mContext = context;
        this.mCallback = (AsyncTaskCompleteListener) activity;
        requestSender=new RequestSender(context);
    }


    @Override
    protected JSONObject doInBackground(String... params) {

        url = params[0];

        Log.v("URL For Developer", url);
        JSONObject json=null;
//        json= requestSender.sendRequest(url);

        return json;
    }

    @Override
    protected void onPostExecute(JSONObject result) {
        super.onPostExecute(result);
        try {
            mCallback.onTaskComplete(result);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
