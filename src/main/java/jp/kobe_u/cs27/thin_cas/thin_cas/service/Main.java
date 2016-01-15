package jp.kobe_u.cs27.thin_cas.thin_cas.service;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import org.yaml.snakeyaml.Yaml;

import com.google.gson.Gson;

public class Main {
	static EventEvaluator eventEveluator;
	static Rule rule;
	static List<Rule> ruleList = new CopyOnWriteArrayList<Rule>();
	static List<ContextPojo> eventList = new CopyOnWriteArrayList<ContextPojo>();
	static List<ContextPojo> conditionList = new CopyOnWriteArrayList<ContextPojo>();
	static List<ContextPojo> actionList = new CopyOnWriteArrayList<ContextPojo>();
	
	public static void main(String args[]) {
		try {
			loadYaml("config.yml");
		} catch (IOException e) {
			System.out.println("Please confirm the configuration file.");
		}
	}

	public static void loadYaml(String filePath) throws IOException {
		String defaultPath = "config.yml";
		if (filePath == null) {
			filePath = defaultPath;
		}
		Yaml yaml = new Yaml();
		File canpath = null;
		canpath = new File(filePath).getCanonicalFile();
		Gson gson = new Gson();		
		/** 複数データのロード */
		for (Object data : yaml.loadAll(ClassLoader.getSystemResourceAsStream(filePath))) {
			LinkedHashMap<String,String> tempMap = (LinkedHashMap<String, String>)data;
			for (Map.Entry<String, String> e : tempMap.entrySet()) {
				e.setValue("\""+e.getValue()+"\"");/*jsonでくるむために""で文字列をラップ*/
			}
			Object tempObject = tempMap.toString();
	
			String convertContextData = data.toString();
			convertContextData = convertContextData.replace("=", ":");/*jsonでマッピングするために書き換え*/
			
			ContextPojo pojo = gson.fromJson(convertContextData, ContextPojo.class);
			if(pojo.getType().equals("event")){
				eventList.add(pojo);
			}else if(pojo.getType().equals("condition")){
				conditionList.add(pojo);
			}else if(pojo.getType().equals("action")){
				conditionList.add(pojo);
			}
		}
	}
	
	
	/**
	 * event,condition,actionからECAルールを作成するメソッド
	 * @param event
	 * @param condition
	 * @param action
	 * @return
	 */
	private List<Rule> createRuleFromList(Context event, List<Context> condition, List<Context> action){
		return null;
	}
	
}
