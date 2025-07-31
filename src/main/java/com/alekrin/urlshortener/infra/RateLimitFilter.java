package com.alekrin.urlshortener.infra;

import io.github.bucket4j.Bucket;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Duration;

@Component
public class RateLimitFilter implements Filter {

    // bucket with capacity 20 tokens and with refilling speed 1 token per each 6 second
    private static final Bucket BUCKET = Bucket.builder()
            .addLimit(limit -> limit.capacity(20).refillGreedy(10, Duration.ofMinutes(1)))
            .build();

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        if (BUCKET.tryConsume(1)) {
            chain.doFilter(request, response); // segue o fluxo normalmente
        } else {
            HttpServletResponse httpResp = (HttpServletResponse) response;
            httpResp.setStatus(HttpStatus.TOO_MANY_REQUESTS.value());
            httpResp.getWriter().write("Too many requests - Rate limit exceeded");
        }
    }
}

