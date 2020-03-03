package com.company;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class FileOperations {

    public void getWordCount(String data){

        String[] wordsArray =data.split("\\W+");
        System.out.println("Total word count is: " + wordsArray.length);
    }
    public void getUniqueWords(String[] wordsArray){
        ArrayList<String> wordsList = new ArrayList<String>();
        wordsList.addAll(Arrays.asList(wordsArray));

        Map<String, Integer> dataToNumOccurances = new HashMap<>();

        for (String aString : wordsList) {
            int occurrences = Collections.frequency(wordsList, aString);
            dataToNumOccurances.put(aString, occurrences);
        }
        ArrayList<String> sortedWords = new ArrayList<>(dataToNumOccurances.keySet());

        for (String word : sortedWords) {
            System.out.println(word +"\t" +dataToNumOccurances.get(word));
        }
        System.out.println("Unique Word Count : "+ sortedWords.size());
    }
    public void replaceContent(Scanner scanner,String content) throws FileNotFoundException {

        System.out.println("What word need to be replaced: ");
        String replaceTo = scanner.nextLine();
        System.out.println("What is the new word: ");
        String replaceWith = scanner.nextLine();

        String newContent = content.replaceAll(replaceTo,replaceWith);
        PrintWriter fileWriter = new PrintWriter("updated-file.txt");
        fileWriter.write(newContent);
        fileWriter.close();
    }
}
