package net.aydini.jawpdater.runner;

/**
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 */
public interface JawpdaterExecuter {

	
	public void executeBackup();
	
	public void executeDeleteBackup();
	
	public void executeUndoBackup();
	
	public void executeApplication();
}
