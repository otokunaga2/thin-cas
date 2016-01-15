package jp.kobe_u.cs27.thin_cas.thin_cas.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;

import jp.kobe_u.cs27.thin_cas.thin_cas.util.HttpHelper;

public class Context {
	private String url;
	private String name="default";
	private boolean prevContext;
	private HttpHelper helper;
	private final String tagName = "value";
	public Context(String name, String url){
		this.name = name;
		this.url = url;
		this.prevContext = false;/*初期はfalseに設定*/
		helper = new HttpHelper();
	}
	
	/**
	 * getを実行するメソッド
	 * @throws IOException
	 */
	public void doGET() throws IOException {
		System.out.println("fired");
        URL obj = new URL(this.url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        //con.setRequestProperty("User-Agent", USER_AGENT);
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
 
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
 
            // print result
            System.out.println(response.toString());
        } else {
            System.out.println("GET request not worked");
        }
 
    }
	
	public boolean parseHttpEndpoint(){
		Document document = null;
		Connection.Response resp = null;
		if(this.url == null){
			return false;/*safetyに倒す(urlを入力していない場合は実行されない)*/
		}
		Connection con = Jsoup.connect(this.url).userAgent("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/535.21 (KHTML, like Gecko) Chrome/19.0.1042.0 Safari/535.21").timeout(100000);
	    	try {
				document = con.ignoreHttpErrors(true).parser(Parser.xmlParser()).get();
				
			}catch(SocketTimeoutException e){
				e.printStackTrace();
			}catch (HttpStatusException e){
				e.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			/**
			 * todo タグ名は柔軟にやりたい
			 * 
			 */
			Element element;
			try{
				element = document.getElementById(tagName);
			}catch(NullPointerException e){
				e.printStackTrace();
			}
			String resultVal = null;
			for(Element e: document.select(tagName)){
				resultVal = e.text();
			}
			boolean result = Boolean.parseBoolean(resultVal);
			return result;
	}
	


	
	
	public boolean eval(){
		boolean result = helper.parseHttpEndpoint(this.url);
		
		return result;
	}
	public boolean isPrevContext() {
		return prevContext;
	}
	public void setPrevContext(boolean prevContext) {
		this.prevContext = prevContext;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
