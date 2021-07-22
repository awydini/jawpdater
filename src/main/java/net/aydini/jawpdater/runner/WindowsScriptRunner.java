package net.aydini.jawpdater.runner;

import java.io.File;
import java.io.IOException;

import net.aydini.jawpdater.script.ScriptPath;

/**
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 */

public class WindowsScriptRunner extends AbstractUpdaterExecuter {

	private final ScriptPath scriptPath;

	WindowsScriptRunner(ScriptPath scriptPath) {
		this.scriptPath = scriptPath;
	}

	@Override
	protected ScriptPath getScriptPath() {
		return scriptPath;
	}

	@Override
	protected CommandExecuter getCommandExecuter(final File scriptFile) {
		return () -> {
			try {
				Runtime.getRuntime().exec("cmd /c start \"\" " + scriptFile.getAbsolutePath());
			} catch (IOException e) {
				e.printStackTrace();
			}
		};
	}

}
