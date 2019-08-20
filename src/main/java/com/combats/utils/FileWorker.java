package com.combats.utils;

import java.io.*;

public class FileWorker {

    private static final String FILE_PATH = "src/main/resources/User data.txt";

    public static void writeFile() {
        try (FileWriter writer = new FileWriter(FILE_PATH, false)) {

            writer.write(Properties.getUserLogin());
            writer.append('\n');
            writer.append(Properties.getUserPassword());
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String[] readFile() {
        String[] loginAndPassword = new String[2];
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            if (br.ready()) {
                loginAndPassword[0] = br.readLine();
                loginAndPassword[1] = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return loginAndPassword;
    }

}
