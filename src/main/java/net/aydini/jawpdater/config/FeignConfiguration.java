package net.aydini.jawpdater.config;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClientProperties.FeignClientConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import feign.Client;
import feign.Logger;
import feign.RequestInterceptor;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.codec.ErrorDecoder;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import net.aydini.jawpdater.proxy.ApplicationUpdaterProxy;

/**
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 */
@Import(FeignClientConfiguration.class)
@EnableFeignClients(basePackageClasses = ApplicationUpdaterProxy.class)
@Configuration
public class FeignConfiguration {

	
    @Bean
    public Client client() throws NoSuchAlgorithmException, 
        KeyManagementException {

        return new Client.Default(
            new NaiveSSLSocketFactory("mupra.ir"),
            new NaiveHostnameVerifier("mupra.ir"));
    }
    
	@Bean
	public Encoder encoder() {
		return new JacksonEncoder();
	}

	@Bean
	public Decoder decoder() {
		return new JacksonDecoder();
	}

	@Bean
	public Logger.Level feignLegerLevel() {
		return Logger.Level.FULL;
	}

	@Bean
	public ErrorDecoder errorDecoder() {
		return new CustomErrorDecoder();
	}

	@Bean
	public RequestInterceptor requestInterceptor() {
		return new FeignRequestInterceptor();
	}

}
