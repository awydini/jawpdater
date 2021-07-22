package net.aydini.jawpdater.runner;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 */

@Slf4j
public abstract class ScriptExecuter {

	/**
	 * executes script
	 * 
	 * @param scriptFilePath
	 */
	protected void execute(final CommandExecuter commandExecuter) {
		try {
			commandExecuter.execute();
		} catch (final Exception e) {
			log.error("error starting program {} ", e.getMessage());
		}
	}
}
