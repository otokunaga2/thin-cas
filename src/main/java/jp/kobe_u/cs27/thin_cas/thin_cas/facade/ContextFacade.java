package jp.kobe_u.cs27.thin_cas.thin_cas.facade;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import jp.kobe_u.cs27.thin_cas.thin_cas.dao.ContextDAO;
import jp.kobe_u.cs27.thin_cas.thin_cas.model.ContextModel;
import jp.kobe_u.cs27.thin_cas.thin_cas.service.Context;

public class ContextFacade {
	private ContextDAO contextDAO;
	public ContextFacade(){
		contextDAO = new ContextDAO();
	}
	/**
	 * idから実際のコンテキストに変換するためのメソッド
	 * @param id
	 * @return
	 */
	public Context getContext(String id){
		ContextModel pojo = contextDAO.findAsContextModel(id);
		if(pojo == null){
			return null;
		}
		Context ctx = new Context(pojo.getType(),pojo.getName(),pojo.getUrl());
		return ctx;
	}
	
	/**
	 * @param pojo
	 * @return
	 */
	public Context convertContext(ContextModel pojo){
		Context ctx = new Context(pojo.getType(),pojo.getName(),pojo.getUrl());
		return ctx;
	}
	
	public List<Context> convertAsListFromData(List<ContextModel> modelList){
		List<Context> contextList = new CopyOnWriteArrayList<>();
		for(ContextModel tempModel:modelList){
			Context ctx = convertContext(tempModel);
			contextList.add(ctx);
		}
		return contextList;
	}
	
	
	
}
