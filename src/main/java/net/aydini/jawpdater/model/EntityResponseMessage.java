package net.aydini.jawpdater.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode(callSuper=false)
public class EntityResponseMessage<T> extends ResponseMessage
{
    private String message;
    private Integer code;
    private T result;
}