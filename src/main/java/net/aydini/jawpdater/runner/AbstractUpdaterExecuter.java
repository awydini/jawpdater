package net.aydini.jawpdater.runner;

import net.aydini.jawpdater.script.ScriptPath;

/**
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 */

public abstract class AbstractUpdaterExecuter extends ScriptExecuter implements JawpdaterExecuter {

	protected abstract ScriptPath getScriptPath();


	@Override
	public final void executeBackup() {
		execute(getScriptPath().getExecuteBackupScript());
	}

	@Override
	public final void executeDeleteBackup() {
		execute(getScriptPath().getExecuteDeleteBackup());
	}

	@Override
	public final void executeUndoBackup() {
		execute(getScriptPath().getExecuteUndoBackup());

	}

	@Override
	public final void executeApplication() {
		execute(getScriptPath().getExecuteApplication());
	}

}
