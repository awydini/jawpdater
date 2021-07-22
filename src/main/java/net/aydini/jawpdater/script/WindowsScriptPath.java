package net.aydini.jawpdater.script;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import net.aydini.jawpdater.config.JawpdaterProperties;

/**
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 */


@Service
@RequiredArgsConstructor
public class WindowsScriptPath  implements ScriptPath{

	
	private final JawpdaterProperties jawpdaterProperties;
	
	
	@Override
	public String getExecuteBackupScript() {
		return jawpdaterProperties.getWindowsBackupScript();
	}

	@Override
	public String getExecuteDeleteBackup() {
		return jawpdaterProperties.getWindowsDeleteBackupScript();
	}

	@Override
	public String getExecuteUndoBackup() {
		return jawpdaterProperties.getWindowsUndoBackupScript();
	}

	@Override
	public String getExecuteApplication() {
		return jawpdaterProperties.getWindowsRunApplicationScript();
	}

}
