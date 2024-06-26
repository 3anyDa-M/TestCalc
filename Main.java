import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("ТЕСТОВАЯ ЗАДАЧА КАЛЬКУЛЯТОР");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение : ");
        String expression = scanner.nextLine();
        System.out.println(calc(expression));
    }
    public static String calc(String input) throws Exception {
        int n1;
        int n2;
        String opernd;
        String result;
        boolean isRoman;
        String[] operands = input.split("[-+*/]");
        if (operands.length != 2) throw new Exception("введите два числа ");
        opernd = action(input);
        if (Roman.isRoman(operands[0]) && Roman.isRoman(operands[1])) {
            n1 = Roman.conArab(operands[0]);
            n2 = Roman.conArab(operands[1]);
            isRoman = true;
        }
        else if (!Roman.isRoman(operands[0]) && !Roman.isRoman(operands[1])) {
            n1 = Integer.parseInt(operands[0]);
            n2 = Integer.parseInt(operands[1]);
            isRoman = false;
        }

        else {
            throw new Exception("Числа должны быть в одном формате либо римские либо арабские ");
        }
        if (n1 > 10 || n2 > 10) {
            throw new Exception("Число должно быть не более  10");}
        if (n1<1 || n2 < 1 ){
            throw new Exception("Число Должно быть больше 0");}

        assert opernd != null;
        int arabian = calc(n1, n2, opernd);
        if (isRoman) {
            if (arabian <= 0) {
                throw new Exception("Римское число должно быть больше нуля");
            }
            result = Roman.conRoman(arabian);
        } else {
            result = String.valueOf(arabian);
        }
        return result;
    }
    static String action(String expression) {
        if (expression.contains("+"))
            return "+";
        else if (expression.contains("-"))
            return "-";
        else if (expression.contains("*"))
            return "*";
        else if (expression.contains("/"))
            return "/";
        else return null;
    }
    static int calc(int a, int b, String oper) {
        return switch (oper) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> throw new IllegalStateException("Unexpected value: " + oper);
        };
    }
}// В массиве под индексом [0] указана буква латинского алфавита в верхнем регистре  "O"
class Roman {
    static String[] romArray = new String[]{"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI",
            "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV",
            "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI",
            "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII",
            "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII",
            "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV",
            "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV",
            "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII",
            "XCVIII", "XCIX", "C"};
    public static boolean isRoman(String q1) {
        for (String s : romArray) {
            if (q1.equals(s)) {
                return true;
            }
        }
        return false;
    }
    public static int conArab(String roman) {
        for (int i = 0; i < romArray.length; i++) {
            if (roman.equals(romArray[i])) {
                return i;
            }
        }
        return -1;
    }
    public static String conRoman(int arabian) {
        return romArray[arabian];
    }
}
