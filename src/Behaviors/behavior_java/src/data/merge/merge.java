package data.merge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class merge {
    static int weeks = 13;

    public static void main (String[] args) throws IOException {
        String[] fileNames = parse(args);
        String processedData = processFiles(fileNames);
        toCSV(processedData, weeks);
    }

    private static void toCSV (String processedData, int weeks) throws IOException {
        File file = new File("../docs/merge_" + weeks + ".csv");
        file.createNewFile();
        PrintWriter pr = new PrintWriter(file);
        pr.print(processedData);
        pr.close();
    }

    private static String processFiles (String[] fileNames) throws IOException {
        String[] rows = new String[111];
        boolean firstFile = true;
        for (String name : fileNames) {
            File file = new File(name);
            BufferedReader csv = new BufferedReader(new FileReader(file));
            for (int i = 0; i < 111; i++) {
                String[] temp = csv.readLine().split(",");
                if (firstFile) {
                    rows[i] = processArrRow(temp);
                } else
                    rows[i] += "," + processArrRow(temp);
            }
            firstFile = false;
        }
        return processArrFile(rows);
    }

    private static String processArrFile (String[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i] + (i == arr.length - 1 ? "" : "\n"));
        }
        return sb.toString();
    }

    private static String processArrRow (String[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i] + (i == arr.length - 1 ? "" : ","));
        }
        return sb.toString();
    }

    private static String[] parse (String[] args) {
        if (args.length != 1) {
            System.out.println("use 1 number to represent number of weeks as argument");
            return null;
        } else {
            weeks = Integer.parseInt(args[0]);
            return new String[] { "../docs/Shreyas/" + weeks + ".csv" };
            // return new String[] { "../docs/Shreyas/" + weeks + ".csv",
            // "../docs/Mohammed/" + weeks + ".csv",
            // "../docs/Yaqeen/" + weeks + ".csv", "../docs/ShiruHou/" + weeks +
            // ".csv" };
        }

    }

}
