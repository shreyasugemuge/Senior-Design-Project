package data.merge;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class merge {

    public static void main (String[] args) throws IOException {
        for (int i = 1; i <= 13; i++) {
            File f1 = new File("../docs/Shreyas/" + i + ".csv");
            File f2 = new File("../docs/ShiruHou/" + i + ".csv");
            File f3 = new File("../docs/Mohammed/" + i + ".csv");
            File outf = new File("../docs/merge_" + i + ".csv");
            CSVReader c1 = new CSVReader(new FileReader(f1));
            CSVReader c2 = new CSVReader(new FileReader(f2));
            CSVReader c3 = new CSVReader(new FileReader(f3));
            CSVWriter o = new CSVWriter(new FileWriter(outf));
            String[] cs = c1.readNext();
            String[] ch = c2.readNext();
            String[] cm = c3.readNext();
            // String[] outRow;
            for (int k = 0; k < 111; k++) {
                // while ((cs = c1.readNext()) != null && (ch = c2.readNext())
                // != null && (cm = c3.readNext()) != null) {
                String[] outRow = { cs[0], cs[1], cs[2], cs[3], cs[4], cs[21], cs[cs.length - 1], ch[1], ch[2], ch[3],
                        cm[2], cm[3], cm[4], cm[5], cm[6], cm[7], cm[8] };
                o.writeNext(outRow);
                cs = c1.readNext();
                ch = c2.readNext();
                cm = c3.readNext();
            }

            o.close();
            c1.close();
            c2.close();
            c3.close();
        }
    }
}