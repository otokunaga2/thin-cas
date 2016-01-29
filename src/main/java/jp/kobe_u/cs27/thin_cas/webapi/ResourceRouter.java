package jp.kobe_u.cs27.thin_cas.webapi;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

public class ResourceRouter extends Application{
	/*エンドポイントの設定*/
	public Set<Class<?>> getClasses(){
        Set<Class<?>> s = new HashSet<Class<?>>();
        s.add(HttpEndpoint.class);
        s.add(MockEndpoint.class);
		return s;
	}
}
