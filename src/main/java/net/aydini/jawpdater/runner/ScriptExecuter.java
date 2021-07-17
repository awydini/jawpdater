package net.aydini.jawpdater.runner;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.CompletableFuture;

import lombok.extern.slf4j.Slf4j;
import net.aydini.jawpdater.util.UserOs;

/**
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 */

@Slf4j
public class ScriptExecuter 
{
	
	/**
	 * executes script
	 * @param scriptFilePath
	 * @return true if executes scriptFile successfully
	 */
	protected void execute(final String scriptFilePath)
	{
		CompletableFuture.runAsync(()->executeInParallel(scriptFilePath));
	}
	
	private void executeInParallel(final String scriptFilePath)
	{
		try {
			File file = new File("bin"+ new UserOs().getPathSeperator()+scriptFilePath);
			file.setExecutable(true);
			log.info(file.getAbsolutePath());
			Process process = new ProcessBuilder(file.getAbsolutePath()).start();
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            int lineNumber = 0;
			String line;
            while ((line = reader.readLine()) != null&&lineNumber <50) {
                log.info("{} output line {} --> {}",scriptFilePath,++lineNumber,line);
            }
		} catch (final IOException e) {
			log.error("error starting program {} ",e.getMessage());
		}
		
	}

}
