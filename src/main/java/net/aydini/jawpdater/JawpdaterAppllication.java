package net.aydini.jawpdater;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

import lombok.extern.slf4j.Slf4j;
import net.aydini.jawpdater.runner.JawpdaterExecuter;
import net.aydini.jawpdater.runner.JawpdaterExecuterFactory;
import net.aydini.jawpdater.service.ApplicationUpdaterService;
import net.aydini.jawpdater.util.FileUtil;

/**
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 */
@Slf4j
@SpringBootApplication
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class })
public class JawpdaterAppllication {

	@Autowired
	private ApplicationUpdaterService applicationupdaterService;

	@Autowired
	private JawpdaterExecuterFactory jawpdaterExecuterFactory;

	public static void main(String[] args) {
		SpringApplication.run(JawpdaterAppllication.class, args);
	}

	@PostConstruct
	public void launch() {

		try {
			update();
			jawpdaterExecuterFactory.getJawpdaterExecuter().executeApplication();
		} catch (Exception e) {
			log.info(e.getMessage());
		}
	}

	public void update() {
		JawpdaterExecuter jawpdaterExecutor = jawpdaterExecuterFactory.getJawpdaterExecuter();
		try {
			if (!applicationupdaterService.isProgramUpToDate() || !FileUtil.isBinaryExist()) {
				jawpdaterExecutor.executeBackup();
				applicationupdaterService.download();
				applicationupdaterService.confirmUpdate();
				jawpdaterExecutor.executeDeleteBackup();
			}

		} catch (Exception e) {
			log.error("error updating application : {}", e.getMessage());
			jawpdaterExecutor.executeUndoBackup();
			throw new RuntimeException(e.getMessage(), e);
		}
	}
}
