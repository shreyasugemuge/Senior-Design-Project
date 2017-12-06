import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class mainClass {

    public static void main (String[] args) throws IOException {
        int percent = Integer.parseInt(args[0]);
        int weeks = Integer.parseInt(args[1]);
        BufferedReader br = new BufferedReader(new FileReader(new File("data/merge/merge_" + weeks + ".csv")));
        toTrain(br, percent);
        br = new BufferedReader(new FileReader(new File("data/test.csv")));
        toYN(br);
    }

    private static void toYN (BufferedReader br) throws IOException {
        BufferedWriter y = new BufferedWriter(new FileWriter(new File("data/misc/y.csv")));
        BufferedWriter n = new BufferedWriter(new FileWriter(new File("data/misc/n.csv")));
        HashMap<Integer, String> m = getStudents(new BufferedReader(new FileReader("pred.csv")));
        String fl[] = br.readLine().split(",");
        String col[];
        double county = 0;
        double countn = 0;
        double[] sumcoly = new double[16];
        double[] sumcoln = new double[16];
        for (int i = 0; i < 16; i++) {
            sumcoly[i] = 0;
            sumcoln[i] = 0;
        }
        String row;
        String first = "", temp = "";
        for (int i = 0; i < fl.length; i++)
            first += fl[i] + (i == fl.length - 1 ? "\n" : ",");
        y.write(first);
        n.write(first);
        while ((row = br.readLine()) != null) {
            col = row.split(",");
            for (int k = 0; k < col.length; k++)
                temp += col[k] + (k == col.length - 1 ? "\n" : ",");
            if (col[col.length - 1].equals("Y")) {
                for (int i = 1; i < col.length - 1; i++) {
                    sumcoly[i - 1] += Double.parseDouble(col[i]);
                }
                y.write(temp);
                county++;
                y.flush();
            } else {
                n.write(temp);
                for (int i = 1; i < col.length - 1; i++) {
                    sumcoln[i - 1] += Double.parseDouble(col[i]);
                }
                countn++;
                n.flush();
            }
            temp = "";
        }
        for (int i = 0; i < 16; i++) {
            sumcoly[i] = sumcoly[i] / county;
            sumcoln[i] = sumcoln[i] / countn;
        }
        summary(fl, sumcoly, sumcoln);
        y.close();
        n.close();
    }

    private static HashMap<Integer, String> getStudents (BufferedReader br) throws IOException {
        HashMap<Integer, String> m = new HashMap<>();
        br.readLine();
        String temp = "";
        String[] cols;
        while ((temp = br.readLine()) != null) {
            cols = temp.split(",");
            m.put(Integer.parseInt(cols[1]), cols[2]);
        }
        return m;
    }

    private static void summary (String[] fl, double[] sumcoly, double[] sumcoln) throws IOException {
        BufferedWriter br = new BufferedWriter(new FileWriter(new File("data/misc/summary.csv")));

        String first = "", temp = "";
        for (int i = 1; i < fl.length - 1; i++)
            first += fl[i] + (i == fl.length - 2 ? "\n" : ",");
        br.write(first);

        for (int k = 0; k < sumcoly.length; k++)
            temp += sumcoly[k] + (k == sumcoly.length - 1 ? "\n" : ",");
        br.write(temp);

        temp = "";
        for (int k = 0; k < sumcoln.length; k++)
            temp += sumcoln[k] + (k == sumcoln.length - 1 ? "\n" : ",");
        br.write(temp);

        br.close();
    }

    private static void toTrain (BufferedReader br, int i) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("data/train.csv")));
        String row;
        String[] col;
        String temp = "";
        String fl[] = br.readLine().split(",");
        String first = "";
        for (int k = 0; k < fl.length; k++)
            first += fl[k] + (k == fl.length - 1 ? "\n" : ",");
        bw.write(first);
        // bw.flush();
        while (i-- > 1 && (row = br.readLine()) != null) {
            col = row.split(",");
            for (int k = 0; k < col.length; k++)
                temp += col[k] + (k == col.length - 1 ? "\n" : ",");
            bw.write(temp);
            temp = "";
            // bw.flush();
        }
        bw.close();
        bw = new BufferedWriter(new FileWriter(new File("data/test.csv")));
        bw.write(first);
        // bw.flush();
        while ((row = br.readLine()) != null) {
            col = row.split(",");
            for (int k = 0; k < col.length; k++)
                temp += col[k] + (k == col.length - 1 ? "\n" : ",");
            bw.write(temp);
            temp = "";
            // bw.flush();
        }
        bw.close();

    }

}
