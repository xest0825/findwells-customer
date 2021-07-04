package kr.co.fw.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;

@Slf4j
@Component
public class ApiUtil {
	
	/**
	 * HttpURLConnection으로 ERP 데이터 받아오기(JSONObject 형식)
	 * 
	 * @param erp_synk_url
	 * @return JSONObject
	 */
	public static JSONObject getApiData(String apiUrl, String reqMethod, HashMap<String, String> paramMap)
			throws IOException, Exception {
		JSONObject jsonObj = new JSONObject();
		BufferedReader bReader = null;
		OutputStream os = null;
		OutputStreamWriter writer = null;
		int HttpResult = 0;
		String param = "";

		try {
			URL conUrl = new URL(apiUrl);

			if (apiUrl.contains("https://")) {
				log.info("Https URLConnection!");
				HttpsURLConnection connection = (HttpsURLConnection) conUrl.openConnection();

				connection.setHostnameVerifier(new HostnameVerifier() {
					@Override
					public boolean verify(String hostname, SSLSession session) {
						return false;
					}
				});

				// SSL setting
				SSLContext context = SSLContext.getInstance("TLS");
				context.init(null, null, null); // No validation for now
				connection.setSSLSocketFactory(context.getSocketFactory());

				connection.setRequestProperty("dataType", "json");
				connection.setDoInput(true); // 입력스트림 사용여부
				connection.setDoOutput(true); // 출력스트림 사용여부
				connection.setUseCaches(false); // 캐시사용 여부
				connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
				connection.setReadTimeout(10000); // 타임아웃 설정 ms단위
				connection.setRequestMethod(reqMethod); // or GET

				os = connection.getOutputStream();
				writer = new OutputStreamWriter(os);

				Iterator<String> iterator = paramMap.keySet().iterator();
				while (iterator.hasNext()) {
					String key = iterator.next();
					if (null != paramMap.get(key) && !"null".equals(paramMap.get(key).toString())) {
						writer.write("&" + key + "=" + URLEncoder.encode(paramMap.get(key).toString(), "UTF-8"));
					} else {
						writer.write("&" + key + "=" + "");
					}
				}

				writer.flush();

				HttpResult = connection.getResponseCode();

				StringBuilder stringBuilder = new StringBuilder();
				log.info("connection Code = " + HttpResult);

				if (HttpResult == HttpURLConnection.HTTP_OK) {
					bReader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
					String line = null;
					while ((line = bReader.readLine()) != null) {
						stringBuilder.append(line + "\n");
					}

					param = stringBuilder.toString();
					jsonObj = (JSONObject) JSONObject.fromObject(param);

				} else {
					log.info("connection.getResponseMessage()=" + connection.getResponseMessage());
				}
			} else {
				log.info("Http URLConnection!");
				HttpURLConnection connection = (HttpURLConnection) conUrl.openConnection();
				connection.setRequestProperty("Content-Type", "application/json; utf-8");
//				connection.setRequestProperty("dataType", "json");
				connection.setRequestProperty("Accept", "application/json");
				connection.setDoInput(true); // 입력스트림 사용여부
				connection.setDoOutput(true); // 출력스트림 사용여부
				connection.setUseCaches(false); // 캐시사용 여부
				// connection.setRequestProperty("Content-Type",
				// "application/x-www-form-urlencoded");

				connection.setReadTimeout(10000); // 타임아웃 설정 ms단위
				connection.setRequestMethod(reqMethod); // or GET

				os = connection.getOutputStream();
				writer = new OutputStreamWriter(os);
				String jsonstring = new ObjectMapper().writeValueAsString(paramMap);
				jsonstring = new String(jsonstring.getBytes("UTF-8"), "EUC-KR");

				/*
				 * Iterator<String> iterator = paramMap.keySet().iterator(); while
				 * (iterator.hasNext()) { String key = iterator.next(); if(null !=
				 * paramMap.get(key) && !"null".equals(paramMap.get(key).toString())){
				 * writer.write("&"+key+"="+URLEncoder.encode(paramMap.get(key).toString(),
				 * "UTF-8")); }else{ writer.write("&"+key+"="+""); } }
				 */
				writer.write(jsonstring);

				writer.flush();

				HttpResult = connection.getResponseCode();

				StringBuilder stringBuilder = new StringBuilder();
				log.info("connection Code = " + HttpResult);

				if (HttpResult == HttpURLConnection.HTTP_OK) {
					bReader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "EUC-KR"));
					String line = null;
					while ((line = bReader.readLine()) != null) {
						stringBuilder.append(line + "\n");
					}
					param = stringBuilder.toString();
					log.debug("param ==> ");
					log.debug(param);
					log.debug("param <== ");
					jsonObj = (JSONObject) JSONObject.fromObject(param);
//					JSONParser parser  = new JSONParser();
//					jsonObj = (JSONObject) parser.parse(param);
					log.debug("jsonObj ==> ");
					log.debug(jsonObj.toString());
					log.debug("jsonObj <== ");
				} else {
					log.info("connection.getResponseMessage()=" + connection.getResponseMessage());
				}
			}

		} catch (IOException ioe) {
			return null;
		} catch (Exception e) {
			return null;
		} finally {
			if (bReader != null)
				bReader.close();
			if (writer != null)
				writer.close();
			if (os != null)
				os.close();
		}

		return jsonObj;
	}
	

}
