package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class FileWordCount {

    public static void main(String[] args) throws IOException{
        String data=null;
        String[] wordsArray = null;
        int choise = 0;
            try {
                data = new String(Files.readAllBytes(Paths.get("word-test.txt")));
                wordsArray = data.split("\\W+");
            } catch (IOException e) {
                System.out.println("No such file");
                choise = 4;
            }
        Scanner scanner = new Scanner(System.in);
        FileOperations fileOperations = new FileOperations();

        while (choise!=4){
            choise=menu(scanner);
            if (choise == 1){
                //System.out.println(wordCount);
                fileOperations.getWordCount(data);
            }else if (choise == 2){
                fileOperations.getUniqueWords(wordsArray);
            }else if (choise == 3){
                fileOperations.replaceContent(scanner,data);
            }
        }
    }

    public static int menu(Scanner scan){
        System.out.println("------------------------------------------------");
        System.out.println("| Text File Analyser                           |");
        System.out.println("| Option 1 - Total Word Count                  |");
        System.out.println("| Option 2 - Unique Word Count                 |");
        System.out.println("| Option 3 - Replace Word and Save As New File |");
        System.out.println("| Option 4 - Exit                              |");
        System.out.println("------------------------------------------------");

        String userOption = "";
        while (!checkInputIsNumber(userOption)){
            System.out.println("Enter your choise: ");
            userOption = scan.nextLine();
        }
        return Integer.parseInt(userOption);
    }
    public static boolean checkInputIsNumber(String input) {
        if (input.matches("-?\\d+(\\.\\d+)?")){
            int choise = Integer.parseInt(input);
            return (choise >= 1) && (choise <= 4);
        }else return false;
    }
}
