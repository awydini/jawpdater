package net.aydini.jawpdater.runner;

import java.io.File;
import java.io.IOException;

import net.aydini.jawpdater.script.ScriptPath;

/**
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 */

public class LinuxScriptRunner extends AbstractUpdaterExecuter {

	private final ScriptPath scriptPath;

	LinuxScriptRunner(ScriptPath scriptPath) {
		this.scriptPath = scriptPath;
	}

	@Override
	protected ScriptPath getScriptPath() {
		return scriptPath;
	}

	@Override
	protected CommandExecuter getCommandExecuter(File scriptFile) {
		return () -> {
			try {
				Runtime.getRuntime().exec(scriptFile.getAbsolutePath());
			} catch (IOException e) {
				e.printStackTrace();
			}
		};
	}

}
