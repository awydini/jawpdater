package net.aydini.jawpdater.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import net.aydini.jawpdater.script.ScriptPath;
import net.aydini.jawpdater.util.UserOs;

@Slf4j
@Service
public class JawpdaterExecuterFactory {


	@Autowired
	@Qualifier("windowsScriptPath")
	private ScriptPath windowsScriptPath;
	
	
	@Autowired
	@Qualifier("linuxScriptPath")
	private ScriptPath linuxScriptPath;
	
	
	@Autowired
	@Qualifier("macScriptPath")
	private ScriptPath macScriptPath;
	
	private final UserOs userOs = new UserOs();


	public JawpdaterExecuter getJawpdaterExecuter() {

		log.info("creating starter for os {}",userOs.getOsName());
			if (userOs.isMac())
				return new MacScriptRunner(macScriptPath);
			else if (userOs.isUnix())
				return new LinuxScriptRunner(linuxScriptPath);
			else if (userOs.isWindows())
				return new WindowsScriptRunner(windowsScriptPath);
			throw new RuntimeException("unknown Os");
	}
}
