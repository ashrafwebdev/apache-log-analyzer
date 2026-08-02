package com.ashrafwebdev.loganalyzer;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Parses lines in the Apache "combined" access log format:
 * {@code %h %l %u %t "%r" %>s %b "%{Referer}i" "%{User-agent}i"}
 */
public class LogParser {

    private static final Pattern COMBINED_LOG_PATTERN = Pattern.compile(
            "^(\\S+) \\S+ \\S+ \\[([^\\]]+)] \"(\\S+) (\\S+) (\\S+)\" (\\d{3}) (\\d+|-).*$"
    );

    private static final DateTimeFormatter APACHE_TIMESTAMP_FORMAT =
            DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss Z", Locale.ENGLISH);

    public Optional<LogEntry> parseLine(String line) {
        Matcher matcher = COMBINED_LOG_PATTERN.matcher(line);
        if (!matcher.matches()) {
            return Optional.empty();
        }

        String ipAddress = matcher.group(1);
        OffsetDateTime timestamp = OffsetDateTime.parse(matcher.group(2), APACHE_TIMESTAMP_FORMAT);
        String method = matcher.group(3);
        String path = matcher.group(4);
        String protocol = matcher.group(5);
        int statusCode = Integer.parseInt(matcher.group(6));
        String bytesField = matcher.group(7);
        long bytesSent = bytesField.equals("-") ? 0 : Long.parseLong(bytesField);

        return Optional.of(new LogEntry(ipAddress, timestamp, method, path, protocol, statusCode, bytesSent));
    }
}
