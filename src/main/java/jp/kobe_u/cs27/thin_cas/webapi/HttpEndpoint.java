package jp.kobe_u.cs27.thin_cas.webapi;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import jp.kobe_u.cs27.thin_cas.thin_cas.service.Context;
import jp.kobe_u.cs27.thin_cas.thin_cas.service.ContextPojo;
import jp.kobe_u.cs27.thin_cas.thin_cas.service.EvaluationEngine;
import jp.kobe_u.cs27.thin_cas.thin_cas.service.Rule;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/")
public class HttpEndpoint {
	private EvaluationEngine engine = new EvaluationEngine();
	public HttpEndpoint(){
		Context event = new Context();
		List<Context> ctxList = new ArrayList<Context>();
		Rule rule = new Rule();
		rule.setEvent(event);
		rule.setCondition(ctxList);
		rule.setAction(ctxList);
		engine.addRule(rule);
	}
    private Gson gson = new Gson();
	/**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @POST
    @Path("/event/new")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String saveEvent(String pojo) {
    	
    	
    	
        return "Got it!";
    }
    
    @GET
    @Path("/context/action")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public String saveContext(ContextPojo ctx) {
    	System.out.println(ctx.toString());
    	
        return "Got it!";
    }
    
    
    @GET
    @Path("/context/event")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String saveAction(ContextPojo ctx) {
    	engine.getCurrentObservalList();
        return "Got it!";
    }
    
    /**
     * 現在の登録されているルールを取得するためのAPI
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
