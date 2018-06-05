package org.foresee.dbs.webapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;

public class WeatherApi {

	public static void main(String[] args) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date;
		try {
			date = sdf.parse("2017-11-24 20:00:00");
			String str=sdf.format(date);
			System.out.println(str);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		try {			
			String adcode="110105";
			URL url=new URL("http://restapi.amap.com/v3/weather/weatherInfo?city="+adcode+"&key=7cf820f277d2fc23af9d0e5c8b3d8667");
			URLConnection conn = url.openConnection();
			conn.setConnectTimeout(2000);
			BufferedReader br = new BufferedReader(new InputStreamReader(  
                    conn.getInputStream(), "UTF-8"));  
            StringBuilder sb = new StringBuilder();  
            String line = null;  
            while ((line = br.readLine()) != null)  
                sb.append(line);  
            String datas = sb.toString();  
            System.out.println(datas);  
            JSONObject json=new JSONObject(datas);
            JSONArray lives=json.getJSONArray("lives");
            JSONObject live=lives.getJSONObject(0);
            System.out.println(live.getString("city")+","+live.getString("temperature"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
