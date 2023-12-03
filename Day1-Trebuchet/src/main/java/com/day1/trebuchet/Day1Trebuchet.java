/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.day1.trebuchet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *
 * @author diego
 */
public class Day1Trebuchet {

    public static void main(String[] args) {
        var inputs = new ArrayList<String>();
        String fileName = "Day1-Inputs.csv";

        Path filePath = Paths.get(fileName).toAbsolutePath();

        if (!Files.exists(filePath)) {
            System.err.println("File not found: " + fileName);
            return;
        }
        
        try (Scanner scanner = new Scanner(filePath)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                inputs.add(line);
            }
        } catch (IOException e) {
            System.err.println("Error to read the file " + e.getMessage());
        }

        int sum = 0;

        HashMap<Character, Integer> numbersMap = new HashMap<>();
        numbersMap.put('1', 1);
        numbersMap.put('2', 2);
        numbersMap.put('3', 3);
        numbersMap.put('4', 4);
        numbersMap.put('5', 5);
        numbersMap.put('6', 6);
        numbersMap.put('7', 7);
        numbersMap.put('8', 8);
        numbersMap.put('9', 9);

        for (String input : inputs) {

            int start = 0;
            int end = input.length() - 1;
            int firstOcurrency = 0;
            int secondOcurrency = 0;
            char[] charArray = input.toCharArray();

            while (start <= end) {
                if (numbersMap.containsKey(charArray[start])) {
                    firstOcurrency = numbersMap.get(charArray[start]);
                    break;
                } else {
                    start++;
                }
            }

            while (end > start) {
                if (numbersMap.containsKey(charArray[end])) {
                    secondOcurrency = numbersMap.get(charArray[end]);
                    break;
                } else {
                    end--;
                }
            }

            String concatChar;

            if (firstOcurrency == 0 && secondOcurrency > 0) {
                sum += secondOcurrency + (secondOcurrency * 10);
            } else if (secondOcurrency == 0 && firstOcurrency > 0) {
                sum += firstOcurrency + (firstOcurrency * 10);
            } else {
                String fristValue = String.valueOf(firstOcurrency);
                String secondValue = String.valueOf(secondOcurrency);
                concatChar = fristValue + secondValue;
                System.out.println("Concat" + concatChar);
                int concatResult = Integer.valueOf(concatChar);
                
                sum += concatResult;
            }
        }

        System.out.println("Result = " + sum);

    }
}
