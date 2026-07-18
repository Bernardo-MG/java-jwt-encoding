
package com.bernardomg.jwt.encoding;

/**
 * Creates a {@link JwtTokenData} from a JWT token.
 *
 * @author Bernardo Mart&iacute;nez Garrido
 */
public interface TokenDecoder {

    /**
     * Returns a {@code JwtTokenData} decoded from the JWT token.
     *
     * @param token
     *            token to decode
     * @return {@code JwtTokenData} decoded from the token
     */
    public JwtTokenData decode(final String token);

}
