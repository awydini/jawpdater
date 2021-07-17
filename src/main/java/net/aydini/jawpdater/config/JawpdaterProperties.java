package net.aydini.jawpdater.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 */

@Data
@Configuration
@NoArgsConstructor
@ConfigurationProperties(prefix = "jawpdater")
public class JawpdaterProperties {



	private String windowsBackupScript;

	private String windowsUndoBackupScript;

	private String windowsDeleteBackupScript;

	private String windowsRunApplicationScript;

	/**
	 * 
	 */

	private String linuxBackupScript;

	private String linuxUndoBackupScript;

	private String linuxDeleteBackupScript;

	private String linuxRunApplicationScript;

	
}
