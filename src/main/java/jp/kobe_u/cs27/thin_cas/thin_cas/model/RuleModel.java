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
		this.condition = new CopyOnWriteArrayList<ContextModel>();
		this.action = new CopyOnWriteArrayList<ContextModel>();
	}
	private String name;
	private ContextModel event;
	private List<ContextModel> condition;
	private List<ContextModel> action;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ContextModel getEvent() {
		return event;
	}
	public void setEvent(ContextModel event) {
		this.event = event;
	}
	public void setSingleCondition(ContextModel condition){
		this.condition.add(condition);
	}
	public void setSingleAction(ContextModel action){
		this.condition.add(action);
	}
	
	
	public List<ContextModel> getCondition() {
		return condition;
	}
	public void setCondition(List<ContextModel> condition) {
		this.condition = condition;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getId(){
		return this.id;
	}
	public List<ContextModel> getAction() {
		return action;
	}
	public void setAction(List<ContextModel> action) {
		this.action = action;
	}

	
}
