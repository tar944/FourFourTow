package Unit;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;

import com.example.fereshte.fourfourtow.R;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

public class RequestSender {
	private String ContentType = "Content-Type";
	private String ContentEncoding = "Content-Encoding";
	private NetworkHandler networkHandler;
	private Context context;

	public RequestSender(Context context) {
		this.context = context;
		networkHandler = new NetworkHandler(context);
	}

	public JSONObject sendRequest(String apiUrl) {
		if(networkHandler.isOnline()){
			String json = "";
			JSONObject jsonObject = null;
			HttpClient client = new DefaultHttpClient();

			HttpGet httpGet = new HttpGet(apiUrl);

			httpGet.setHeader(ContentType, "application/json");
			httpGet.setHeader(ContentEncoding, "gzip");

			try
			{
				int timeout = 30000;
				HttpParams prms = new BasicHttpParams();
				HttpConnectionParams.setConnectionTimeout(prms, timeout);
				httpGet.setParams(prms);

				HttpResponse response;

				response = client.execute(httpGet);

				StatusLine statusLine = response.getStatusLine();
				int statusCode = statusLine.getStatusCode();
				if(statusCode == 200){
					HttpEntity entity = response.getEntity();
					InputStream content = entity.getContent();

					BufferedReader in = new BufferedReader(new InputStreamReader(content, "utf-8"), 8);
					StringBuilder sb = new StringBuilder("");
					String l = "";
					String nl = System.getProperty("line.separator");
					while ((l = in.readLine()) != null) {
						sb.append(l).append(nl);
					}
					in.close();
					json = sb.toString();
					try {
						jsonObject = new JSONObject(json);
					} catch (JSONException e) {
						e.printStackTrace();
					} catch (Exception x) {
						x.printStackTrace();
					}
				}else {
					Log.e(apiUrl, "Failed to get json");
					return null;
				}
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return jsonObject;
		}else{
			networkHandler.noInternetDialog(context.getString(R.string.no_internet_dialog_title),
					context.getString(R.string.no_internet_dialog_msg),
					context.getString(R.string.setting_string_for_dialog_box),
					context.getString(R.string.cancel_string_for_dialog_box),
					Color.parseColor("#673AB7"));
			return null;
		}
	}
	
	public JSONObject sendEmailRequest(String url, String body) {
		JSONObject jsonObj = null;
		if(networkHandler.isOnline()){
			try {
				URL urlConnection = new URL(url);
				HttpURLConnection con = (HttpURLConnection) urlConnection.openConnection();

				con.setRequestMethod("POST");
				con.setDoOutput(true);
				con.setRequestProperty(ContentType, "application/json");
				con.setRequestProperty(ContentEncoding, "gzip");

				BufferedWriter output = new BufferedWriter(new OutputStreamWriter(con.getOutputStream()));
				output.write(body);
				output.flush();
				output.close();

				BufferedReader in;
				if (con.getResponseCode() / 100 == 2) { // 2xx code means success
					in = new BufferedReader(
							new InputStreamReader(con.getInputStream()));
				} else {  

					in = new BufferedReader(
							new InputStreamReader(con.getErrorStream()));
				}

				String inputLine;
				StringBuffer response = new StringBuffer();

				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();
				jsonObj = new JSONObject(response.toString());
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception x) {
				x.printStackTrace();
			}

			return jsonObj;
		}else{
			networkHandler.noInternetDialog(context.getString(R.string.no_internet_dialog_title),
					context.getString(R.string.no_internet_dialog_msg),
					context.getString(R.string.setting_string_for_dialog_box),
					context.getString(R.string.cancel_string_for_dialog_box),
					Color.parseColor("#673AB7"));
			return null;
		}
	}
}