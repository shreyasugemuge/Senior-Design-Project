import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class mainClass {

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("merge.csv")));
        toTrain(br, Integer.parseInt(args[0]));

    }

    private static void toTrain (BufferedReader br, int i) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("train.csv")));
        String row;
        String[] col;
        String fl[] = br.readLine().split(",");
        String first = fl[0] + "," + fl[1] + "," + fl[2] + "," + fl[3] + "," + fl[fl.length - 1] + "\n";
        bw.write(first);
        while (i-- > 1 && (row = br.readLine()) != null) {
            col = row.split(",");
            bw.write(col[0] + "," + col[1] + "," + col[2] + "," + col[3] + "," + col[col.length - 1] + "\n");
        }
        bw.close();
        bw = new BufferedWriter(new FileWriter(new File("test.csv")));
        bw.write(first);
        while ((row = br.readLine()) != null) {
            col = row.split(",");
            bw.write(col[0] + "," + col[1] + "," + col[2] + "," + col[3] + "," + col[col.length - 1] + "\n");
        }
        bw.close();

    }

}
