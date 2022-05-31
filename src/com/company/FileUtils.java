package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileUtils {
    public static String readFile() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src\\com\\company\\resources\\input.csv"));
        sc.useDelimiter("\\Z");
        return sc.next();
    }

    public static void writeFile(String textToWrite) throws IOException {
        FileWriter outputWriter = new FileWriter(new File("src\\com\\company\\resources\\output.csv"));
        outputWriter.write(textToWrite);
        outputWriter.close();
    }
}
