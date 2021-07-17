package net.aydini.jawpdater.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import net.aydini.jawpdater.util.UserOs;

/**
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 */
public class MerchantConfig {

	private static String merchantId;

	public static String getMerchantId() {
		if (merchantId == null)
			setMerchantId();
		return merchantId;
	}

	private static void setMerchantId() {
		Properties prop = new Properties();
		try (InputStream input = new FileInputStream("conf"+ new UserOs().getPathSeperator() + "conf.properties")) {
			prop.load(input);
			merchantId = prop.getProperty("merchantId");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}
