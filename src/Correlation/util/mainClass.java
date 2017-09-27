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
                toTrain2(br, Integer.parseInt(args[0]));
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
        String fl[] = br.readLine().split(",");
        String first = fl[0] + "," + fl[1] + "," + fl[2] + "," + fl[3] + "," + fl[4] + "," + fl[5] + ","+  fl[fl.length - 1] + "\n";
        bw.write(first);
        bw.flush();
        while (i-- > 1 && (row = br.readLine()) != null) {
            col = row.split(",");
            bw.write(col[0] + "," + col[1] + "," + col[2] + "," + col[3] + "," + col[4] + ","  + col[5] + "," +col[col.length - 1] + "\n");
            bw.flush();
        }
        bw.close();
        bw = new BufferedWriter(new FileWriter(new File("data/test.csv")));
        bw.write(first);
        bw.flush();
        while ((row = br.readLine()) != null) {
            col = row.split(",");
            bw.write(col[0] + "," + col[1] + "," + col[2] + "," + col[3] + "," + col[4] + "," + col[5] + "," + col[col.length - 1] + "\n");
            bw.flush();
        }
        bw.close();

    }

    private static void toTrain2 (BufferedReader br, int i) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("data/train.csv")));
        BufferedWriter bw2 = new BufferedWriter(new FileWriter(new File("data/test.csv")));
        int ys = 0, ns = 0;
        String row;
        String[] col;
        String fl[] = br.readLine().split(",");
        String first = fl[0] + "," + fl[1] + "," + fl[2] + "," + fl[3] + "," + fl[4] + "," + fl[5] + ","+  fl[fl.length - 1] + "\n";
        bw.write(first);
        bw2.write(first);
        while ((row = br.readLine()) != null) {
            col = row.split(",");
            if (col[col.length - 1].toString().equals("Y")) {
                ys++;
                if (ys > i / 2) {
                    bw2.write(col[0] + "," + col[1] + "," + col[2] + "," + col[3] + "," + col[4] + "," + col[5] + "," + col[col.length - 1] + "\n");
                    bw2.flush();
                    continue;
                } else {
                    bw.write(col[0] + "," + col[1] + "," + col[2] + "," + col[3] + "," + col[4] + "," + col[5] + "," + col[col.length - 1] + "\n");
                    bw.flush();
                    continue;
                }
            } else {
                ns++;
                if (ns > i / 2) {
                    bw2.write(col[0] + "," + col[1] + "," + col[2] + "," + col[3] + "," + col[4] + "," + col[5] + "," + col[col.length - 1] + "\n");
                    bw2.flush();
                    continue;
                } else {
                    bw.write(col[0] + "," + col[1] + "," + col[2] + "," + col[3] + "," + col[4] + "," + col[5] + "," + col[col.length - 1] + "\n");
                    bw.flush();
                    continue;
                }
            }
        }
        while ((row = br.readLine()) != null) {
            col = row.split(",");
            bw2.write(col[0] + "," + col[1] + "," + col[2] + "," + col[3] + "," + col[4] + "," + col[5] + "," + col[col.length - 1] + "\n");
        }
        System.out.println("n: " + ns + " y: " + ys);
        bw.close();
        bw2.close();
    }

}
