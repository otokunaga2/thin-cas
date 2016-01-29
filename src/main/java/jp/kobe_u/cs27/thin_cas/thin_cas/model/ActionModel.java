package jp.kobe_u.cs27.thin_cas.thin_cas.model;

import javax.xml.bind.annotation.XmlRootElement;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 * コンフィグファイルからurlなど指定のデータにマッピングするためのクラス TODO: httpのバリデーションを登録時に行う
 * 
 * @author otokunaga
 *
 */
@XmlRootElement
@Entity(value = "action", noClassnameStored = true/* デフォルトの設定だとクラス名が入ってしまうことを防ぐ設定 */)
public class ActionModel {
	@Id
	private String id;

	public ActionModel() {

	}

	
	// private ArrayList<String> url;
	private String url;
	private String name;

	public ActionModel(String type, String url, String name) {
		
		if (isValidUrl(url)) {
			this.url = url;
		}

		this.name = name;
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
		String regexp = "http://";
		return true;
	}
}
