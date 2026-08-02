package com.ashrafwebdev.loganalyzer;

import java.time.OffsetDateTime;

public record LogEntry(
        String ipAddress,
        OffsetDateTime timestamp,
        String method,
        String path,
        String protocol,
        int statusCode,
        long bytesSent
) {
}
