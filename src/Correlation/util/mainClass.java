import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class mainClass {

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("data/merge.csv")));
        switch (Integer.parseInt(args[1])) {
        case 2:
            // toTrain2(br, Integer.parseInt(args[0]));
            break;
        case 1:
            toTrain(br, Integer.parseInt(args[0]));
            break;
        default:
            System.err.println("argument error");
            System.exit(1);
        }
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
        bw.flush();
        while (i-- > 1 && (row = br.readLine()) != null) {
            col = row.split(",");
            for (int k = 0; k < col.length; k++)
                temp += col[k] + (k == col.length - 1 ? "\n" : ",");
            bw.write(temp);
            bw.flush();
        }
        bw.close();
        bw = new BufferedWriter(new FileWriter(new File("data/test.csv")));
        bw.write(first);
        bw.flush();
        while ((row = br.readLine()) != null) {
            col = row.split(",");
            for (int k = 0; k < col.length; k++)
                temp += col[k] + (k == col.length - 1 ? "\n" : ",");
            bw.write(temp);
            bw.flush();
        }
        bw.close();

    }

}
