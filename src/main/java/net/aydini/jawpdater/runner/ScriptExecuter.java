package net.aydini.jawpdater.runner;

import java.io.File;
import java.util.Scanner;

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
	 */
	protected void execute(final String scriptFilePath)
	{
		executeInParallel(scriptFilePath);
		try {
			File file = new File("bin"+ new UserOs().getPathSeperator()+scriptFilePath);
			file.setExecutable(true, false);
			log.info(file.getAbsolutePath());
			Scanner sc= new Scanner(file);
			String command = sc.nextLine();
			log.info(command);
			Runtime.getRuntime().exec(command);
			sc.close();
		} catch (final Exception e) {
			log.error("error starting program {} ",e.getMessage());
		}
	}
	
	private void executeInParallel(final String scriptFilePath)
	{
		
		
	}

}
