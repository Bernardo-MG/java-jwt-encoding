
package com.bernardomg.jwt.encoding.test.unit.jjwt;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.bernardomg.jwt.encoding.jjwt.JjwtTokenValidator;
import com.bernardomg.jwt.encoding.test.config.factory.JwtTokens;
import com.bernardomg.jwt.encoding.test.config.factory.Tokens;

@DisplayName("JjwtTokenValidator - is in future")
class TestJjwtTokenValidatorIsFuture {

    private final JjwtTokenValidator validator = new JjwtTokenValidator(Tokens.KEY);

    @Test
    @DisplayName("When there is no before, it is not in the future")
    void testIsInFuture_NoNotBefore() {
        final Boolean future;

        // WHEN
        future = validator.isInFuture(JwtTokens.WITH_ISSUER);

        // THEN
        Assertions.assertThat(future)
            .as("future")
            .isFalse();
    }

    @Test
    @DisplayName("When the not before is in the future, it is in the future")
    void testIsInFuture_NotBeforeFuture() {
        final Boolean future;

        // WHEN
        future = validator.isInFuture(JwtTokens.WITH_NOT_BEFORE_IN_FUTURE);

        // THEN
        Assertions.assertThat(future)
            .as("future")
            .isFalse();
    }

    @Test
    @DisplayName("When the not before is in the past, it is not in the future")
    void testIsInFuture_NotBeforePast() {
        final Boolean future;

        // WHEN
        future = validator.isInFuture(JwtTokens.WITH_NOT_BEFORE_IN_PAST);

        // THEN
        Assertions.assertThat(future)
            .as("future")
            .isFalse();
    }

}
