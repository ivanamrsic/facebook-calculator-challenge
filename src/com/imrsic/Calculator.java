package com.imrsic;

import java.util.List;
import java.util.Stack;

class Calculator {

    private Stack<Term> stack;

    Calculator() {
        stack = new Stack<>();
    }

    Integer evaluateExpression(List<String> input) throws Error{
        for(int index = input.size() - 1; index > 0; --index) {
            String currentElement = input.get(index);

            if (isNumeric(currentElement)) {
                stack.push(new Term(Integer.parseInt(currentElement)));

                continue;
            }

            handleNonNumericElement(currentElement);
        }

        return this.calculateFinalSolution(input.get(0));
    }

    private static boolean isNumeric(String str) {
        return str.matches("[0-9]");  //match a number with optional '-' and decimal.
    }

    private void handleNonNumericElement(String currentElement) {
        if (currentElement.equals("X")) {
            stack.push(new Term( 1, 0));
        } else {
            Term firstElement = stack.pop();
            Term secondElement = stack.pop();

            switch (currentElement) {
                case "+":
                    firstElement.add(secondElement);
                    break;
                case "-":
                    firstElement.subtract(secondElement);
                    break;
                case "*":
                    firstElement.multiply(secondElement);
                    break;
            }

            stack.push(firstElement);
        }
    }

    private Integer calculateFinalSolution(String termY) {
        Term term = stack.pop();

        Integer y = Integer.parseInt(termY);

        if ((y - term.getConstant()) % term.getxMultiplier() != 0) {
            throw new Error("Cannot find integer solution.");
        }

        return (y - term.getConstant()) / term.getxMultiplier();
    }
}
