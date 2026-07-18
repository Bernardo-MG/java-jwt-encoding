
package com.bernardomg.jwt.encoding;

/**
 * Creates a JWT token from a {@link JwtTokenData}.
 *
 * @author Bernardo Mart&iacute;nez Garrido
 */
public interface TokenEncoder {

    /**
     * Returns a JWT token encoding the {@code JwtTokenData}.
     *
     * @param data
     *            data to encode into the token
     * @return token decoded from the {@code JwtTokenData}
     */
    public String encode(final JwtTokenData data);

}
