package org.project.util;

import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {

    public static String generatePhoneNumber() {
        return generatePhoneNumber(7);
    }
    public static String generatePhoneNumber(int countryCode) {
        StringBuilder result = new StringBuilder("+");
        result.append(countryCode);
        for(int i = 0; i < 10; i++) {
            result.append((int) (Math.random() * 10));
        }
        return result.toString();
    }
    public static boolean isNameValid(String name) {
        return Pattern.compile("[A-Z][a-z]+").matcher(name).matches();
    }
    public static boolean isSurnameValid(String surname) {
        return Pattern.compile("[A-Z][a-z]+").matcher(surname).matches();
    }
    public static boolean isPhoneNumberValid(String phoneNum) {
        Pattern pattern = Pattern.compile("\\+7\\d{10}");
        Matcher matcher = pattern.matcher(phoneNum);
        return matcher.matches();
    }
    public static String getIPAddress() throws UnknownHostException {
        String ip = InetAddress.getLocalHost().getHostAddress();
        System.out.println("IP: "+ ip);
        return ip;
    }

}
