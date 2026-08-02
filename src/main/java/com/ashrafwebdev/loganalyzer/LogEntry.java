package com.ashrafwebdev.loganalyzer;
public record LogEntry(
    String ipAddress,
    String method,
    String path,
    int statusCode,
    long bytesSent

){

}