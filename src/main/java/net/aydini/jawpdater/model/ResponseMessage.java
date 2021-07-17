package net.aydini.jawpdater.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 * Mar 23, 2021
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseMessage
{
    private String message;
    private Integer code;

}