package P11_20;

import java.math.BigInteger;

/**
 * Author: DarrenZeng
 * Date: 2015-12-01
 */
/*
    =====Project Euler 17=====

    If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.

    If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?


    NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. The use of "and" when  writing out numbers is in compliance with British usage.
 */
public class P17 {
    private static String[] lessEqualTwenty = new String[]{
            "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty"
    };
    private static String[] tenDigit = new String[]{
            "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
    };
    private static String[] threeDigitSmallNumber=new String[]{
            "", "thousand", "million", "billion"
    };
    private static String[] threeDigits = new String[]{
            "", "thousand", "million", "billion", "trillion", "quadrillion", "quintillion", "sextillion", "septillion", "octillion", "nonillion", "decillion", "undecillion", "duodecillion", "tredecillion", "quattuordecillion", "quindecillion"
    };
    private static final String hundred = "hundred";

    public static int getTotalLetters(int begin, int end) {
        int sum = 0;
        for (int i = begin; i <= end; i++) {
            String result = getEnglish(i);
            for (int j = 0; j < result.length(); j++) {
                char c = result.charAt(j);
                if (c >= 'a' && c <= 'z')
                    sum++;
            }
        }
        return sum;
    }

    /*
        将对应数字转换成英文书写
     */
    public static String getEnglish(int number) {
        if (number < 0) return "";
        if (number <= 20) return lessEqualTwenty[number];
        if (number < 100) {
            int tenDigitNumber = number / 10;
            return tenDigit[tenDigitNumber] + ((number % 10 == 0) ? "" : "-" + getEnglish(number % 10));
        }

        if (number < 1000) {
            int hundredDigitNumber = number / 100;
            if (hundredDigitNumber > 0)
                return lessEqualTwenty[hundredDigitNumber] + " " + hundred + ((number % 100 == 0) ? "" : " and " + getEnglish(number % 100));
            return (number % 100 == 0) ? "" : getEnglish(number % 100);
        }

        String result = "";
        for (int i = threeDigitSmallNumber.length - 1; i >= 1; i--) {
            int divisor = (int) Math.pow(10, 3 * i);
            int totalCurrentDigitNumber = number / divisor;
            if (totalCurrentDigitNumber > 0)
                result += getEnglish(totalCurrentDigitNumber) + " " + threeDigitSmallNumber[i] + " ";
            number = number % divisor;
        }

        result += number != 0 ? getEnglish(number) : "";
        if (result.endsWith(" "))
            result = result.substring(0, result.length() - 1);
        return result;
    }

    public static String getEnglish(String number) {
        return getEnglish(new BigInteger(number));
    }

    public static String getEnglish(BigInteger number) {
        if (number.compareTo(BigInteger.ZERO) < 0) return "";
        if (number.compareTo(BigInteger.valueOf(20)) <= 0) return lessEqualTwenty[number.intValue()];
        if (number.compareTo(BigInteger.valueOf(100)) < 0) {
            BigInteger tenDigitNumber = number.divide(BigInteger.valueOf(10));
            BigInteger divisor = number.mod(BigInteger.valueOf(10));
            return tenDigit[tenDigitNumber.intValue()] + ((divisor.compareTo(BigInteger.ZERO) == 0) ? "" : "-" + getEnglish(divisor));
        }

        if (number.compareTo(BigInteger.valueOf(1000)) < 0) {
            BigInteger hundredDigitNumber = number.divide(BigInteger.valueOf(100));
            if (hundredDigitNumber.compareTo(BigInteger.ZERO) > 0) {
                BigInteger divisor = number.mod(BigInteger.valueOf(100));
                return lessEqualTwenty[hundredDigitNumber.intValue()] + " " + hundred + ((divisor.compareTo(BigInteger.ZERO) == 0) ? "" : " and " + getEnglish(divisor));
            }
            BigInteger hundredDigitDivisor = number.mod(BigInteger.valueOf(100));
            return (hundredDigitDivisor.compareTo(BigInteger.ZERO) == 0) ? "" : getEnglish(hundredDigitDivisor);
        }

        String result = "";
        for (int i = threeDigits.length - 1; i >= 1; i--) {
            BigInteger divisor = BigInteger.valueOf(10).pow(3 * i);
            BigInteger totalCurrentDigitNumber = number.divide(divisor);
            if (totalCurrentDigitNumber.compareTo(BigInteger.ZERO) > 0)
                result += getEnglish(totalCurrentDigitNumber) + " " + threeDigits[i] + " ";
            number = number.mod(divisor);
        }

        result += number.compareTo(BigInteger.ZERO) != 0 ? getEnglish(number) : "";
        if (result.endsWith(" "))
            result = result.substring(0, result.length() - 1);
        return result;
    }
}
