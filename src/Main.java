import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        System.out.println("Введит выражение, разделяя знаки пробелами ");
        String input = scan.nextLine();
        System.out.println("Результат: " + calc(input));
    }

    public static String calc(String input) throws IllegalArgumentException{
        String[] parts = input.split(" ");
        if (parts.length !=3){
            throw new IllegalArgumentException("Неверный формат выражения.");
        }
        boolean isRoman1 = false;
        boolean isRoman2 = false;
        int num1, num2;
        int result;

        try {
            num2 = Integer.parseInt(parts[2]);
        }catch (IllegalArgumentException e){
            num2 = RomanNumerals.romToArab(parts[2]);
            isRoman1 = true;
        }

        try {
            num1 = Integer.parseInt(parts[0]);
        }catch (IllegalArgumentException e){
            num1 = RomanNumerals.romToArab(parts[0]);
            isRoman2 = true;
        }

        if (isRoman1 && isRoman2) {
        } else
        if (!isRoman1 && !isRoman2) {
        } else {
            throw new IllegalArgumentException("Обе переменные должны быть либо римскими, либо арабскими.");
        }

        if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10){
            throw new IllegalArgumentException("Значения не могут выходить за переделы от 1 до 10");
        }

        char operation = parts[1].charAt(0);
        switch (operation){
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1/num2;
                break;
            default:
                throw new IllegalArgumentException("Неизвестная операция");                    
        }

        if (!(isRoman1 && isRoman2)){                                                 
            return String.valueOf(result);
        }
        else return RomanNumerals.arabToRom(result);


    }
}

class RomanNumerals {
    public static String[] roman_Numerals = {"zero", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
            "XI",     "XII",   "XIII",    "XIV",   "XV",   "XVI",   "XVII",   "XVIII",   "XIX",   "XX",
            "XXI",    "XXII",  "XXIII",   "XXIV",  "XXV",  "XXVI",  "XXVII",  "XXVIII",  "XXIX",  "XXX",
            "XXXI",   "XXXII", "XXXIII",  "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
            "XLI",    "XLII",  "XLIII",   "XLIV",  "XLV",  "XLVI",  "XLVII",  "XLVIII",  "XLIX",  "L",
            "LI",     "LII",   "LIII",    "LIV",   "LV",   "LVI",   "LVII",   "LVIII",   "LIX",   "LX",
            "LXI",    "LXII",  "LXIII",   "LXIV",  "LXV",  "LXVI",  "LXVII",  "LXVIII",  "LXIX",  "LXX",
            "LXXI",   "LXXII", "LXXIII",  "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
            "LXXXI",  "LXXXII","LXXXIII", "LXXXIV","LXXXV","LXXXVI","LXXXVII","LXXXVIII","LXXXIX","XC",
            "XCI",    "XCII",  "XCIII",   "XCIV",  "XCV",  "XCVI",  "XCVII",  "XCVIII",  "XCIX",  "C"};

    public static int romToArab(String romanNumeral){
        String inputUp = romanNumeral.toUpperCase();
        for (int i = 0; i< roman_Numerals.length; i++){
            if (inputUp.equals(roman_Numerals[i])){
                return i;
            }
        }
        return 0;
    }
    public static String arabToRom(int arabNumeral){
        if (arabNumeral <= 0){                                             
            throw new IllegalArgumentException("Результат операций римских чисел не может быть меньше или равен нулю");
        }
        String arabNumber = roman_Numerals[arabNumeral];
        return arabNumber;
    }
}
