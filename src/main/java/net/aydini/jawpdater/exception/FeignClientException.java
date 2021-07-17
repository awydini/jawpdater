package net.aydini.jawpdater.exception;


import lombok.Getter;
import net.aydini.jawpdater.model.ResponseMessage;

/**
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 * Mar 23, 2021
 */
@Getter
public class FeignClientException extends RuntimeException
{

    /**
     * 
     */
    private static final long serialVersionUID = -7713518770674040084L;

    private ResponseMessage errorMessage;

    private String message;
    
    
    public FeignClientException(Throwable throwable, ResponseMessage errorMessage, String message)
    {
        super(throwable);
        this.message = message;
        this.errorMessage = errorMessage;
    }
    
    
    public FeignClientException(Throwable throwable, String message)
    {
        super(throwable);
        this.message = message;
    }

    public FeignClientException(String message)
    {
        this.message = message;
    }

    public FeignClientException(ResponseMessage errorMessage, String message)
    {
        this.errorMessage = errorMessage;
        this.message = message;
    }
}