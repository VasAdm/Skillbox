package ru.skillbox;

public class ArithmeticCalculator {
    private final int a;
    private final int b;

    public  ArithmeticCalculator(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public double calculate(Operation operation) {
        double result = 0;
//        switch (operation) {
//            case ADD:
//                result =  a + b;
//                break;
//            case SUBTRACT:
//                result = a - b;
//                break;
//            case MULTIPLY:
//                result = a * b;
//                break;
//        }
        result = (operation.equals(Operation.ADD) ? a + b : operation.equals(Operation.SUBTRACT) ? a - b : a * b);
//        result = (operation == Operation.ADD ? a + b : operation == Operation.SUBTRACT ?  a - b : a * b);
        return result;
    }
}
