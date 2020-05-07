package com.example.awdb;


import com.fasterxml.jackson.databind.JsonNode;
import com.ipplus360.db.AWReader;

import java.io.File;
import java.net.InetAddress;
import java.util.Random;

public class AwdbApplication {

    public static void main(String[] args) throws Exception {
        AWReader awReader = new AWReader(new File("C:\\Users\\admin\\Desktop\\awdb-java\\IP_basic_single_WGS84.awdb"));
        String ip = getRandomIp();
        InetAddress address = InetAddress.getByName(ip);
        JsonNode record = awReader.get(address);
        System.out.println(record);
    }

    public static String getRandomIp() {
        Random random = new Random();
        int a = random.nextInt(255);
        int b = random.nextInt(255);
        int c = random.nextInt(255);
        int d = random.nextInt(255);
        return String.valueOf(a) + "." + String.valueOf(b) + "." + String.valueOf(c) + "." + String.valueOf(d);
    }
}
