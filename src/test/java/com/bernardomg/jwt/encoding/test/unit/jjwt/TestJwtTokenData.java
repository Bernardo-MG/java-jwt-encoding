
package com.bernardomg.jwt.encoding.test.unit.jjwt;

import java.time.Instant;
import java.util.List;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.bernardomg.jwt.encoding.JwtTokenData;

@DisplayName("JwtTokenData")
class TestJwtTokenData {

    @Test
    @DisplayName("When the token is expired, it is expired")
    void testIsExpired_Expired() {
        final JwtTokenData token;

        // GIVEN
        token = new JwtTokenData(null, null, null, null, null, Instant.now()
            .minusSeconds(60), List.of(), Map.of());

        // WHEN / THEN
        Assertions.assertThat(token.isExpired())
            .as("expired")
            .isTrue();
    }

    @Test
    @DisplayName("When the token has no expiration date, it is not expired")
    void testIsExpired_NoExpiration() {
        final JwtTokenData token;

        // GIVEN
        token = new JwtTokenData(null, null, null, null, null, null, List.of(), Map.of());

        // WHEN / THEN
        Assertions.assertThat(token.isExpired())
            .as("expired")
            .isFalse();
    }

    @Test
    @DisplayName("When the token is not expired, it is not expired")
    void testIsExpired_NotExpired() {
        final JwtTokenData token;

        // GIVEN
        token = new JwtTokenData(null, null, null, null, null, Instant.now()
            .plusSeconds(60), List.of(), Map.of());

        // WHEN / THEN
        Assertions.assertThat(token.isExpired())
            .as("expired")
            .isFalse();
    }

}
