package com.ashrafwebdev.loganalyzer;
public class LogParser{

    public String extractIpAddress(String line){
        String[] parts = line.split(" ");
        return parts[0];
    }

    public int textToNumber(String text){
        return Integer.parseInt(text);
    }

    public String[] extractRequestParts(String line){
        String[] bySections = line.split("\"");
        String request = bySections[1];
        return request.split(" ");


    }

    public String[] extractStatusAndBytes(String line){
        String[] bySections = line.split("\"");
        String statusAndBytes = bySections[2].trim();
        return statusAndBytes.split(" ");
    }
}