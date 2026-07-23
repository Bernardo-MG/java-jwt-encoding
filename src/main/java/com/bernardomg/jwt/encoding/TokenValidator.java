
package com.bernardomg.jwt.encoding;

/**
 * Validates a JWT token.
 *
 * @author Bernardo Mart&iacute;nez Garrido
 *
 */
public interface TokenValidator {

    /**
     * Check if the token has expired.
     *
     * @param token
     *            token to validate
     * @return {@code true} if the token has expired, {@code false} otherwise
     */
    public boolean hasExpired(final JwtTokenData token);

    /**
     * Check if the token has a not before date in the future.
     *
     * @param token
     *            token to validate
     * @return {@code true} if the token has a not before date in the future, {@code false} otherwise
     */
    public boolean isInFuture(final JwtTokenData token);

}
