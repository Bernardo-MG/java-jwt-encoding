
package com.bernardomg.jwt.encoding.jjwt;

import java.time.Instant;

import javax.crypto.SecretKey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bernardomg.jwt.encoding.JwtTokenData;
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

    @Override
    public final boolean hasExpired(final JwtTokenData token) {
        Boolean expired;

        try {
            // Check if token is expired
            expired =token
                .isExpired();
        } catch (final JwtException e) {
            // Token parsing failed
            log.debug("Failed parsing token", e);
            expired = true;
        }

        return expired;
    }

    @Override
    public final boolean isInFuture(final JwtTokenData token) {
        final Instant now;
        Instant       notBefore;
        Boolean       future;

        now = Instant.now();
        try {
            // Check if token is expired
            notBefore = token
                .notBefore();
        } catch (final JwtException e) {
            // Token parsing failed
            log.debug("Failed parsing token", e);
            notBefore = null;
        }

        if (notBefore == null) {
            future = false;
        } else {
            future = now.isBefore(notBefore);
        }

        return future;
    }

}
