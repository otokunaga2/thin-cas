package jp.kobe_u.cs27.thin_cas.webapi;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import jp.kobe_u.cs27.thin_cas.thin_cas.dao.ContextDAO;
import jp.kobe_u.cs27.thin_cas.thin_cas.dao.RuleDAO;
import jp.kobe_u.cs27.thin_cas.thin_cas.model.ContextModel;
import jp.kobe_u.cs27.thin_cas.thin_cas.model.RuleModel;
import jp.kobe_u.cs27.thin_cas.thin_cas.service.Context;
import jp.kobe_u.cs27.thin_cas.thin_cas.service.EvaluationEngine;
import jp.kobe_u.cs27.thin_cas.thin_cas.service.Rule;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/")
public class HttpEndpoint {
	private EvaluationEngine engine = new EvaluationEngine();
	private ContextDAO dao;
	private RuleDAO ruleDAO;
	public HttpEndpoint(){
		Context event = new Context();
		List<Context> ctxList = new ArrayList<Context>();
		Rule rule = new Rule();
		rule.setEvent(event);
		rule.setCondition(ctxList);
		rule.setAction(ctxList);
		engine.addRule(rule);
		dao = ContextDAO.getInstance();
		ruleDAO = RuleDAO.getInstance();
	}
    private Gson gson = new Gson();

    @GET
    @Path("/eca/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveECA(@QueryParam("event") String eventId, @QueryParam("condition") String conditionId,@QueryParam("action") String actionId) {
    	
    	ContextModel ctx = dao.findAsContextModel(eventId);
    	ContextModel condition = dao.findAsContextModel(conditionId);
    	ContextModel action = dao.findAsContextModel(actionId);
    	RuleModel rule = new RuleModel();
    	rule.setEvent(ctx);
    	rule.setSingleCondition(condition);
    	rule.setSingleAction(action);
    	String result = ruleDAO.save(rule);
    	String jsonRes = gson.toJson(result);
    	
        return Response.ok(jsonRes).build();
    }
    
    @GET
    @Path("/eca/list")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getECA() {
    	List<RuleModel> list = ruleDAO.getAllList();
    	
    	String jsonResult = gson.toJson(list);
        return Response.ok(jsonResult).build();
    }
    
    @POST
    @Path("/context")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveEvent(ContextModel ctx) {
    	System.out.println(ctx.toString());
    	dao.save(ctx);
        return Response.ok(ctx).build();
    }
    
    @POST
    @Path("/rule")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveRule(Rule rule) {
    	
    	System.out.println(rule.toString());
    	
        return Response.ok(rule).build();
    }
    
    @GET
    @Path("/context")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String saveEventAsGet(@QueryParam("type") String contextType, @QueryParam("url") String url, @QueryParam("name") String name) {
    	System.out.println(contextType);
    	System.out.println(url);
    	System.out.println(name);
    	return "Got it!";
    }
    
    
    @GET
    @Path("/context/{param}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response saveAction(ContextModel ctx,@PathParam("param") String param) {
    	List<ContextModel> ctxPojoList = dao.findWithParam(param);
    	/**
    	 * todo 指定されたパラム以外,condition,action,event以外は弾く処理を追加
    	 */
    	String jsonResult = gson.toJson(ctxPojoList);
    	
        return Response.ok(jsonResult).build();
    }
    
    /**
     * 現在の評価されているルールを取得するためのAPI
     * todo 
     * - 
     * @return
     */
    @GET
    @Path("/eca/rule")
    @Produces(MediaType.TEXT_PLAIN)
    public String getRule() {
    	List<?> runningList = engine.getCurrentObservalList();
    	String jsonElement = gson.toJson(runningList);
        return jsonElement;
    }
    
    
    
    
    
}
