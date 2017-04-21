package com.mkyong;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class Behaviors {

    public static void main (String[] args) {

        try {
            CSVWriter csvWriter = new CSVWriter(new FileWriter("OnlineMeetings.csv"));

            String[] row = new String[] { "ID", "Online meetings attended" };
            csvWriter.writeNext(row);

            String[] strings = new String[2];
            for (int i = 0; i < 110; i++) {
                strings[0] = Integer.toString(i + 1);
                strings[1] = Integer.toString(onlineMeetings("clean/log_" + (i + 1) + ".csv"));
                csvWriter.writeNext(strings);
            }
            csvWriter.close();
        } catch (Exception ee) {
            ee.printStackTrace();
        }

        try {
            CSVWriter csvWriter = new CSVWriter(new FileWriter("testAverageAct.csv"));

            String[] row = new String[] { "ID", "Average number of activites accessed before each test" };
            csvWriter.writeNext(row);

            String[] strings = new String[2];
            for (int i = 0; i < 110; i++) {
                strings[0] = Integer.toString(i + 1);
                strings[1] = Double.toString(averageAct("clean/log_" + (i + 1) + ".csv"));
                csvWriter.writeNext(strings);
            }
            csvWriter.close();
        } catch (Exception ee) {
            ee.printStackTrace();
        }

        try {
            CSVWriter csvWriter = new CSVWriter(new FileWriter("bonusActivities.csv"));

            String[] row = new String[] { "ID", "Procedures Quiz", "Surveys", "CyberRat Assignments" };
            csvWriter.writeNext(row);

            String[] strings = new String[4];
            for (int i = 0; i < 110; i++) {

                int[] data = bonusActivities("clean/log_" + (i + 1) + ".csv");
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
    }

    public static int onlineMeetings (String FILE_NAME) {

        int numOnline = 0;
        try {

            String strFile = FILE_NAME;
            CSVReader reader = new CSVReader(new FileReader(strFile));
            String[] nextLine;
            int lineNumber = 0;
            String name1 = new String();

            while ((nextLine = reader.readNext()) != null) {

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

    public static int[] bonusActivities (String FILE_NAME) {

        int[] bonus = new int[3];
        int quiz = 0, surveys = 0, CyberRat = 0;
        try {

            CSVReader reader = new CSVReader(new FileReader(FILE_NAME));
            String[] nextLine;
            int lineNumber = 0;
            String name1 = new String();

            while ((nextLine = reader.readNext()) != null) {

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

    public static double averageAct (String FILE_NAME) {
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

}