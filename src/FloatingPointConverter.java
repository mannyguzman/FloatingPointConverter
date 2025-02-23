
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FloatingPointConverter {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        System.out.println("Write decimal number to convert: ");
        double input = scanner.nextDouble();

        boolean isInputNegative = false;
        int sign = 0;
        if (input < 0) {
            isInputNegative = true;
            sign = 1;
            input = input * -1;
        }

        int wholeNum = (int) input;
        double decimalNum = input - wholeNum;


        double result = wholeNum / 2;
        double remainder = wholeNum % 2;
        ArrayList<Integer> arrayListWhole = new ArrayList<>();

        while (result > 0) {
            if (remainder > 0) {
                arrayListWhole.add(1);
                result = (int) result;
            } else {
                arrayListWhole.add(0);
            }
            remainder = result % 2;
            result = result / 2;
        }
        //Reading results in reverse
        Collections.reverse(arrayListWhole);

        double decimalResult = decimalNum * 2;
        ArrayList<Integer> arrayListDecimal = new ArrayList<>();
        // Prevent infinite loop while dividing
        int maxIterations = 100;
        while (!(decimalResult == 0) && maxIterations > 0) {
            if (decimalResult >= 1.0) {
                arrayListDecimal.add(1); //2.5
                double resultRoundedDown = (int) decimalResult;
                decimalResult = decimalResult - resultRoundedDown;
            } else {
                arrayListDecimal.add(0);
            }
            decimalResult = decimalResult * 2;
        }
        System.out.println("Bits of Whole number: " + arrayListWhole);
        System.out.println("Bits of Decimal number: " + arrayListDecimal);

        int counter = 0;
        int exponent = 0;
        boolean isDecimalOnly = false;
        for (int i = 0; i < arrayListWhole.size(); i++) {
            arrayListWhole.get(i);
            if (arrayListWhole.get(i) == 1) {
                exponent = counter;
            }
            counter++;
        }

        if (exponent == 0) {
            isDecimalOnly = true;
            counter = 0;
            for (int i = 0; i < arrayListDecimal.size(); i++) {
                arrayListDecimal.get(i);
                if (arrayListDecimal.get(i) == 1) {
                    exponent = (counter + 1) * -1;
                    break;
                }
                counter++;
            }
        }
        System.out.println("Exponent = " + exponent);
        exponent = 127 + exponent;
        System.out.println("Exponent Excess 127 = " + exponent);

        String binaryExponent = Integer.toBinaryString(exponent);
        System.out.println("Binary of " + exponent + " = " + binaryExponent);

        ArrayList<Integer> mergedArray = new ArrayList<>(arrayListWhole);
        mergedArray.addAll(arrayListDecimal);
        System.out.println("Merged Array :" + mergedArray);

        // Remove the first '1' to find the Mantissa
        mergedArray.remove(0);
        String mantissa = mergedArray.toString().replace("[", "").replace("]", "").replace(",", "").replace(" ", "");

        // Add zeros until Mantissa is 23 characters
        while (mantissa.length() < 23) {
            mantissa = mantissa + 0;
        }

        String mantissaTrimmed = String.format("%.23s%n", mantissa);
        System.out.println("\n23 bit Mantissa");
        System.out.println(mantissaTrimmed);

        System.out.println("\nFinal Result");
        System.out.println("Sign - Exponent - Mantissa");

        System.out.println(sign + " " + binaryExponent + " " + mantissaTrimmed);


        scanner.close();
    }
}
