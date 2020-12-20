/**
 * 
 */
package com.finastra.intercashswitch.exception;

import lombok.Getter;

/**
 * @author Vipin.Mangalkar
 *
 */
public class APIException extends RuntimeException {

	private static final long serialVersionUID = 139072947003301225L;

	/**
     * see {@link ErrorDetails}
     */
    @Getter
    private final ErrorDetails error;


    /**
     * @param error OwError
     * @see RuntimeException#RuntimeException(String)
     */
    public APIException(ErrorDetails error) {
        super(error.toString());
        this.error = error;
    }

    /**
     * @param error OwError
     * @param cause the cause (which is saved for later retrieval by the
     *              {@link #getCause()} method).  (A {@code null} value is
     *              permitted, and indicates that the cause is nonexistent or
     *              unknown.)
     * @see RuntimeException#RuntimeException(String, Throwable)
     */
    public APIException(ErrorDetails error, Throwable cause) {
        super(error.toString(), cause);
        this.error = error;
    }
}
