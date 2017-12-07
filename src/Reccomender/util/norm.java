import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class norm {
    public static void main (String[] args) throws IOException {
        Double[][] a = new Double[110][16];
        Double[] means = new Double[16];
        Double[] stdevs = new Double[16];

        for (int i = 1; i <= 13; i++) {
            BufferedReader br = new BufferedReader(new FileReader("../data/merge/merge_" + i + ".csv"));
            a = b(br);
            for (int j = 0; j < a[0].length; j++) {
                double sum = 0;
                for (int k = 0; k < a.length; k++) {
                    sum += a[k][j];
                }
                means[j] = new Double(sum / 110);
            }

        }

    }

    private static Double[][] b (BufferedReader br) throws IOException {
        String temp = br.readLine();
        String[] col;
        Double[][] aa = new Double[110][16];
        int row = 0;
        while ((temp = br.readLine()) != null) {
            col = temp.split(",");
            for (int i = 1; i <= 16; i++) {
                aa[row][i - 1] = Double.parseDouble(col[i]);
            }
            row = (row + 1) % 110;
        }
        return aa;
    }
}
