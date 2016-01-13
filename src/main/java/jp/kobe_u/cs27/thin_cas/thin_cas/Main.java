package jp.kobe_u.cs27.thin_cas.thin_cas;

public class Main {
	static EventEvaluator eventEveluator;
	public static void main(String args[]){
		eventEveluator = new EventEvaluator();
		eventEveluator.execute(1000);
	}
}
