package net.aydini.jawpdater.runner;

import net.aydini.jawpdater.config.JawpdaterProperties;

/**
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 */

public class LinuxScriptRunner extends AbstractUpdaterExecuter{

	private final JawpdaterProperties jawpdaterProperties;
	
	LinuxScriptRunner(JawpdaterProperties jawpdaterProperties) {
		this.jawpdaterProperties = jawpdaterProperties;
	}

	@Override
	protected String getExecuteBackupScript() {
		return jawpdaterProperties.getLinuxBackupScript();
	}

	@Override
	protected String getExecuteDeleteBackup() {
		return jawpdaterProperties.getLinuxDeleteBackupScript();
	}

	@Override
	protected String getExecuteUndoBackup() {
		return jawpdaterProperties.getLinuxUndoBackupScript();
	}

	@Override
	protected String getExecuteApplication() {
		return jawpdaterProperties.getLinuxRunApplicationScript();
	}
	

}
