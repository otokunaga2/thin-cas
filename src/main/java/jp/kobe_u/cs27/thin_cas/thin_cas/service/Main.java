package jp.kobe_u.cs27.thin_cas.thin_cas.service;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.yaml.snakeyaml.Yaml;

import com.google.gson.Gson;

public class Main {
	static EvaluationEngine eventEveluator = new EvaluationEngine();
	static Rule rule;
	static List<Rule> ruleList = new CopyOnWriteArrayList<Rule>();
	static Context event = new Context();
	static List<Context> conditionList = new CopyOnWriteArrayList<>();
	static List<Context> actionList = new CopyOnWriteArrayList<>();

	public static void main(String args[]) {
		
		try {
			loadYaml("config.yml");
		} catch (IOException e) {
			System.out.println("Please confirm the configuration file.");
		}
	}

	@SuppressWarnings({ "unchecked", "unused" })
	public static void loadYaml(String filePath) throws IOException {
		String defaultPath = "config.yml";
		if (filePath == null) {
			filePath = defaultPath;
		}
		Yaml yaml = new Yaml();
		File canpath = null;
		canpath = new File(filePath).getCanonicalFile();
		Gson gson = new Gson();
		/** 複数のyamlデータをロード*/
		for (Object data : yaml.loadAll(ClassLoader.getSystemResourceAsStream(filePath))) {
			LinkedHashMap<String, String> tempMap = (LinkedHashMap<String, String>) data;
			StringBuffer buf = new StringBuffer();
			
			for (Map.Entry<String, String> e : tempMap.entrySet()) {
				e.setValue("\"" + e.getValue() + "\"");/* jsonでくるむために""で文字列をラップ */
			}
			
			Object tempObject = tempMap.toString();

			buf.append(tempObject.toString());
			
			Pattern pattern = getMatcher();
			
			
			Matcher matcher = pattern.matcher(buf);
			while(matcher.find()){
			    matcher.group(0).replaceFirst("=", ":");/*jsonに変換するためにStirngにキャストした際に=になった箇所を:に戻す作業*/
			}
			ContextPojo pojo = gson.fromJson(buf.toString(), ContextPojo.class);
			Context currentCtx = convertContextFromPojo(pojo);
			try{
				if (currentCtx.getType().equals("event")) {
					event = currentCtx;
				} else if (currentCtx.getType().equals("condition")) {
					conditionList.add(currentCtx);
				} else if (currentCtx.getType().equals("action")) {
					conditionList.add(currentCtx);
				}
			}catch(NullPointerException e){
				e.printStackTrace();
			}
			Rule newRule = createRuleFromList(event,conditionList,actionList);
			eventEveluator.addRule(newRule);
		}
		runEvaludate();
	}
	
	private static void runEvaludate() {
		// TODO Auto-generated method stub
		eventEveluator.execute(5000);
	}

	private static Pattern getMatcher(){
		String regex = "[a-zA-Z]+\\:";
		Pattern p = Pattern.compile(regex);
		return p;
	}
	
	private static Context convertContextFromPojo(ContextPojo pojo) {
		Context ctx = new Context();
		ctx.setName(pojo.getName());
		ctx.setPrevContext(false);
		
		ctx.setType(pojo.getType());
		ctx.setUrl(pojo.getUrl());
		return ctx;
	}

	/**
	 * event,condition,actionからECAルールを作成するメソッド
	 * 
	 * @param event
	 * @param condition
	 * @param action
	 * @return
	 */
	@SuppressWarnings("unused")
	private static Rule createRuleFromList(Context event, List<Context> condition, List<Context> action) {

		Rule rule = new Rule();
		rule.setEvent(event);
		rule.setEvent(event);
		rule.setCondition(conditionList);
		rule.setAction(action);
		return rule;
	}

}
