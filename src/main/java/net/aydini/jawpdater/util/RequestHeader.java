package net.aydini.jawpdater.util;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;


public class RequestHeader
{

    
    private final static String CONTENT_TYPE = "Content-Type";

    private final static String AUTHORIZATION = "Authorization";
    

    private Map<String, String> headers;

    public RequestHeader()
    {
        headers = new HashMap<>();
    }

    public RequestHeader setApplicationJsonContentType()
    {
        if (headers.get(CONTENT_TYPE) == null) headers.put(CONTENT_TYPE, "application/json");
        return this;
    }

    public RequestHeader setApplicationXmlContentType()
    {
        if (headers.get(CONTENT_TYPE) == null) headers.put(CONTENT_TYPE, "application/json");
        return this;
    }

    public RequestHeader setAuthorizationToken()
    {
        headers.put(AUTHORIZATION, "Basic YXBpOm11cHJhIzEyM0A=");
        return this;
    }
    
    
    public RequestHeader setCustomHeader(String key , String value)
    {
        headers.put(key, value);
        return this;
    }
    
    public RequestHeader setBasicAuthenticationHeader(String username , String password)
    {
        String auth = username + ":" +password;
        headers.put(AUTHORIZATION, "Basic " + Base64.getEncoder().encodeToString(auth.getBytes()));
        return this;
    }
    public Map<String, String> getHeaders()
    {
        return new HashMap<>(headers);
    }
}