package net.aydini.jawpdater.proxy;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import feign.Response;
import net.aydini.jawpdater.model.EntityResponseMessage;

/**
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 */


@FeignClient(name = "UPDATE-PROXY" , url = "${jawpdater.api-base-url}")
public interface ApplicationUpdaterProxy {

	@GetMapping(value = "/api/v1/printer/update/{merchantId}")
    public EntityResponseMessage<Boolean> updateNeeded(@PathVariable("merchantId") String merchantId, @RequestHeader Map<String,String> headers);
	
	@GetMapping(value = "/printerApp")
    public Response download();
	
	
	@PutMapping(value = "/api/v1/printer/update/{merchantId}")
    public void confirmUpdate(@RequestParam String merchantId , @RequestHeader Map<String, String> headers);
}
