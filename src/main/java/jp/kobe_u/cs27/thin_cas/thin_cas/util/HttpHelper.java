package jp.kobe_u.cs27.thin_cas.thin_cas.util;

import java.io.IOException;
import java.net.SocketTimeoutException;

import org.jsoup.Connection;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;

/**
 * @author otokunaga
 *
 */
public class HttpHelper {
	private boolean result = false;
	private static final String tagName = "value";


	public boolean parseHttpEndpoint(String url){
		Document document = null;
		Connection.Response resp = null;
		Connection con = Jsoup.connect(url).userAgent("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/535.21 (KHTML, like Gecko) Chrome/19.0.1042.0 Safari/535.21").timeout(100000);
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
				return false;/*tag名がnullの際にはそのままfalseを返却*/
			}
			String result = null;
			for(Element e: document.select(tagName)){
				result = e.text();
				System.out.println("obtain result->"+result);
			}
			this.result = Boolean.parseBoolean(result);
			return this.result;
	}
	
	public boolean parseHttpEndpoint(String url,String givenName){
		Document document = null;
		try {
			document = Jsoup.connect(url).parser(Parser.xmlParser()).get();
		}catch(SocketTimeoutException e){
			return false;
		}catch (HttpStatusException e){
			e.printStackTrace();
			return false;
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		} finally {
			
		}
		/**
		 * todo タグ名は柔軟にやりたい
		 * 
		 */
		Element element;
		try{
			element = document.getElementById(givenName);
		}catch(NullPointerException e){
			e.printStackTrace();
		}
		String result = null;
		for(Element e: document.select(givenName)){
			result = e.text();
		}
		this.result = Boolean.parseBoolean(result);
		return this.result;
	}
	
	
}
