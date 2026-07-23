
package com.bernardomg.jwt.encoding;

import java.time.Instant;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * JWT token data.
 *
 * @author Bernardo Mart&iacute;nez Garrido
 *
 */
public record JwtTokenData(String id, String subject, String issuer, Instant issuedAt, Instant notBefore,
        Instant expiration, Collection<String> audience, Map<String, List<String>> permissions) {

    /**
     * Logger for the class.
     */
    private static final Logger log = LoggerFactory.getLogger(JwtTokenData.class);

    public JwtTokenData(final String id, final String subject, final String issuer, final Instant issuedAt,
            final Instant notBefore, final Instant expiration, final Collection<String> audience,
            final Map<String, List<String>> permissions) {
        // TODO: reject nulls, use optionals

        this.id = id;
        this.subject = subject;
        this.issuer = issuer;
        this.issuedAt = issuedAt;
        this.notBefore = notBefore;
        this.expiration = expiration;

        if (audience == null) {
            this.audience = List.of();
        } else {
            this.audience = List.copyOf(audience);
        }

        if (permissions == null) {
            this.permissions = Map.of();
        } else {
            this.permissions = permissions.entrySet()
                .stream()
                .collect(Collectors.toUnmodifiableMap(Map.Entry::getKey, e -> List.copyOf(e.getValue())));
        }
    }

    /**
     * Returns if the token is expired.
     *
     * @return {@code true} if the token is expired, {@code false} otherwise
     */
    public final boolean isExpired() {
        final Instant current;
        final boolean expired;

        // TODO: test this
        if (expiration != null) {
            // Compare expiration to current date
            current = Instant.now();
            expired = expiration.isBefore(current);
            log.debug("Expired '{}' as token expires on {}, and the current date is {}.", expired, expiration, current);
        } else {
            // No expiration
            expired = false;
            log.debug("The token has no expiration date");
        }

        return expired;
    }

    /**
     * Returns if the token is in the future.
     *
     * @return {@code true} if the token is expired, {@code false} otherwise
     */
    public final boolean isInFuture() {
        final Instant current;
        final boolean expired;

        // TODO: test this
        if (expiration != null) {
            // Compare expiration to current date
            current = Instant.now();
            expired = expiration.isBefore(current);
            log.debug("Expired '{}' as token expires on {}, and the current date is {}.", expired, expiration, current);
        } else {
            // No expiration
            expired = false;
            log.debug("The token has no expiration date");
        }

        return expired;
    }

}
