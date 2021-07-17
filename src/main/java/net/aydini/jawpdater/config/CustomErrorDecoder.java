package net.aydini.jawpdater.config;


import java.util.Optional;

import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import net.aydini.jawpdater.exception.FeignClientException;
import net.aydini.jawpdater.model.ResponseMessage;
import net.aydini.jawpdater.util.ResponseUtil;

/**
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 */
@Slf4j
public class CustomErrorDecoder implements ErrorDecoder
{
    
    @Override
    public Exception decode(String methodKey, Response response)
    {
        if (response == null) return new FeignClientException(new ResponseMessage("unexpected error",-100), "error in " + methodKey);

        log.error("response {}", response.toString());
        Optional<String> optionalError = ResponseUtil.extractError(response);
        optionalError.ifPresent(error->log.error("message : {}",error));
        return new FeignClientException(new ResponseMessage(response.reason(), response.status()), optionalError.orElse("unexpected error"));
    }

}