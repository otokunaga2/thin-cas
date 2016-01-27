package jp.kobe_u.cs27.thin_cas.thin_cas.service;

import java.io.IOException;
import java.util.List;
import java.util.Observable;

import javax.xml.bind.annotation.XmlRootElement;

import jp.kobe_u.cs27.thin_cas.thin_cas.util.HttpHelper;
@XmlRootElement
public class Rule implements Observer {
	private String name;
	private Context event;
	private List<Context> condition;
	private List<Context> action;
	
	
	public Rule(){
		
	}
	public Rule(Context event, List<Context> condition, List<Context> action){
		this.event = event;
		this.condition = condition;
		this.action = action;
		
	}
	public void notify(Rule rule){
		
	}
	@Override
	public void update(Rule rule) {
		if(action != null)
		{
			if(checkCondition()){
				for(Context acionElement: action){
					try {
						acionElement.doGET();/*getで実行する*/
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		}
		
		
	}
	
	public boolean checkCondition(){
		boolean result = true;/*コンディションの初期値はtrueに設定*/
		for(Context currCondition:this.condition){
			boolean currentResult = currCondition.parseHttpEndpoint();
			result = result && currentResult;
		}
		return result;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Context getEvent() {
		return event;
	}
	public void setEvent(Context event) {
		this.event = event;
	}
	public List<Context> getCondition() {
		return condition;
	}
	public void setCondition(List<Context> condition) {
		this.condition = condition;
	}
	public List<Context> getAction() {
		return action;
	}
	public void setAction(List<Context> action) {
		this.action = action;
	}
	
}
