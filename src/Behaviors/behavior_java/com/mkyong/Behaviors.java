package com.mkyong;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class Behaviors {

    public static Date START_DATE = new Date();
    public final static SimpleDateFormat FORMAT_DATE = new SimpleDateFormat("M/d/yyyy");

    public static void main (String[] args) throws ParseException {

        System.out.println("Enter the number of weeks you want to extract data for:");
        Scanner kb = new Scanner(System.in);
        int weeks = kb.nextInt();
        if (weeks < 0 || weeks > 52) {
            System.out.println("Invalid number of weeks. Please choose between 0 and 52");
            System.exit(0);
        }

        Date START_DATE = FORMAT_DATE.parse("1/15/2013");

        try {
            CSVWriter csvWriter = new CSVWriter(new FileWriter("OnlineMeetings(" + weeks + "weeks).csv"));

            String[] row = new String[] { "ID", "Online meetings attended" };
            csvWriter.writeNext(row);

            String[] strings = new String[2];
            for (int i = 0; i < 110; i++) {
                strings[0] = Integer.toString(i + 1);
                strings[1] = Integer.toString(onlineMeetings("../private/clean/log_" + (i + 1) + ".csv", weeks));
                csvWriter.writeNext(strings);
            }
            csvWriter.close();
        } catch (Exception ee) {
            ee.printStackTrace();
        }

        try {
            CSVWriter csvWriter = new CSVWriter(new FileWriter("testAverageAct(" + weeks + "weeks).csv"));

            String[] row = new String[] { "ID", "Average number of activites accessed before each test" };
            csvWriter.writeNext(row);

            String[] strings = new String[2];
            for (int i = 0; i < 110; i++) {
                strings[0] = Integer.toString(i + 1);
                strings[1] = Double.toString(averageAct("../private/clean/log_" + (i + 1) + ".csv", weeks));
                csvWriter.writeNext(strings);
            }
            csvWriter.close();
        } catch (Exception ee) {
            ee.printStackTrace();
        }

        try {
            CSVWriter csvWriter = new CSVWriter(new FileWriter("bonusActivities(" + weeks + "weeks).csv"));

            String[] row = new String[] { "ID", "Procedures Quiz", "Surveys", "CyberRat Assignments" };
            csvWriter.writeNext(row);

            String[] strings = new String[4];
            for (int i = 0; i < 110; i++) {

                int[] data = bonusActivities("../private/clean/log_" + (i + 1) + ".csv", weeks);
                strings[0] = Integer.toString(i + 1);
                strings[1] = Integer.toString(data[0]);
                strings[2] = Integer.toString(data[1]);
                strings[3] = Integer.toString(data[2]);
                csvWriter.writeNext(strings);
            }
            csvWriter.close();
        } catch (Exception ee) {
            ee.printStackTrace();
        }

        try {
            CSVWriter csvWriter = new CSVWriter(new FileWriter("testsTakenDates(" + weeks + "weeks).csv"));

            String[] row = new String[] { "ID", "days between test 1 available and submission",
                    "days between test 2 available and submission", "days between test 3 available and submission",
                    "days between test 4 available and submission", "days between test 5 available and submission",
                    "days between test 6 available and submission", "days between test 7 available and submission" };
            csvWriter.writeNext(row);

            String[] strings = new String[8];
            for (int i = 0; i < 110; i++) {
                strings[0] = Integer.toString(i + 1);
                strings[1] = Integer.toString(testDateTimely("../private/clean/log_" + (i + 1) + ".csv", 1, 25, weeks));
                if (strings[1].equals("-1")) {
                    strings[1] = "-";
                }
                strings[2] = Integer.toString(testDateTimely("../private/clean/log_" + (i + 1) + ".csv", 2, 1, weeks));
                if (strings[2].equals("-1")) {
                    strings[2] = "-";
                }
                strings[3] = Integer.toString(testDateTimely("../private/clean/log_" + (i + 1) + ".csv", 3, 15, weeks));
                if (strings[3].equals("-1")) {
                    strings[3] = "-";
                }
                strings[4] = Integer.toString(testDateTimely("../private/clean/log_" + (i + 1) + ".csv", 4, 1, weeks));
                if (strings[4].equals("-1")) {
                    strings[4] = "-";
                }
                strings[5] = Integer.toString(testDateTimely("../private/clean/log_" + (i + 1) + ".csv", 5, 8, weeks));
                if (strings[5].equals("-1")) {
                    strings[5] = "-";
                }
                strings[6] = Integer.toString(testDateTimely("../private/clean/log_" + (i + 1) + ".csv", 6, 15, weeks));
                if (strings[6].equals("-1")) {
                    strings[6] = "-";
                }
                strings[7] = Integer.toString(testDateTimely("../private/clean/log_" + (i + 1) + ".csv", 7, 22, weeks));
                if (strings[7].equals("-1")) {
                    strings[7] = "-";
                }
                csvWriter.writeNext(strings);
            }
            csvWriter.close();
        } catch (Exception ee) {
            ee.printStackTrace();
        }

    }

    public static int onlineMeetings (String FILE_NAME, int weeks) {

        int numOnline = 0;
        try {

            String strFile = FILE_NAME;
            CSVReader reader = new CSVReader(new FileReader(strFile));
            String[] nextLine;
            int lineNumber = 0;
            String name1 = new String();

            while ((nextLine = reader.readNext()) != null) {

                String curDate;
                if ((curDate = nextLine[1]).equals(lastDate(weeks))) {
                    reader.close();
                    return numOnline;
                }

                lineNumber++;
                name1 = nextLine[6].toString();

                if (name1.contains("Online Meeting")) {
                    numOnline++;
                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        }

        return numOnline;
    }

    public static int[] bonusActivities (String FILE_NAME, int weeks) {

        int[] bonus = new int[3];
        int quiz = 0, surveys = 0, CyberRat = 0;
        try {

            CSVReader reader = new CSVReader(new FileReader(FILE_NAME));
            String[] nextLine;
            int lineNumber = 0;
            String name1 = new String();

            while ((nextLine = reader.readNext()) != null) {

                String curDate;
                if ((curDate = nextLine[1]).equals(lastDate(weeks))) {
                    reader.close();
                    bonus[0] = quiz;
                    bonus[1] = surveys;
                    bonus[2] = CyberRat;
                    return bonus;
                }

                lineNumber++;
                name1 = nextLine[6].toString();

                if (name1.contains("Procedures Quiz")) {
                    quiz++;
                }
                if (name1.contains("Survey")) {
                    surveys++;
                }
                if (name1.contains("CyberRat")) {
                    CyberRat++;
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        }
        bonus[0] = quiz;
        bonus[1] = surveys;
        bonus[2] = CyberRat;

        return bonus;
    }

    public static double averageAct (String FILE_NAME, int weeks) {
        double average = 0;

        try {

            int count = 0;
            int test1Act = 0, test2Act = 0, test3Act = 0, test4Act = 0, test5Act = 0, test6Act = 0, test7Act = 0;
            boolean test1 = false, test2 = false, test3 = false, test4 = false, test5 = false, test6 = false,
                    test7 = false;

            CSVReader reader = new CSVReader(new FileReader(FILE_NAME));
            String[] nextLine;
            int lineNumber = 0;
            String name1 = new String();

            while ((nextLine = reader.readNext()) != null) {

                String curDate;
                if ((curDate = nextLine[1]).equals(lastDate(weeks))) {
                    reader.close();
                    average = (test1Act + test2Act + test3Act + test4Act + test5Act + test6Act + test7Act) / 7;
                    return average;
                }

                lineNumber++;
                name1 = nextLine[6].toString();

                if (name1.equals("Test #1 A") && test1 == false) {
                    test1Act = count;
                    count = 0;
                    test1 = true;
                }
                if (name1.equals("Test #2 Part #1 A") && test2 == false) {
                    test2Act = count;
                    count = 0;
                    test2 = true;
                }
                if (name1.equals("Test #3 A") && test3 == false) {
                    test3Act = count;
                    count = 0;
                    test3 = true;
                }
                if (name1.equals("Test #4 A") && test4 == false) {
                    test4Act = count;
                    count = 0;
                    test4 = true;
                }
                if (name1.equals("Test #5 A") && test5 == false) {
                    test5Act = count;
                    count = 0;
                    test5 = true;
                }
                if (name1.equals("Test #6 A") && test6 == false) {
                    test6Act = count;
                    count = 0;
                    test6 = true;
                }
                if (name1.equals("Test #7 A") && test7 == false) {
                    test7Act = count;
                    count = 0;
                    test7 = true;
                }
                count++;

            }
            average = (test1Act + test2Act + test3Act + test4Act + test5Act + test6Act + test7Act) / 7;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        }
        return average;
    }

    public static int testDateTimely (String FILE_NAME, int exam, int examDate, int weeks) throws ParseException {
        int days = 0;

        try {

            CSVReader reader = new CSVReader(new FileReader(FILE_NAME));
            String[] nextLine;
            int lineNumber = 0;
            String name1 = new String();

            while ((nextLine = reader.readNext()) != null) {

                String curDate;
                if ((curDate = nextLine[1]).equals(lastDate(weeks))) {
                    reader.close();
                    return -1;
                }

                lineNumber++;
                name1 = nextLine[6].toString();

                if (name1.contains("Test #1") && exam == 1) {
                    DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                    Date submitted;
                    submitted = df.parse(nextLine[1].toString());
                    String newDateString = df.format(submitted);
                    int dateSubmitted = submitted.getDate();
                    days = dateSubmitted - examDate;

                    return days;
                }
                if (name1.contains("Test #2") && exam == 2) {
                    DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                    Date submitted;
                    submitted = df.parse(nextLine[1].toString());
                    String newDateString = df.format(submitted);
                    int dateSubmitted = submitted.getDate();
                    days = dateSubmitted - examDate;

                    return days;
                }
                if (name1.contains("Test #3") && exam == 3) {
                    DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                    Date submitted;
                    submitted = df.parse(nextLine[1].toString());
                    String newDateString = df.format(submitted);
                    int dateSubmitted = submitted.getDate();
                    days = dateSubmitted - examDate;

                    return days;
                }
                if (name1.contains("Test #4") && exam == 4) {
                    DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                    Date submitted;
                    submitted = df.parse(nextLine[1].toString());
                    String newDateString = df.format(submitted);
                    int dateSubmitted = submitted.getDate();
                    days = dateSubmitted - examDate;

                    return days;
                }
                if (name1.contains("Test #5") && exam == 5) {
                    DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                    Date submitted;
                    submitted = df.parse(nextLine[1].toString());
                    String newDateString = df.format(submitted);
                    int dateSubmitted = submitted.getDate();
                    days = dateSubmitted - examDate;

                    return days;
                }
                if (name1.contains("Test #6") && exam == 6) {
                    DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                    Date submitted;
                    submitted = df.parse(nextLine[1].toString());
                    String newDateString = df.format(submitted);
                    int dateSubmitted = submitted.getDate();
                    days = dateSubmitted - examDate;

                    return days;
                }
                if (name1.contains("Test #7") && exam == 7) {
                    DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                    Date submitted;
                    submitted = df.parse(nextLine[1].toString());
                    String newDateString = df.format(submitted);
                    int dateSubmitted = submitted.getDate();
                    days = dateSubmitted - examDate;

                    return days;
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        }
        return days;
    }

    public static String lastDate (int weeks) {
        Calendar c = Calendar.getInstance();
        c.setTime(START_DATE);
        c.add(Calendar.DATE, (weeks * 7));
        return FORMAT_DATE.format(c.getTime());

    }
}