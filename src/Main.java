import java.util.Scanner;

public class Main {

    public static String calc(String input) throws Exception {

        String result = "";

        if(input.matches("\\s*([1-9]|10)\\s*(\\+|\\-|\\*|\\/)\\s*([1-9]|10)\\s*")) {
            result = calculateArabic(input);
        } else if(input.matches("\\s*(I|II|III|IV|V|VI|VII|VIII|IX|X)\\s*(\\+|\\-|\\*|\\/)\\s*(I|II|III|IV|V|VI|VII|VIII|IX|X)\\s*")) {
            result = calculateRoman(input);
        } else {
            throw new Exception();
        }
        return result;
    }

    public static String calculateArabic(String s) {
        String result = "";
        String[] x = s.replace(" ", "").split("\\+|\\-|\\*|\\/");
        if(s.contains("+")){
            result = String.valueOf(Integer.parseInt(x[0]) + Integer.parseInt(x[1]));
        } else if (s.contains("-")) {
            result = String.valueOf(Integer.parseInt(x[0]) - Integer.parseInt(x[1]));
        } else if (s.contains("*")) {
            result = String.valueOf(Integer.parseInt(x[0]) * Integer.parseInt(x[1]));
        } else if (s.contains("/")) {
            result = String.valueOf(Integer.parseInt(x[0]) / Integer.parseInt(x[1]));
        }
        return result;
    }

    public static String calculateRoman(String s) throws Exception{
        int result = 0;
        String[] x = s.replace(" ", "").split("\\+|\\-|\\*|\\/");
        int a = NumberConverter.toArabic(x[0]);
        int b = NumberConverter.toArabic(x[1]);
        if(a < b) throw new Exception();
        if(s.contains("+")){
            result = a + b;
        } else if (s.contains("-")) {
            result = a - b;
        } else if (s.contains("*")) {
            result = a * b;
        } else if (s.contains("/")) {
            result = a / b;
        }
        return NumberConverter.toRoman(result);
    }


    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)){
            String s = "";
            while((s = scanner.nextLine()) != "end") {
                System.out.println(calc(s));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
