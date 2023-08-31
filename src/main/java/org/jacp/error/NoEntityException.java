package org.jacp.error;

/**
 * @author saffchen created on 01.08.2023
 */
public class NoEntityException extends RuntimeException {
    public NoEntityException(String messageError) {
        super(messageError);
    }
}
