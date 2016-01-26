package jp.kobe_u.cs27.thin_cas.thin_cas.service;

import java.util.ArrayList;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 * コンフィグファイルからurlなど指定のデータにマッピングするためのクラス TODO: httpのバリデーションを登録時に行う
 * 
 * @author otokunaga
 *
 */
@Entity(value="context", noClassnameStored = true/*デフォルトの設定だとクラス名が入ってしまうことを防ぐ設定*/)
public class ContextPojo {
	@Id
	private String id;
	
	private String type;
	// private ArrayList<String> url;
	private String url;
	private String name;

public ContextPojo(String type, String url, String name) {
	this.type = type;
	if(isValidUrl(url)){
		this.url =url;
	}
	
	this.name = name;
}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * urlが適切なものかどうかを判定するメソッド 正しくなければfaleを返す
	 * 
	 * @return
	 */
	private boolean isValidUrl(String givenUrl) {
		
		return true;
	}
}
