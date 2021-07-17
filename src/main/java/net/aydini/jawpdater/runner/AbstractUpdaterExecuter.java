package net.aydini.jawpdater.runner;

/**
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 */

public abstract class AbstractUpdaterExecuter extends ScriptExecuter implements JawpdaterExecuter {


	protected abstract String getExecuteBackupScript();
	
	protected abstract String getExecuteDeleteBackup();
	
	protected abstract String getExecuteUndoBackup();
	
	protected abstract String getExecuteApplication();

	@Override
	public final void executeBackup() {
		execute(getExecuteBackupScript());
	}

	@Override
	public final void executeDeleteBackup() {
		execute(getExecuteDeleteBackup());
	}

	@Override
	public final void executeUndoBackup() {
		execute(getExecuteUndoBackup());
		
	}

	@Override
	public final  void executeApplication() {
		execute(getExecuteApplication());
	}
	
}
