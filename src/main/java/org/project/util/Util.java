package org.project.util;

import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {
    private static final String resultNameFilePath = "toNameFile.txt";
    private static BufferedReader reader;

    private static String[] readPersonDataFromFile() throws IOException {
        String line = reader.readLine();
        String[] data = line.split("\\s");
        if(data.length != 2) throw new IndexOutOfBoundsException("Not 2 words in line");
        return data;
    }
    private static void close() throws IOException {
        reader.close();
    }
    /**
     Сестра написала в отдельном файле имена и фамилии для БД, но они все были капсом.
     Этот алгоритм берет построчно имя и фамилию и заносит их в другой файл
     в нужном формате(Первые буквы слов заглавные).
     */
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
    public static void generateMockStudent(int fromClassId, int toClassId) throws IOException {
        reader = new BufferedReader(new FileReader(resultNameFilePath));
        String format = "INSERT INTO students(surname, name, phone_number, class_id) VALUES ('%s','%s','%s', %d);";
        for(int classId = fromClassId; classId <= toClassId; classId++) {
            for (int i = 0; i < 20; i++) {
                String[] data = readPersonDataFromFile();
                String number = generatePhoneNumber();
                System.out.printf((format) + "%n", data[0], data[1], number, classId);
            }
        }
        close();
    }
    public static boolean isNameValid(String name) {
        return Pattern.compile("[А-Я][а-я]+").matcher(name).matches();
    }
    public static boolean isSurnameValid(String surname) {
        return Pattern.compile("[А-Я][а-я]+").matcher(surname).matches();
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
