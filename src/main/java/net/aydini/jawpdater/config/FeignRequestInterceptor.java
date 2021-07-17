package net.aydini.jawpdater.config;


import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 * Mar 23, 2021
 */
@Slf4j
public class FeignRequestInterceptor implements RequestInterceptor
{
    
    @Override
    public void apply(RequestTemplate template)
    {
        log.info("----------begin request---------- ");
        log.info("request data : \n {}", template.toString());
        log.info("queries : {} ", template.queries());
        log.info("----------end request---------- ");
    }
}

