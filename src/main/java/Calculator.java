import java.util.Scanner;

public class Calculator {
    int add(int i, int j) {
        return i + j;
    }

    int subtract(int i, int j) {
        return i - j;
    }

    int multiply(int i, int j) {
        return i * j;
    }

    int divide(int i, int j) {
        return i / j;
    }

    int add(String text){
        if (text == null || text.isEmpty()) {return 0;}
        String[] numbers = text.split(",|:");
        try {
            if(numbers.length > 2)
                return 0;
            else if (numbers.length == 2) {
                return Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]);
            }
            return Integer.parseInt(numbers[0]);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    int run() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input == null || input.isEmpty()) {return 0;}
        String[] values = input.split(" ");
        try {
            int nowNumber = Integer.parseInt(values[0]);
            for (int i=1; i<values.length; i+=2) {
                String current = values[i];
                String next = values[i+1];
                switch (current) {
                    case "+": nowNumber = add(nowNumber, Integer.parseInt(next)); break;
                    case "-": nowNumber = subtract(nowNumber, Integer.parseInt(next)); break;
                    case "*": nowNumber = multiply(nowNumber, Integer.parseInt(next)); break;
                    case "/": nowNumber = divide(nowNumber, Integer.parseInt(next)); break;
                    default: return 0;
                }
            }
            return nowNumber;
        } catch (Exception e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        Calculator cal = new Calculator();
        System.out.println(cal.add(3, 4));
        System.out.println(cal.subtract(5, 4));
        System.out.println(cal.multiply(2, 6));
        System.out.println(cal.divide(8, 4));
    }

}