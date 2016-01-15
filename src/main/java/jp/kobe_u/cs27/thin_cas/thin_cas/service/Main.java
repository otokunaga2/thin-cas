package jp.kobe_u.cs27.thin_cas.thin_cas.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.yaml.snakeyaml.Yaml;

import javassist.Loader;

public class Main {
	static EventEvaluator eventEveluator;
	static Rule rule;
	public static void main(String args[]){
		loadYaml("conf/");
//		Context event = new Context("testEvent","http://localhost:8080/LOCS4Beacon/api/isthere?userid=tokunaga&location=entrance");
//		//Context condition = new Context("alwaysFalse","http://192.168.100.107:8080/eca-test-event/webapi/myresource/false");
//		Context action = new Context("testAction","http://192.168.0.8:8080/axis2/services/MSMService/input?str=外出フラグ&operator=miku");
//		List<Context> actionList = new CopyOnWriteArrayList<Context>();
//		List<Context> conditionList =new CopyOnWriteArrayList<Context>();
//		eventEveluator = new EventEvaluator();
//		//conditionList.add(condition);
//		actionList.add(action);
//		
//		rule = new Rule(event,conditionList,actionList);
//		
//		eventEveluator.addRule(rule);
//		eventEveluator.execute(1000);
	}
	public static void loadYaml(String filePath){
		Yaml yaml = new Yaml();
		File canpath = null;
		try {
			canpath = new File(filePath).getCanonicalFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File canpathpare = canpath.getParentFile();
		try {
			File[] file = canpathpare.listFiles();
			for(int i=0; i< file.length;i++){
				
			}
			System.out.println(canpathpare.getCanonicalPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
