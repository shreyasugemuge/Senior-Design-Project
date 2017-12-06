package rec;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Reccomend_n {
    public static void main (String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        HashMap<String, Double[]> m = new HashMap<String, Double[]>();
        BufferedReader br = new BufferedReader(new FileReader("data/misc/n.csv"));
        BufferedReader bs = new BufferedReader(new FileReader("data/misc/summary.csv"));
        BufferedReader ba = new BufferedReader(new FileReader("data/priority.csv"));
        String[] pr = getpri(ba);
        String[] ft = bs.readLine().split(",");
        String[] n = bs.readLine().split(",");
        String first = br.readLine(), temp = "";
        String fl[] = first.split(",");
        String col[];
        while ((temp = br.readLine()) != null) {
            col = temp.split(",");
            sb.append("id:" + col[0] + "\n\n");
            sb.append("Performance: Below Median\n\n\n");
            for (int i = 0; i < n.length; i++) {
                Double[] a = { Double.parseDouble(col[i + 1]), Double.parseDouble(n[i]) };
                m.put(ft[i], a);
            }
            for (String s : pr) {
                Double[] cur = m.get(s);
                if (cur[0] < cur[1])
                    sb.append(s + ":\ncurrent:" + cur[0] + "\nsuggested:" + cur[1] + "\n\n\n");
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter("rec/" + col[0] + ".txt"));
            bw.write(sb.toString());
            sb = new StringBuilder();
            bw.flush();
        }

    }

    private static String[] getpri (BufferedReader ba) throws IOException {
        ba.readLine();
        ArrayList<String> p = new ArrayList<>();
        String temp = "";
        while ((temp = ba.readLine()) != null) {
            String[] col = temp.split(",");
            p.add(col[1]);
        }

        return p.toArray(new String[0]);
    }
}
