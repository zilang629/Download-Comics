package com.zz.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.SSLContext;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;





public class Test {

	/**
	 * @param args
	 * @throws NoSuchAlgorithmException 
	 * @throws KeyManagementException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws NoSuchAlgorithmException, KeyManagementException, IOException {
		// TODO Auto-generated method stub
		List<String> allUrl = getAllUrl("https://www.dxp1230.com/e/action/ShowInfo.php?classid=1&id=5595&page=0");
		File file = new File("E:\\1\\");
		if(!file.exists()) {
			System.out.println("cread new file"+file.mkdirs());
		}
		int fileNum = 0;
		for(int i = 0 ; i < allUrl.size() ; i++) {
			System.out.println("all is "+allUrl.size()+"this is"+(i+1)+"page");
			List<String> imgUrl = getImgUrl(allUrl.get(i));
			for(int k = 0 ; k < imgUrl.size() ; k++) {
				System.out.println("download"+k+"star");
				downByUrl(imgUrl.get(k),fileNum++);
			}
		}
		
		
		
		
	}
	
	public static List<String> getImgUrl(String url){
		List<String> list = new ArrayList<String>();
		MyHttpClient myhhtpclient = new MyHttpClient();
		String count = myhhtpclient.get(url);
		Document doc = Jsoup.parse(count);
		Elements linkss = doc.getElementsByClass("entry").select("img");
		for(Element link : linkss){
			//System.out.println(link.attr("src"));
			list.add(link.attr("src"));
		}
		return list;
	}
	
	public static List<String> getAllUrl(String url) {
		List<String> list = new ArrayList<String>();
		MyHttpClient myhhtpclient = new MyHttpClient();
		String count = myhhtpclient.get(url);
		Document doc = Jsoup.parse(count);
		int pageNum  = doc.getElementsByClass("pageLink").select("a").size();
		Element link = doc.getElementsByClass("pageLink").select("a").get(pageNum-1);
		String lastpage = "https://www.dxp1230.com/"+link.attr("href");
		url = lastpage.substring(0,lastpage.indexOf("&page=")+6);
		int endNum = Integer.parseInt(lastpage.substring(lastpage.indexOf("&page=")+6));
		for(int i = 0 ; i <= endNum ; i++) {
			String imageUrl = url + i;
			list.add(imageUrl);
		}
		return list;
	}
	
	
	public static void downByUrl(String imgUrl,int fileNum) throws NoSuchAlgorithmException, KeyManagementException{
		SSLContext sc = SSLContext.getInstance("TLSv1.2");
	    sc.init(null, null, null);
	    SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sc);
		HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
		CloseableHttpClient httpclient = httpClientBuilder.setSSLSocketFactory(sslsf).build();
		HttpGet httpget = new HttpGet(imgUrl);
		HttpHost proxy = new HttpHost("127.0.0.1", 1080);
		RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(50000)
                .setConnectionRequestTimeout(50000).setProxy(proxy)
                .build(); 
		httpget.setConfig(requestConfig);
		CloseableHttpResponse response = null;
		HttpEntity entity = null ;
		BufferedReader br = null;
		InputStream is = null;
		try {
			response = httpclient.execute(httpget);
			entity = response.getEntity();
			is = entity.getContent();
			//String fileName = imgUrl.split("/")[imgUrl.split("/").length-1];
			OutputStream outStream = new FileOutputStream("E:\\1\\"+fileNum+".jpg");
			IOUtils.copy(is, outStream);
			outStream.close();
			is.close();
			response.close();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
