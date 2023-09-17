package org.project.util;

import java.io.*;
import java.sql.*;

public class Util {
    private static final String fromNameFilePath = "fromNameFile.txt";
    private static final String resultNameFilePath = "toNameFile.txt";
    private static BufferedReader reader;
    private static BufferedWriter writer;

    private static String[] readPersonDataFromFile() throws IOException {
        String line = reader.readLine();
        String[] data = line.split("\\s");
        if(data.length != 2) throw new IndexOutOfBoundsException("Not 2 words in line");
        return data;
    }
    private static void writePersonDataToFile(String[] personData) throws IOException {
        writer.write(personData[0]+" ");
        writer.write(personData[1] + "\n");
    }
    private static void close() throws IOException {
        reader.close();
        writer.close();
    }
    /**
     Сестра написала в отдельном файле имена и фамилии для БД, но они все были капсом.
     Этот алгоритм берет построчно имя и фамилию и заносит их в другой файл
     в нужном формате(Первые буквы слов заглавные).
     */
    public static void convertName() throws IOException {
        reader = new BufferedReader(new FileReader(fromNameFilePath));
        writer = new BufferedWriter(new FileWriter(resultNameFilePath, true));
        while (reader.ready()) {
            String[] personData = readPersonDataFromFile();
            for (int i = 0; i < personData.length; i++) {
                char first = personData[i].charAt(0);
                personData[i] = personData[i].toLowerCase().replaceFirst(String.valueOf(first).toLowerCase(),
                        String.valueOf(first));
            }
            writePersonDataToFile(personData);
        }
        close();
    }
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
    public static void generateAddingStudentToDatabase(int classId) throws IOException {
        reader = new BufferedReader(new FileReader(resultNameFilePath));
        String format = "INSERT INTO students(surname, name, phone_number, class_id) VALUES ('%s','%s','%s', %d);";
        while (reader.ready()) {
            String[] data = readPersonDataFromFile();
            String number = generatePhoneNumber();
            System.out.printf((format) + "%n", data[0], data[1], number, classId);
        }
    }

    /**
     * For Testing
     */
    public static void main(String[] args) throws IOException, SQLException {
        generateAddingStudentToDatabase(8);
    }
}
