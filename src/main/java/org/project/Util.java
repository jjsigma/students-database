package org.project;

import java.io.*;

public class Util {
    private static final String fromNameFileURL = "fromNameFile.txt";
    private static final String toNameFileURL = "toNameFile.txt";
    private static final BufferedReader reader;
    private static final  BufferedWriter writer;

    static {
        try {
            writer = new BufferedWriter(new FileWriter(toNameFileURL));
            reader = new BufferedReader(new FileReader(fromNameFileURL));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String[] readPersonDataFromFile() throws IOException {
        String line = reader.readLine().toLowerCase();
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
        while (reader.ready()) {
            String[] personData = readPersonDataFromFile();
            for (int i = 0; i < personData.length; i++) {
                char first = personData[i].charAt(0);
                personData[i] = personData[i].replaceFirst(String.valueOf(first), String.valueOf(first).toUpperCase());
            }
            writePersonDataToFile(personData);
        }
        close();
    }

    /**
     * For Testing
     */
    public static void main(String[] args) throws IOException {
        convertName();
    }
}
