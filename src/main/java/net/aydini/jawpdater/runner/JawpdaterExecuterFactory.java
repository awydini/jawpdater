package net.aydini.jawpdater.runner;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.aydini.jawpdater.config.JawpdaterProperties;
import net.aydini.jawpdater.util.UserOs;

@Slf4j
@Service
@RequiredArgsConstructor
public class JawpdaterExecuterFactory {

	private final JawpdaterProperties jawpdaterProperties;

	private final UserOs userOs = new UserOs();


	public JawpdaterExecuter getJawpdaterExecuter() {

		log.info("creating starter for os {}",userOs.getOsName());
			if (userOs.isMac())
				return new MacScriptRunner(jawpdaterProperties);
			else if (userOs.isUnix())
				return new LinuxScriptRunner(jawpdaterProperties);
			else if (userOs.isWindows())
				return new LinuxScriptRunner(jawpdaterProperties);
			throw new RuntimeException("unknown Os");
	}
}
