package com.zz.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;


public class MyHttpClient {
	
	public String get(String url){
		String randomJsUrl = "";
		String count = "";
		//CloseableHttpClient httpclient = HttpClinetSoure.getConnection();
		HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
		CloseableHttpClient httpclient = httpClientBuilder.build();
		HttpHost proxy = new HttpHost("127.0.0.1", 1080);
		HttpGet httpget = new HttpGet(url);
		RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(50000)
                .setConnectionRequestTimeout(50000).setProxy(proxy)
                .build(); 
		httpget.setConfig(requestConfig);
		BufferedReader br = null;
		InputStream is = null;
		HttpEntity entity = null ;
		CloseableHttpResponse response = null;
		try {
			response = httpclient.execute(httpget);
			entity = response.getEntity();
			is = entity.getContent();
			br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			while ((randomJsUrl = br.readLine()) != null) {
				count += randomJsUrl;
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			return "";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			return "";
		}finally{
			try {
				if(br!=null)
					br.close();
				if(is!=null)
					is.close();
				if(entity!=null)
					EntityUtils.consume(entity);
				if(response!=null)
					response.close();
				if(httpclient!=null){
					httpclient.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}
		return count;
	}
	
	public void post(String url){
		
	}

}
