
package com.bernardomg.jwt.encoding.test.unit;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.bernardomg.jwt.encoding.JwtTokenData;
import com.bernardomg.jwt.encoding.test.config.factory.JwtTokenDatas;

@DisplayName("JwtTokenData - is before starting")
class TestJwtTokenDataIsBeforeStarting {

    @Test
    @DisplayName("When the token not before is in the past, it is not before start")
    void testIsBeforeStarting_BeforeInPast() {
        final JwtTokenData token;

        // GIVEN
        token = JwtTokenDatas.notBeforeInPast();

        // WHEN / THEN
        Assertions.assertThat(token.isBeforeStart())
            .as("before start")
            .isFalse();
    }

    @Test
    @DisplayName("When the token not before is in the future, it is before start")
    void testIsBeforeStarting_Expired() {
        final JwtTokenData token;

        // GIVEN
        token = JwtTokenDatas.notBeforeInFuture();

        // WHEN / THEN
        Assertions.assertThat(token.isBeforeStart())
            .as("before start")
            .isTrue();
    }

    @Test
    @DisplayName("When the token has no not before date, it is not before start")
    void testIsBeforeStarting_NoExpiration() {
        final JwtTokenData token;

        // GIVEN
        token = JwtTokenDatas.empty();

        // WHEN / THEN
        Assertions.assertThat(token.isBeforeStart())
            .as("before start")
            .isFalse();
    }

}
