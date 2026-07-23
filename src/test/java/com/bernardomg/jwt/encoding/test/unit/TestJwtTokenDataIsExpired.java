
package com.bernardomg.jwt.encoding.test.unit;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.bernardomg.jwt.encoding.JwtTokenData;
import com.bernardomg.jwt.encoding.test.config.factory.JwtTokenDatas;

@DisplayName("JwtTokenData - is expired")
class TestJwtTokenDataIsExpired {

    @Test
    @DisplayName("When the token is expired, it is expired")
    void testIsExpired_Expired() {
        final JwtTokenData token;

        // GIVEN
        token = JwtTokenDatas.expired();

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
        token = JwtTokenDatas.empty();

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
        token = JwtTokenDatas.notExpired();

        // WHEN / THEN
        Assertions.assertThat(token.isExpired())
            .as("expired")
            .isFalse();
    }

}
