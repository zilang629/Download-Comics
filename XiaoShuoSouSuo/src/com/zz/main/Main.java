package com.zz.main;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Main {

	/**
	 * @param args
	 * @throws UnsupportedEncodingException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		MyHttpClient myhhtpclient = new MyHttpClient();
		String count = myhhtpclient.get("http://38.103.161.139/forum/forum-279-1.html");
		Document doc = Jsoup.parse(count);
		//System.out.println(doc);
		int numcount = Integer.parseInt(doc.getElementsByClass("last").get(0).text().replace("... ", ""));
		for(int j = 0 ; j < numcount ;j++){
			Elements links = doc.getElementsByClass("next");
			String nexturl = "http://38.103.161.162/forum/"+"forum-279-"+(j+1)+".html";
			count = myhhtpclient.get(nexturl);
			doc = Jsoup.parse(count);
			Elements linkss = doc.select("span>a");
			for(Element link : linkss){
				//System.out.println(link);
				//String str = link.text();
				//System.out.println(link.text());
				if(link.text().indexOf("我爱曹仁妻") != -1){
					System.out.println(link.text()+"***"+"http://38.103.161.139/forum/"+link.attr("href"));
					//break;
				}
			}
		}
	}
	/*public static void main(String[] args) throws IOException {
		List<String> list = geturls("e://1.txt");
		List inList = new ArrayList();
		String str = "";
		for(int  i = 0 ; i < list.size() ; i++){
			if(i%80 == 0 && i != 0){
				str+="\n";
				inList.add(str);
				str = "";
			}else{
				str += list.get(i).toString()+" ";
			}
		}
		System.out.println(inList.get(2).toString());
		
	}
	public static List<String> geturls(String url) throws IOException{
		List<String> list = new ArrayList<String>();
		FileInputStream inputStream = new FileInputStream(url);
		BufferedReader dr = new BufferedReader(new InputStreamReader(inputStream,"GBK"));
		String str = "";						
		while((str = dr.readLine())!=null){
			list.add(str);
		}
		return list;
	}
	
	public static void In(String url,List list) throws IOException{
		FileOutputStream outputStream = new FileOutputStream(new File(url));
		BufferedWriter  dr = new BufferedWriter (new OutputStreamWriter(outputStream));
		for(int i = 0 ; i < list.size() ; i++){
			dr.write(list.get(i).toString());
			dr.flush();
		}	
		dr.close();
		outputStream.close();
	}*/
	
	

}
