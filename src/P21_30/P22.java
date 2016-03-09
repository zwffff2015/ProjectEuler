package P21_30;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

/**
 * Author: DarrenZeng
 * Date: 2015-12-03
 */
/*
    =====Project Euler 22=====

    Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names, begin by sorting it into alphabetical order. Then working out    the alphabetical value for each name, multiply this value by its alphabetical position in the list to obtain a name score.

For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a score of 938 ¡Á 53 = 49714.

    What is the total of all the name scores in the file?
 */
public class P22 {
    public static long getTotal(String fileName) {
        String data = readFile(fileName);
        String[] names = data.split(",");
        for (int i = 0; i < names.length; i++) {
            String name = names[i].substring(1, names[i].length() - 1);
            names[i] = name;
        }

        Arrays.sort(names);
        long sum = 0;
        for (int i = 0; i < names.length; i++) {
            int worth = 0;
            for (int j = 0; j < names[i].length(); j++) {
                int c = names[i].charAt(j) - 64;
                worth += c;
            }

            sum += worth * (i + 1);
        }
        return sum;
    }

    private static String readFile(String fileName) {
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            StringBuilder sb = new StringBuilder();
            String data = br.readLine();
            while (data != null) {
                sb.append(data);
                data = br.readLine();
            }
            return sb.toString();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return "";
    }
}
