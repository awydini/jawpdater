package net.aydini.jawpdater.runner;

import java.io.File;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;
import net.aydini.jawpdater.script.ScriptPath;
import net.aydini.jawpdater.util.UserOs;

/**
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 */

@Slf4j
public abstract class AbstractUpdaterExecuter extends ScriptExecuter implements JawpdaterExecuter {


	protected abstract ScriptPath getScriptPath();
	
	protected abstract CommandExecuter getCommandExecuter(final File scriptFile ); 

	@Override
	public final void executeBackup() {
		execute(createCommandExecuter(getScriptPath().getExecuteBackupScript()));
	}

	@Override
	public final void executeDeleteBackup() {
		execute(createCommandExecuter(getScriptPath().getExecuteDeleteBackup()));
	}

	@Override
	public final void executeUndoBackup() {
		execute(createCommandExecuter(getScriptPath().getExecuteUndoBackup()));
		
	}

	@Override
	public final  void executeApplication() {
		execute(createCommandExecuter(getScriptPath().getExecuteApplication()));
	}
	
	private CommandExecuter createCommandExecuter(final String scriptFilePath)
	{
		final File scriptFile = createExecutableScriptFile(scriptFilePath).orElseThrow(()->new RuntimeException( scriptFilePath +" file not found"));
		return getCommandExecuter(scriptFile);
	}
	
	private Optional<File> createExecutableScriptFile(String scriptFilePath)
	{
		try {
		File file = new File("bin"+ new UserOs().getPathSeperator()+scriptFilePath);
		file.setExecutable(true, false);
		log.info(file.getAbsolutePath());
		return Optional.of(file);
		} catch (final Exception e) {
			log.error("error making file executable {} ",e.getMessage());
		}
		return Optional.empty();
	}
}
