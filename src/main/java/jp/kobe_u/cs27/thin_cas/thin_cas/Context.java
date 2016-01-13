package jp.kobe_u.cs27.thin_cas.thin_cas;

public class Context {
	private String url;
	private String name;
	private boolean prevContext;
	public boolean eval(){
		return true;
	}
	public boolean isPrevContext() {
		return prevContext;
	}
	public void setPrevContext(boolean prevContext) {
		this.prevContext = prevContext;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
