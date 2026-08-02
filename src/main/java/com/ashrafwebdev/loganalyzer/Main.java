package com.ashrafwebdev.loganalyzer;

public class Main{

    public static void main(String[] args){
        String sampleLine = "127.0.0.1 - frank [10/Oct/2000:13:55:36 -0700] \"GET /apache_pb.gif HTTP/1.0\" 200 2326";
        LogParser parser = new LogParser();
        String ip = parser.extractIpAddress(sampleLine);
        System.out.println(ip);

        String[] requestParts = parser.extractRequestParts(sampleLine);
        System.out.println(requestParts[0]); // Method
        System.out.println(requestParts[1]); // Path

    }
}