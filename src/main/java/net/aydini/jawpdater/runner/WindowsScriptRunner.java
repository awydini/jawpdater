package net.aydini.jawpdater.runner;

import net.aydini.jawpdater.config.JawpdaterProperties;

/**
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 */

public class WindowsScriptRunner extends AbstractUpdaterExecuter{

	private final JawpdaterProperties jawpdaterProperties;
	
	WindowsScriptRunner(JawpdaterProperties jawpdaterProperties) {
		this.jawpdaterProperties = jawpdaterProperties;
	}

	@Override
	protected String getExecuteBackupScript() {
		return jawpdaterProperties.getWindowsBackupScript();
	}

	@Override
	protected String getExecuteDeleteBackup() {
		return jawpdaterProperties.getWindowsDeleteBackupScript();
	}

	@Override
	protected String getExecuteUndoBackup() {
		return jawpdaterProperties.getWindowsUndoBackupScript();
	}

	@Override
	protected String getExecuteApplication() {
		return jawpdaterProperties.getWindowsRunApplicationScript();
	}

}
