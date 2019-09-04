package com.combats.utils;

import java.io.*;

public class FileWorker {

    private static final String USER_DATA_FILE_PATH = "User data.txt";

    public static void writeUserDataFile() {
        try (FileWriter writer = new FileWriter(USER_DATA_FILE_PATH, false)) {

            writer.write(Properties.getUserLogin());
            writer.append('\n');
            writer.append(Properties.getUserPassword());
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String[] readUserDataFile() {
        String[] loginAndPassword = new String[2];
        try (BufferedReader br = new BufferedReader(new FileReader(USER_DATA_FILE_PATH))) {
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
