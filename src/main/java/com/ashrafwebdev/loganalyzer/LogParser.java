package com.ashrafwebdev.loganalyzer;
public class LogParser{

    public String extractIpAddress(String line){
        String[] parts = line.split(" ");
        return parts[0];
    }

    public int textToNumber(String text){
        return Integer.parseInt(text);
    }
}