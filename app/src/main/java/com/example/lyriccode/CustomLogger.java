package com.example.lyriccode;

import android.content.Context;
import android.util.Log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CustomLogger {
    private static final String LOG_FILE_NAME = "logcat_output.txt";
    private static File logFile;

    public static void init(Context context) {
        logFile = new File(context.getExternalFilesDir(null), LOG_FILE_NAME);
        if (!logFile.exists()) {
            try {
                logFile.createNewFile();
                System.out.println("Addres file path" +logFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void log(String tag, String message) {
        Log.d(tag, message);
        writeLogToFile(tag, message);
    }

    private static void writeLogToFile(String tag, String message) {
        String logMessage = String.format("%s: %s\n", tag, message);
        try (FileWriter fw = new FileWriter(logFile, true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(logMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
