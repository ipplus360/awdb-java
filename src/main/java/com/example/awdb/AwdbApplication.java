package com.example.awdb;


import com.fasterxml.jackson.databind.JsonNode;
import com.ipplus360.db.AWReader;
import com.ipplus360.db.IpTypeException;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Random;

public class AwdbApplication {

    public static void main(String[] args) {
        try {
            String ip = args[0];
            String filePath = args[1];
            AWReader awReader = new AWReader(new File(filePath));
            InetAddress address = InetAddress.getByName(ip);
            JsonNode record = awReader.get(address);
            if (record != null) {
                JsonNode continent = record.get("continent");
                if (continent != null) {
                    System.out.println(continent.asText());
                }

                JsonNode country = record.get("country");
                if (country != null) {
                    System.out.println(country.asText());
                }

                JsonNode city = record.get("city");
                if (city != null) {
                    System.out.println(city.asText());
                }

                JsonNode accuracy = record.get("accuracy");
                if (accuracy != null) {
                    System.out.println(accuracy.asText());
                }
            }
            System.out.println(record);
        } catch (IpTypeException exception) {
            System.out.println(exception.getMessage());
        } catch (Exception exception) {
            exception.printStackTrace();
        }

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
