package jp.kobe_u.cs27.thin_cas.thin_cas;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;

public class EventEvaluator extends TimerTask {

	
	private List<Rule> observer;
	private static EventEvaluator self = new EventEvaluator();
	public EventEvaluator() {
		observer = new CopyOnWriteArrayList<Rule>();
	}
	public void addRule(Rule e){
		observer.add(e);
	}
	
	public  void execute(long interval){
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(this, 0, interval);	
	}
	@Override
	public void run() {
		for(Rule e: observer){
			Context event = e.getEvent();
			boolean result = event.eval();
			e.notify(e);
		}
		if(true/*event has become true*/){
			System.out.println("true");
		}
		
		
	}

}
