package net.aydini.jawpdater.util;


import java.io.IOException;
import java.util.Optional;

import org.apache.commons.io.IOUtils;


import feign.Response;
import feign.form.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;
/**
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 * Mar 23, 2021
 */
@Slf4j
public class ResponseUtil
{
    public static Optional<byte[]> extractBytes(Response response)
    {
        if(response == null || response.body() == null)
            return Optional.empty();
        try
        {
            return Optional.of(IOUtils.toByteArray(response.body().asInputStream()));
        }
        catch (IOException e)
        {
            log.error("error reading response : {} ",e.getMessage());
            e.printStackTrace();
        }
        return Optional.empty();
    }
    
    public static Optional<String> extractString(Response response)
    {
        if(response == null || response.body() == null )
            return Optional.empty();
        try
        {
            return Optional.of(new String(IOUtils.toByteArray(response.body().asInputStream()),CharsetUtil.UTF_8));
        }
        catch (IOException e)
        {
            log.error("error reading response : {} ",e.getMessage());
            e.printStackTrace();
        }
        return Optional.empty();
    }
    
    public static Optional<String> extractError(Response response)
    {
        if(response == null || response.body() == null )
            return Optional.empty();
        Optional<String> optionalBody = extractString(response);
        if(!optionalBody.isPresent())
            return Optional.empty();
        StringBuilder sb = new StringBuilder();
        sb.append(response.reason()).append("-").append(response.status()).append(":").append(optionalBody.get());
       return Optional.of(sb.toString());
    }
    
    
}