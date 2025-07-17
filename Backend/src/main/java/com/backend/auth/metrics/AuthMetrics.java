package com.backend.auth.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.springframework.stereotype.Component;

@Component
public class AuthMetrics {
    public final Counter loginSuccess;
    public final Counter loginNotFound;
    public final Counter loginError;
    public final Timer loginTimer;

    public AuthMetrics(MeterRegistry meterRegistry) {
        this.loginSuccess = Counter.builder("auth_login_success").register( meterRegistry);
        this.loginNotFound = Counter.builder("auth_login_failed").register( meterRegistry);
        this.loginError = Counter.builder("auth_login_error").register( meterRegistry);
        this.loginTimer = Timer.builder("auth_login_timer").register( meterRegistry);
    }
}
