package jp.kobe_u.cs27.thin_cas.thin_cas.service;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;

public class EvaluationEngine extends TimerTask {

	
	private List<Rule> observer;
	private static EvaluationEngine self = new EvaluationEngine();
	public EvaluationEngine() {
		observer = new CopyOnWriteArrayList<Rule>();
	}
	public void addRule(Rule e){
		observer.add(e);
	}
	/**
	 * @return
	 */
	public List<Rule> getCurrentObservalList(){
		final List<Rule> copyList = observer;
		
		return copyList;
	}
	
	
	public  void execute(long interval){
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(this, 0, interval);	
	}
	@Override
	public void run() {
		for(Rule e: observer){
			Context event = e.getEvent();
			boolean currentResult = event.eval();
			boolean previousContext = event.isPrevContext();
			boolean result = judgeContext(event,currentResult,previousContext);
			if(result){
				System.out.println("event & condition satisfied");
				e.update(e);
			}
		}
	}
	
	/*should private*/
	public boolean judgeContext(Context event, boolean currentResult, boolean previousContext) {
		event.setPrevContext(currentResult);
		if(currentResult == true && previousContext == false){
			return true;
		}
		return false;
	}
	
}
