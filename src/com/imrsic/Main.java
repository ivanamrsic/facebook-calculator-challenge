package com.imrsic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try {
            File file = new File("/Users/gordanmrsic/Developer/AVSP/facebook_calculator_challenge/src/com/imrsic/test");
            Scanner scanner = new Scanner(file);

            Calculator calculator = new Calculator();

            while (scanner.hasNextLine()) {
                String input = scanner.nextLine();

                try {
                    System.out.printf("%d ", calculator.evaluateExpression(createEquation(input)));
                } catch (Error err) {
                    System.out.printf("Err ");
                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static List<String> createEquation(String input) {
        List<String> list = new ArrayList<>();

        String[] inputs = input.split(" ");

        Collections.addAll(list, inputs);

        return list;
    }
}
