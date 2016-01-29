package jp.kobe_u.cs27.thin_cas.thin_cas.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MockModel {
	public MockModel(){
		
	}
	public boolean isValue() {
		return value;
	}
	public void setValue(boolean value) {
		this.value = value;
	}
	private boolean value = false;
}
