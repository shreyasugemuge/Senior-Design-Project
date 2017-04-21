package com.sugemuge;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class Behavior {

    public final static SimpleDateFormat FORMAT_DATE = new SimpleDateFormat("M/d/yyyy");
    public final static int MAX_WEEKS = 52;
    public static Date START_DATE = new Date();
    public final static SimpleDateFormat FORMAT_TIME = new SimpleDateFormat("hh:mm:ss a");
    public final static String LOG_DIR = "../private/clean/";
    public final static String[] OUTPUT_TITLE = { "ID", "Number of days with 0 activities",
            "Average Activities Per Session", "Total Number of Logins", "Time Test #1 A", "Time Test #1 B",
            "Time Test #2 Part #1 A", "Time Test #2 Part #1 B", "Time Test #2 Part #2 A", "Time Test #2 Part #2 B",
            "Time Test #3 A", "Time Test #3 B", "Time Test #4 A", "Time Test #4 B", "Time Test #5 A", "Time Test #5 B",
            "Time Test #6 A", "Time Test #6 B", "Time Test #7 A", "Time Test #7 B" };

    public static void main (String[] args) throws ParseException, IOException {
        int weeks = (args.length == 0 ? MAX_WEEKS : Integer.parseInt(args[0]));
        START_DATE = FORMAT_DATE.parse("1/15/2013");
        CSVWriter out = new CSVWriter(new FileWriter("../docs/beh_shreyas_" + weeks + "_weeks.csv"));
        out.writeNext(OUTPUT_TITLE);
        for (int i = 1; i <= 111; i++) {
            String filename = LOG_DIR + "log_" + i + ".csv";
            String[] outRow = { Integer.toString(i), Integer.toString(days0Activities(filename, weeks)),
                    Double.toString(AvgActivity(filename, weeks)), Integer.toString(totalLogin(filename, weeks)) };
            out.writeNext(outRow);
        }
        out.flush();
        out.close();

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
                if (col[3].equals("") || col[3].equals(null)) {
                    counter++;
                }
            }
        }
        in.close();
        return counter;
    }

    public static double AvgActivity (String filename, int weeks) throws IOException {
        double sum = 0.0, count = 0.0;
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
                if (!(col[2].equals("") || col[2].equals(null)))
                    sum += Double.parseDouble(col[2]);
                System.out.println(sum + " \\| " + count);
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
        while ((col = in.readNext()) != null)
            count += (col[5].contains("LOGIN") ? 1 : 0);

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
