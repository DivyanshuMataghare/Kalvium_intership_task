public class SpelloutNumbers {
    public static String spellOutNumber(int number) {
        if (number == 0) {
            return "zero";
        }
        String[] units = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] tens = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        String[] specialTens = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String result = "";

        // for 4 digit number
        if (number >= 1000) {
            result += tens[number/1000] + "-";
            number %= 1000;

        }
        // for 3 digit number
        if (number >= 100) {
            result += units[number/100] + " hundred ";
            number %= 100;
        }
        // for 2 digit number
        if (number >= 10) {
            if (number >= 10 && number <= 19) {
                result += specialTens[number-10];
                return result;
            } else {
                result += tens[number/10] +"-";
                number %= 10;
            }
        }
        // for 1 digit number
        if (number > 0) {
            result += units[number];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] testCases = {0, 5, 8, 10, 21, 77, 100, 303, 555, 21, 3466, 2400, 5300};
        for (int i = 0; i < testCases.length; i++) {
            System.out.println(spellOutNumber(testCases[i]));
        }
    }

}
