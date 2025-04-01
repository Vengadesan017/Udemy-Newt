package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello, World!");
        File file = new File("Vengat_txt.txt");
        file.createNewFile();
        File file1 = new File("Vengat_dir");
        System.out.println(file1.mkdir());


        System.out.println(System.getProperty("os.name"));

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Vengat_txt.txt"))) {
            writer.write("the new message for written.");
            writer.newLine();
            writer.write("This is another line.");
            System.out.println("written to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


        try (BufferedReader reader = new BufferedReader(new FileReader("Vengat_txt.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


//        using ion package
        try {
            // Writing data to the file
            String content = "Hello, NIO file handling!";
            Files.write(Paths.get("Vengat_txt2.txt"), content.getBytes());
            System.out.println("written to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        try {
            Files.copy(Paths.get("Vengat_txt2.txt"), Paths.get("Vengat_txt3.txt"), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File copied successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }




    }
}