package kr.co.fw.common.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import net.sf.json.JSONObject;

public class FCMSendUtil {
	
	@SuppressWarnings({ "unchecked", "rawtypes", "deprecation" })
	public static void pushFCMNotification(String[] device_token, String title, String msg) throws Exception {
		
		String authKey = "AAAA1RQHl0o:APA91bEuNv917ppXVBk9ZXdJcv5xZZp6d_75CrZIBO3G4Fwnk5y14DELl_T2XLK1kHquSBPnZ-ZdSb5MBRH61YpCZ2Zc5KjUYAlInHLY52VW9gcFBx2YLau5Rz2SKIpaUlbh_FPUnLwe";
		String FMCurl = "https://fcm.googleapis.com/fcm/send";
		
		URL url = new URL(FMCurl);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		
		conn.setUseCaches(false);
	    conn.setDoInput(true);
	    conn.setDoOutput(true);

	    conn.setRequestMethod("POST");
	    conn.setRequestProperty("Authorization","key="+authKey);
	    conn.setRequestProperty("Content-Type","application/json; charset=utf-8");

		JSONObject json = new JSONObject();
	    //json.put("to",""); //device_token TEST
	    json.put("to",device_token[0]); //device_token
	    JSONObject info = new JSONObject();
	    info.put("title", title);   // Notification title
	    info.put("body", msg); // Notification body
	    json.put("notification", info);
	    json.put("data", info);

		try(OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream())) {
			wr.write(String.valueOf(json));
			wr.flush();
		} catch (Exception e) {
			
		}
		if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
			throw new RuntimeException("실패 : HTTP error code : " + conn.getResponseCode());
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader( (conn.getInputStream()) ));
		
		String output;
		System.out.println("서버로 부터 수신 중...\n");
		StringBuffer response = new StringBuffer();
		while ((output = br.readLine()) != null) {
			System.out.println(output);
			response.append(output);}

				br.close();
		System.out.println(response);
		JsonObject jsonobject = null; 
		JsonElement element = null;
		//Type type = new TypeToken<List<Map>>(){}.getType();
		JsonParser parser = new JsonParser();
		//List<Map> apilist = new ArrayList<Map>();
		//Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").create();
		element = parser.parse(response.toString());
		jsonobject = element.getAsJsonObject();
		System.out.println(jsonobject);
		System.out.println(jsonobject.get("multicast_id"));
		conn.disconnect();
	}
}
