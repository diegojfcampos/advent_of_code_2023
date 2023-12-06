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

        HashMap<String, Integer> numbersMap = new HashMap<>();
        numbersMap.put("1", 1);
        numbersMap.put("2", 2);
        numbersMap.put("3", 3);
        numbersMap.put("4", 4);
        numbersMap.put("5", 5);
        numbersMap.put("6", 6);
        numbersMap.put("7", 7);
        numbersMap.put("8", 8);
        numbersMap.put("9", 9);

        //Day 2 - May the numbers as writed also
        HashMap<String, Integer> writtedMap = new HashMap<>();
        writtedMap.put("one", 1);
        writtedMap.put("two", 2);
        writtedMap.put("three", 3);
        writtedMap.put("four", 4);
        writtedMap.put("five", 5);
        writtedMap.put("six", 6);
        writtedMap.put("seven", 7);
        writtedMap.put("eight", 8);
        writtedMap.put("nine", 9);

        for (String input : inputs) {

            System.out.println("===================================");
            System.out.println("INPUT " + input);
            System.out.println("===================================");

            int firstOcurrency = 0;
            int secondOcurrency = 0;

            // GETTING WRITTED NUMBER LEFT
            int valueWrittedleft = 0;
            int positionWrittedNumberLeft = Integer.MAX_VALUE;

            for (String numberWritted : writtedMap.keySet()) {
                if (input.contains(numberWritted)) {
                    int index = input.indexOf(numberWritted);
                    if (index < positionWrittedNumberLeft) {
                        valueWrittedleft = writtedMap.get(numberWritted);
                        positionWrittedNumberLeft = index;
                    }
                }
            }

            System.out.println("Position Writted: " + positionWrittedNumberLeft);
            System.out.println("Value  Writted: " + valueWrittedleft);

// GETTING DIGIT LEFT
            int valueNumberleft = 0;
            int positionNumberLeft = Integer.MAX_VALUE;

            for (String number : numbersMap.keySet()) {
                if (input.contains(number)) {
                    int index = input.indexOf(number);
                    if (index < positionNumberLeft) {
                        valueNumberleft = numbersMap.get(number);
                        positionNumberLeft = index;
                    }
                }
            }

            System.out.println("Position Digit: " + positionNumberLeft);
            System.out.println("Value  Digit: " + valueNumberleft);

// ADDING FIRST VALUE
            firstOcurrency = (positionNumberLeft < positionWrittedNumberLeft) ? valueNumberleft : valueWrittedleft;

            //Getting wtitted number right
            int valueWrittedNumberRight = 0;
            int positionWrittedNumberRight = -1;
            int minIndexWrittedRigth = Integer.MIN_VALUE;

            for (String numberWritted : writtedMap.keySet()) {
                if (input.contains(numberWritted)) {
                    int index = input.lastIndexOf(numberWritted);
                    if (index > minIndexWrittedRigth) {
                        valueWrittedNumberRight = writtedMap.get(numberWritted);
                        positionWrittedNumberRight = index;
                        minIndexWrittedRigth = index;
                    }
                }
            }

            int valueNumberRight = 0;
            int positionNumberRigth = -1;
            int maxIndexNumRight = Integer.MIN_VALUE;

            for (String number : numbersMap.keySet()) {
                if (input.contains(number)) {
                    int index = input.lastIndexOf(number);

                    if (index > maxIndexNumRight) {
                        valueNumberRight = numbersMap.get(number);
                        positionNumberRigth = index;
                        maxIndexNumRight = index;
                    }
                }
            }

            //ADDING FIRST VALUE
            secondOcurrency = (positionWrittedNumberRight < positionNumberRigth) ? valueNumberRight : valueWrittedNumberRight;

            System.out.println("firstOcurrency " + firstOcurrency);
            System.out.println("secondOcurrency " + secondOcurrency);

            String concatChar;

            if (firstOcurrency == 0 && secondOcurrency > 0) {
                sum += secondOcurrency + (secondOcurrency * 10);
            } else if (secondOcurrency == 0 && firstOcurrency > 0) {
                sum += firstOcurrency + (firstOcurrency * 10);
            } else {
                String fristValue = String.valueOf(firstOcurrency);
                String secondValue = String.valueOf(secondOcurrency);
                concatChar = fristValue + secondValue;

                int concatResult = Integer.valueOf(concatChar);

                sum += concatResult;
            }
        }

        System.out.println("Result = " + sum);

    }
}
