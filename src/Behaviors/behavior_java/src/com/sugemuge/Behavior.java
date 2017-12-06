package com.sugemuge;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class Behavior {

    public final static SimpleDateFormat FORMAT_DATE = new SimpleDateFormat("M/d/yyyy");
    public final static int MAX_WEEKS = 14;
    public static Date START_DATE = new Date();
    public final static SimpleDateFormat FORMAT_TIME = new SimpleDateFormat("hh:mm:ss a");
    public final static String LOG_DIR = "../private/clean/";
    public final static String[] OUTPUT_TITLE = { // header
            "ID", // ID
            "num_logins", // total number of logins
            "days_no_activities", // number of days with 0 activities
            // "act_per_session", // number of activities per login session
            "act_per_day", // number of activities per day
            "num_online_meetings", // number of online meetings
            "due_1A", "due_1B", "due_2_1A", "due_2_1B", "due_2_2A", "due_2_2B", "due_3A", "due_3B", "due_4A", "due_4B",
            "due_5A", "due_5B", "due_6A", "due_6B", "due_7A", "due_7B", "avg_due", "Time Test 1A", "Time Test 1B",
            "Time Test 2 Part 1A", "Time Test 2 Part 1B", "Time Test 2 Part 2A", "Time Test 2 Part 2B", "Time Test 3A",
            "Time Test 3B", "Time Test 4A", "Time Test 4B", "Time Test 5A", "Time Test 5B", "Time Test 6A",
            "Time Test 6B", "Time Test 7A", "Time Test 7B", "avg_time_test" };

    public static void main (String[] args) throws ParseException, IOException {
        // int weeks = (args.length == 0 ? MAX_WEEKS :
        // Integer.parseInt(args[0]));
        for (int weeks = 1; weeks <= MAX_WEEKS; weeks++) {
            System.out.println(weeks);
            START_DATE = FORMAT_DATE.parse("1/15/2013");
            CSVWriter out = new CSVWriter(new FileWriter("../docs/Shreyas/" + weeks + ".csv"));
            out.writeNext(OUTPUT_TITLE);
            for (int i = 1; i <= 111; i++) {
                String filename = LOG_DIR + "log_" + i + ".csv";
                String[] outRow;
                try {
                    outRow = new String[] { Integer.toString(i), Integer.toString(totalLogin(filename, weeks)),
                            Integer.toString(days0Activities(filename, weeks)),
                            Double.toString(AvgActivity(filename, weeks)), Integer.toString(onlinem(filename, weeks)),
                            testdue(1, 0, 'A', filename, weeks), testdue(1, 0, 'B', filename, weeks),
                            testdue(2, 1, 'A', filename, weeks), testdue(2, 1, 'B', filename, weeks),
                            testdue(2, 2, 'A', filename, weeks), testdue(2, 2, 'B', filename, weeks),
                            testdue(3, 0, 'A', filename, weeks), testdue(3, 0, 'B', filename, weeks),
                            testdue(4, 0, 'A', filename, weeks), testdue(4, 0, 'B', filename, weeks),
                            testdue(5, 0, 'A', filename, weeks), testdue(5, 0, 'B', filename, weeks),
                            testdue(6, 0, 'A', filename, weeks), testdue(6, 0, 'B', filename, weeks),
                            testdue(7, 0, 'A', filename, weeks), testdue(7, 0, 'B', filename, weeks), "",
                            testTime(1, 0, 'A', filename, weeks), testTime(1, 0, 'B', filename, weeks),
                            testTime(2, 1, 'A', filename, weeks), testTime(2, 1, 'B', filename, weeks),
                            testTime(2, 2, 'A', filename, weeks), testTime(2, 2, 'B', filename, weeks),
                            testTime(3, 0, 'A', filename, weeks), testTime(3, 0, 'B', filename, weeks),
                            testTime(4, 0, 'A', filename, weeks), testTime(4, 0, 'B', filename, weeks),
                            testTime(5, 0, 'A', filename, weeks), testTime(5, 0, 'B', filename, weeks),
                            testTime(6, 0, 'A', filename, weeks), testTime(6, 0, 'B', filename, weeks),
                            testTime(7, 0, 'A', filename, weeks), testTime(7, 0, 'B', filename, weeks), "" };
                } catch (FileNotFoundException e) {
                    continue;
                }
                double sum1 = 0.0, sum2 = 0.0, count1 = 0.0, count2 = 0.0;
                for (int k = 5; k < 21; k++) {
                    if (outRow[k] != null && outRow[k] != "-999") {
                        sum2 += Double.parseDouble(outRow[k]);
                        count2++;
                    }
                }
                for (int j = 22; j < outRow.length - 1; j++) {
                    if (outRow[j] != null && outRow[j] != "0") {
                        sum1 += Double.parseDouble(outRow[j]);
                        count1++;
                    }
                }
                outRow[21] = (sum2 == 0 ? "0" : Double.toString(sum2 / count2));
                outRow[outRow.length - 1] = (sum1 == 0 ? "0" : Double.toString(sum1 / count1));
                out.writeNext(outRow);
            }
            // System.out.println(testTime(1, 0, 'A', LOG_DIR +
            // "log_1.csv",10));
            out.flush();
            out.close();
        }
    }

    private static String testdue (int num, int part, char seq, String filename, int weeks)
            throws ParseException, IOException {
        CSVReader in = new CSVReader(new FileReader(filename));
        boolean flag = false;
        String[] col;
        in.readNext();
        String testString = "Test #" + num + (part == 0 ? " " : (" Part #" + part + " ")) + seq;
        Date taken = new Date();
        Date due = due(num, part, seq);
        while ((col = in.readNext()) != null && !flag) {
            if (col[1].equals(lastDate(weeks)))
                break;
            if (col.length >= 7 && col[7].contains(testString)) {
                taken = FORMAT_DATE.parse(col[3]);
                flag = true;
            }
        }
        // System.out.println(taken.toString() + " " + due.toString());
        if (flag)
            return Integer.toString(daysBetween(taken, due));
        else {
            return "-999";
        }
    }

    public static int daysBetween (Date d1, Date d2) {
        return (int) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
    }

    private static Date due (int num, int part, char seq) throws ParseException {
        switch (num) {
        case 1:
            return FORMAT_DATE.parse("1/29/2013");
        case 2:
            if (part == 1) {
                return FORMAT_DATE.parse("2/5/2013");
            } else {
                return FORMAT_DATE.parse("2/12/2013");
            }
        case 3:
            return FORMAT_DATE.parse("2/19/2013");
        case 4:
            return FORMAT_DATE.parse("3/5/2013");
        case 5:
            return FORMAT_DATE.parse("3/12/2013");
        case 6:
            return FORMAT_DATE.parse("3/19/2013");
        case 7:
            return FORMAT_DATE.parse("3/26/2013");
        default:
            return null;

        }

    }

    private static int onlinem (String filename, int weeks) throws ParseException, IOException {
        CSVReader in = new CSVReader(new FileReader(filename));
        String[] col;
        in.readNext();
        int c = 0;
        while ((col = in.readNext()) != null) {
            if (col.length >= 1 && col[1].equals(lastDate(weeks)))
                break;

            if (col.length >= 7 && col[7].contains("Online Meeting")) {
                c++;
            }
        }
        return c;
    }

    public static String testTime (int num, int part, char seq, String filename, int weeks)
            throws IOException, ParseException {
        String testString = "Test #" + num + (part == 0 ? " " : (" Part #" + part + " ")) + seq;
        java.sql.Time timeStart = null, timeEnd = null;
        boolean endMode = false;
        CSVReader in = new CSVReader(new FileReader(filename));
        String[] col;
        in.readNext();
        while ((col = in.readNext()) != null) {
            if (col[1].equals(lastDate(weeks)))
                return "0";
            if (col.length >= 7 && !endMode && col[7].contains(testString)) {
                endMode = true;
                timeStart = new Time(FORMAT_TIME.parse(col[4]).getTime());
            }

            if (endMode && col[7].contains(testString) && (col[5].contains("Submitted") || col[5].contains("LOGOUT"))) {
                timeEnd = new Time(FORMAT_TIME.parse(col[4]).getTime());
                break;
            }
        }

        if (timeEnd == null || timeStart == null)
            return "0";
        else {
            // System.out.println("Start " + timeStart.toString() + " End " +
            // timeEnd.toString() + " "
            // + (timeEnd.getTime() - timeStart.getTime()));
            return Double.toString(Math.abs(timeEnd.getTime() - timeStart.getTime()) / 60000.0);
        }
    }

    public static int days0Activities (String filename, int weeks) throws IOException {
        HashSet<String> seen = new HashSet<String>();
        int counter = 0;
        CSVReader in = new CSVReader(new FileReader(filename));
        String[] col;
        in.readNext(); // ignore titles
        while ((col = in.readNext()) != null) {
            String curDate;
            if ((curDate = col[1]).equals(lastDate(weeks))) {
                in.close();
                return counter;
            }
            // System.out.println(curDate + " " + lastDate(weeks) + " " +
            // (curDate.equals(lastDate(weeks)) ? "Y" : "N"));
            if (!seen.contains(curDate) && !curDate.equals("")) {
                seen.add(curDate);
                if (col.length < 4 || col[3].equals("") || col[3].equals(null)) {
                    counter++;
                }
            }
        }
        in.close();
        return counter;
    }

    public static double AvgActivity (String filename, int weeks) throws IOException {
        Float sum = Float.valueOf(0), count = Float.valueOf(0);
        HashSet<String> seen = new HashSet<String>();
        CSVReader in = new CSVReader(new FileReader(filename));
        String[] col;
        in.readNext();
        while ((col = in.readNext()) != null) {
            String curDate;
            if ((curDate = col[1]).equals(lastDate(weeks))) {
                in.close();
                return sum / count;
            }
            if (!seen.contains(curDate)) {
                seen.add(curDate);
                if (col.length > 2 && !(col[2].equals("") && !col[2].equals(null)))
                    try {
                        sum += Float.parseFloat(col[2].trim());
                    } catch (NumberFormatException e) {
                        continue;
                    }
                // System.out.println(sum + " \\| " + count);
                count++;
            }

        }
        in.close();
        return sum / count;
    }

    public static int totalLogin (String filename, int weeks) throws IOException {
        CSVReader in = new CSVReader(new FileReader(filename));
        int count = 0;
        String[] col;
        in.readNext();
        while ((col = in.readNext()) != null) {
            if (col.length >= 5)
                count += (col[5].contains("LOGIN") ? 1 : 0);
            if (col[1].equals(lastDate(weeks)))
                break;
        }
        in.close();
        return count;
    }

    public static String lastDate (int weeks) {
        Calendar c = Calendar.getInstance();
        c.setTime(START_DATE);
        // System.out.println(START_DATE);
        c.add(Calendar.DATE, (weeks * 7));
        return FORMAT_DATE.format(c.getTime());

    }
}
