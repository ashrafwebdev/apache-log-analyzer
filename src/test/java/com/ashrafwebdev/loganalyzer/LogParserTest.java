package com.ashrafwebdev.loganalyzer;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LogParserTest {

    private final LogParser parser = new LogParser();

    @Test
    void parsesAValidCombinedLogLine() {
        String line = "127.0.0.1 - frank [10/Oct/2000:13:55:36 -0700] \"GET /apache_pb.gif HTTP/1.0\" 200 2326 "
                + "\"http://www.example.com/start.html\" \"Mozilla/4.08 [en] (Win98; I ;Nav)\"";

        Optional<LogEntry> result = parser.parseLine(line);

        assertTrue(result.isPresent());
        LogEntry entry = result.get();
        assertEquals("127.0.0.1", entry.ipAddress());
        assertEquals("GET", entry.method());
        assertEquals("/apache_pb.gif", entry.path());
        assertEquals("HTTP/1.0", entry.protocol());
        assertEquals(200, entry.statusCode());
        assertEquals(2326, entry.bytesSent());
    }

    @Test
    void treatsADashByteCountAsZero() {
        String line = "10.0.0.5 - - [11/Oct/2000:00:01:02 -0700] \"GET /favicon.ico HTTP/1.1\" 404 - \"-\" \"-\"";

        Optional<LogEntry> result = parser.parseLine(line);

        assertTrue(result.isPresent());
        assertEquals(0, result.get().bytesSent());
    }

    @Test
    void returnsEmptyForAMalformedLine() {
        Optional<LogEntry> result = parser.parseLine("this is not a log line");

        assertTrue(result.isEmpty());
    }
}
