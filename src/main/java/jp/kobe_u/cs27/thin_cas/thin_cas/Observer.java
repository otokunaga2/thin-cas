package jp.kobe_u.cs27.thin_cas.thin_cas;

/**
 * @author otokunaga
 *
 */
public interface Observer {
	//public abstract void update();

	public abstract void update(Rule rule);
}
