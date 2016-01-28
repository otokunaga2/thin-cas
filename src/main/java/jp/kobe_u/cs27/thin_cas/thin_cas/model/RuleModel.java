package jp.kobe_u.cs27.thin_cas.thin_cas.model;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import jp.kobe_u.cs27.thin_cas.thin_cas.service.Context;

@Entity(value="rule", noClassnameStored = true/*デフォルトの設定だとクラス名が入ってしまうことを防ぐ設定*/)
public class RuleModel {
	@Id
	private String id;
	
	public RuleModel(){
		this.condition = new CopyOnWriteArrayList<ContextPojo>();
		this.action = new CopyOnWriteArrayList<ContextPojo>();
	}
	private String name;
	private ContextPojo event;
	private List<ContextPojo> condition;
	private List<ContextPojo> action;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ContextPojo getEvent() {
		return event;
	}
	public void setEvent(ContextPojo event) {
		this.event = event;
	}
	public void setSingleCondition(ContextPojo condition){
		this.condition.add(condition);
	}
	public void setSingleAction(ContextPojo action){
		this.condition.add(action);
	}
	
	
	public List<ContextPojo> getCondition() {
		return condition;
	}
	public void setCondition(List<ContextPojo> condition) {
		this.condition = condition;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getId(){
		return this.id;
	}
	public List<ContextPojo> getAction() {
		return action;
	}
	public void setAction(List<ContextPojo> action) {
		this.action = action;
	}

	
}
