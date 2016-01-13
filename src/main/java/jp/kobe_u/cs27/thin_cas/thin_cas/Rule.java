package jp.kobe_u.cs27.thin_cas.thin_cas;

import java.util.List;
import java.util.Observable;

public class Rule implements Observer {
	private String name;
	private Context event;
	private List<Context> condition;
	private List<Context> action;
	public void notify(Rule rule){
		
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
	@Override
	public void update(Rule rule) {
		// TODO Auto-generated method stub
		
	}
}
