package net.aydini.jawpdater.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import feign.Response;
import net.aydini.jawpdater.config.MerchantConfig;
import net.aydini.jawpdater.model.EntityResponseMessage;
import net.aydini.jawpdater.proxy.ApplicationUpdaterProxy;
import net.aydini.jawpdater.util.FileUtil;
import net.aydini.jawpdater.util.RequestHeader;
import net.aydini.jawpdater.util.ResponseUtil;

/**
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 */

@Service
public class ApplicationUpdaterService {

	
	private final ApplicationUpdaterProxy updaterProxy;

	private final String applicationFileName;
	
	
	public ApplicationUpdaterService(ApplicationUpdaterProxy updaterProxy, @Value("${jawpdater.application-name}")String applicationFileName) {
		super();
		this.updaterProxy = updaterProxy;
		this.applicationFileName = applicationFileName;
	}


	public void download()
	{
		Response response = updaterProxy.download();
		Optional<byte[]> optionalContent = ResponseUtil.extractBytes(response);
		if(!optionalContent.isPresent())
			throw new RuntimeException("download failed");
		FileUtil.saveFile(optionalContent.get(), applicationFileName);
	}
	
	
	public boolean isProgramUpToDate()
	{
		EntityResponseMessage<Boolean> response = updaterProxy.updateNeeded(MerchantConfig.getMerchantId(), new RequestHeader().setApplicationJsonContentType().setAuthorizationToken().getHeaders());
		if(response == null)
			throw new RuntimeException("failed to check update status");
		return response.getResult();
	}
	
	public void confirmUpdate()
	{
		updaterProxy.confirmUpdate(MerchantConfig.getMerchantId(), new RequestHeader().setApplicationJsonContentType().setAuthorizationToken().getHeaders());
	}
}
