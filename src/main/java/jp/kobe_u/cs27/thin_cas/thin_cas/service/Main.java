package jp.kobe_u.cs27.thin_cas.thin_cas.service;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.LinkedHashMap;

import org.yaml.snakeyaml.Yaml;

public class Main {
	static EventEvaluator eventEveluator;
	static Rule rule;
	public static void main(String args[]){
		try {
			loadYaml("config.yml");
		} catch (IOException e) {
			System.out.println("Please confirm the configuration file.");
		}
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
	public static void loadYaml(String filePath) throws IOException{
		String defaultPath="config.yml";
		if(filePath == null){
			filePath = defaultPath;
		}
		Yaml yaml = new Yaml();
		File canpath = null;
		canpath = new File(filePath).getCanonicalFile();
			  /** 複数データのロード */
	   //   Map data= yaml.loadAs(ClassLoader.getSystemResources(canpath),Map.class);
		 for (Object data : yaml.loadAll(ClassLoader.getSystemResourceAsStream(filePath))) {
	           LinkedHashMap<String,String> temp = (LinkedHashMap<String, String>) data;
			   //ObjectInputStream stream = new ObjectInputStream(null);
//			   stream.readObject();
	           System.out.println(temp.get("type"));
			   switch(temp.get("type")){
//			   	"event":
//			   		break;
			   case "event":
				   Context ctx = new Context();
				   ctx.setName(temp.get("name"));
				   ctx.setUrl("url");
				   ctx.setPrevContext(false);
			    	break;
			   	default:
			    	 break;
			   }
			   
	           //if(temp.get("type").equals("event"))
	        }
		
	}
	//private setEvent()
}
