package com.supinfo.notetonsta.parser;

import android.util.Log;
import java.net.URI;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
/**
 * @version 1.2
 * @author Charlie
 */
public abstract class Parser {

	protected static final String site = "http://10.0.2.2:8080/NoteTonSTA/ressources/";
    //protected static final String site = "http://10.0.2.2:8080/ressources/";
	protected static final String res_campus = "campus/";
	protected static final String res_intervention = "intervention/";
	protected static final String res_mark = "mark/";
	
	protected static String sendGetRequest(String address,String contentType) {
		String result = null;
		try 
		{
			HttpClient httpClient = new DefaultHttpClient();
			HttpGet httpGet = new HttpGet(new URI(address));
			httpGet.setHeader("Accept", contentType);
			HttpResponse response = httpClient.execute(httpGet);
			
			result = EntityUtils.toString(response.getEntity());
		} 
		catch (Exception e) 
		{
			Log.e("Erreur", e.getMessage(), e);
		}
		return result;
	}
	
        /**
         * 
         * @param adress
         * @param input
         * @param contentType
         * @return 
         */
	protected static boolean sendPostRequest(String adress,StringEntity input,String contentType)
	{
		try 
		{
			HttpClient httpClient = new DefaultHttpClient();
			HttpPost httpPost = new HttpPost(new URI(adress));
			httpPost.setHeader("Content-Type",contentType);
			httpPost.setHeader("Charset", "UTF-8");
			httpPost.setEntity(input);
			HttpResponse response = httpClient.execute(httpPost);
			
			if(response.getStatusLine().getStatusCode() != 201)
				throw new Exception("Code : " + response.getStatusLine().getStatusCode() + " ." + response.getStatusLine().getReasonPhrase() );
			else
				return true;
		} 
		catch (Exception e) 
		{
			Log.e("Erreur", e.getMessage(), e);
			return false;
		}
	}

}
