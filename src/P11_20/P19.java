package P11_20;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Author: DarrenZeng
 * Date: 2015-12-02
 */
/*
    =====Project Euler 16=====

    You are given the following information, but you may prefer to do some research for yourself.

        * 1 Jan 1900 was a Monday.
        * Thirty days has September,
          April, June and November.
          All the rest have thirty-one,
          Saving February alone,
          Which has twenty-eight, rain or shine.
          And on leap years, twenty-nine.
        * A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
    How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
 */
public class P19 {
    private static final int leapYearTotalDays = 366;
    private static final int commonYearTotalDays = 365;
    private static final int[] monthDays = new int[]
            {
                    0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
            };

    /*
        whichDay的取值为：Sunday: 0, Monday: 1, Tuesday: 2, Wednesday: 3, Thursday: 4, Friday: 5, Saturday: 6
     */
    public static int getTotalSundaysFellOnFirstOfMonth(int fromYear, int toYear, int whichDay) throws Exception {
        int sum = 0;
        for (int year = fromYear; year <= toYear; year++) {
            for (int month = 1; month <= 12; month++) {
                if (getWeekDay(new SimpleDateFormat("yyyy-MM-dd").parse(String.format("%1$s-%2$s-%3$s", year, month, "01"))) == whichDay) {
                    sum++;
                }
            }
        }
        return sum;
    }

    private static int getWeekDay(Date date) throws Exception {
        Date initDate = new SimpleDateFormat("yyyy-MM-dd").parse("1900-01-01");
        int initWeek = 1; //Monday
        int totalDays = getDiffDays(initDate, date);
        return (totalDays + 1 + initWeek) % 7;     //from这个日期是星期几
    }

    public static int getTotalSundays(Date from, Date to) throws Exception {
        Date initDate = new SimpleDateFormat("yyyy-MM-dd").parse("1900-01-01");
        int initWeek = 1; //Monday
        int totalDays = getDiffDays(initDate, from);
        int weekDay = (totalDays + 1 + initWeek) % 7;     //from这个日期是星期几
        System.out.println(weekDay);
        totalDays = getDiffDays(from, to);
        return (totalDays + 1 + weekDay) / 7;
    }

    public static int getDiffDays(Date from, Date to) {
        Calendar fromCal = Calendar.getInstance();
        fromCal.setTime(from);
        int fromYear = fromCal.get(Calendar.YEAR);
        int fromMonth = fromCal.get(Calendar.MONTH) + 1;
        int fromDay = fromCal.get(Calendar.DATE);

        Calendar toCal = Calendar.getInstance();
        toCal.setTime(to);
        int toYear = toCal.get(Calendar.YEAR);
        int toMonth = toCal.get(Calendar.MONTH) + 1;
        int toDay = toCal.get(Calendar.DATE);

        if (fromYear == toYear) {
            if (fromMonth == toMonth) {
                return toDay - fromDay - 1;
            }
            int result = 0;
            result += (fromMonth == 2 && isLeapYear(fromYear)) ? (monthDays[fromMonth] + 1 - fromDay + 1) : (monthDays[fromMonth] - fromDay + 1);    //计算开始日期当前月天数

            // 计算结束日期除当前月之外月份的总天数
            for (int i = fromMonth + 1; i < toMonth; i++) {
                if (i == 2) {
                    result += isLeapYear(toYear) ? monthDays[i] + 1 : monthDays[i];
                    continue;
                }
                result += monthDays[i];
            }

            result += toDay;    //计算结束日期当前月天数
            return result - 2;
        }

        int totalDays = 0;
        for (int i = fromYear + 1; i < toYear; i++) {
            if (isLeapYear(i))
                totalDays += leapYearTotalDays;
            else
                totalDays += commonYearTotalDays;
        }

        totalDays += (fromMonth == 2 && isLeapYear(fromYear)) ? (monthDays[fromMonth] + 1 - fromDay + 1) : (monthDays[fromMonth] - fromDay + 1);    //计算开始日期当前月天数
        // 计算开始日期除当前月之外月份的总天数
        for (int i = fromMonth + 1; i <= 12; i++) {
            if (i == 2) {
                totalDays += isLeapYear(fromYear) ? monthDays[i] + 1 : monthDays[i];
            }
            totalDays += monthDays[i];
        }

        // 计算结束日期除当前月之外月份的总天数
        for (int i = 1; i < toMonth; i++) {
            if (i == 2) {
                totalDays += isLeapYear(toYear) ? monthDays[i] + 1 : monthDays[i];
                continue;
            }
            totalDays += monthDays[i];
        }

        totalDays += toDay;    //计算结束日期当前月天数
        return totalDays - 2;
    }

    public static int getDate(Date from, Date to) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(from);
        long time1 = cal.getTimeInMillis();
        cal.setTime(to);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);

        return Integer.parseInt(String.valueOf(between_days));
    }

    private static Boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }
}
