
package com.bernardomg.jwt.encoding.jjwt;

import javax.crypto.SecretKey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bernardomg.jwt.encoding.TokenDecoder;
import com.bernardomg.jwt.encoding.TokenValidator;

import io.jsonwebtoken.JwtException;

/**
 * Token validator based on the JJWT library.
 *
 * @author Bernardo Mart&iacute;nez Garrido
 *
 */
public final class JjwtTokenValidator implements TokenValidator {

    /**
     * Logger for the class.
     */
    private static final Logger log = LoggerFactory.getLogger(JjwtTokenValidator.class);

    /**
     * Token decoder. Without this the token claims can't be validated.
     */
    private final TokenDecoder  tokenDecoder;

    /**
     * Constructs a validator with the received arguments.
     *
     * @param secretKey
     *            secret key used for the token
     */
    public JjwtTokenValidator(final SecretKey secretKey) {
        super();

        tokenDecoder = new JjwtTokenDecoder(secretKey);
    }

    @Override
    public final boolean hasExpired(final String token) {
        Boolean expired;

        try {
            // Check if token is expired
            expired = tokenDecoder.decode(token)
                .isExpired();
        } catch (final JwtException e) {
            // Token parsing failed
            log.debug("Failed parsing token", e);
            expired = true;
        }

        return expired;
    }

}
