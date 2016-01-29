package jp.kobe_u.cs27.thin_cas.webapi;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import jp.kobe_u.cs27.thin_cas.thin_cas.model.MockModel;

@Path("/")
public class MockEndpoint {

	 @GET
	 @Path("/mock/{status}")
	 @Produces(MediaType.APPLICATION_XML)
	 public Response mockAlwaysTrue(@PathParam("status") String param){
		 MockModel mock = new MockModel();
		 if("true".equals(param)){
			 mock.setValue(true);
		 }else if("false".equals(false)){
			 mock.setValue(false);
		 }
		 return Response.accepted(mock).build();
	 }
}
