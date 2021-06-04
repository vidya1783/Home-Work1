package com.techelevator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.io.PrintWriter;
import static java.lang.System.exit;
public class FindAndReplace {
    public static void main(String[] args)  {
        Scanner myScanner = new Scanner(System.in);
        // Reading the search and replacement words
        System.out.println("What is the search word?");
        String searchWord = myScanner.nextLine();
        System.out.println("Search word: " + searchWord);
        System.out.println("What is the replacement word?");
        String replacementWord = myScanner.nextLine();
        System.out.println("Replacement word: " + replacementWord);
        // Source File
        System.out.println("What is the source file?");
        String sourceFile = myScanner.nextLine();
        System.out.println("Source file: " + sourceFile);
        File inputFile = new File(sourceFile);
        // Destination File
        System.out.println("What is the destination file?");
        String destinationFile = myScanner.nextLine();
        System.out.println("Destination file: " + destinationFile);
        File outputFile = new File(destinationFile);
        try {
            outputFile.createNewFile();
        } catch (IOException e) {
            e.getMessage();
        }
        PrintWriter writer = null;
        if(outputFile.exists()){
            try {
                writer = new PrintWriter(outputFile.getAbsoluteFile());
            } catch (FileNotFoundException e) {
                e.getMessage();
            }
            if (inputFile.exists()){
                try (Scanner inputScanner = new Scanner(inputFile.getAbsoluteFile())){
                    while(inputScanner.hasNextLine()) {
                        String lineInput = inputScanner.nextLine();
                        lineInput = lineInput.replaceAll(searchWord, replacementWord);
                        if(inputScanner.hasNextLine())
                        {
                            writer.println(lineInput);
                        } else {
                            writer.print(lineInput);
                        }
                    }
                }
                catch(FileNotFoundException e){
                    System.out.println("The source file is invalid");
                    System.out.println(e.getMessage());
                    exit(-1);
                }
            }
            writer.flush();
            writer.close();
        }
    }
}