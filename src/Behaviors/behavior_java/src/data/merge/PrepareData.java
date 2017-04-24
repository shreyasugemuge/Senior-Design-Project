package data.merge;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class PrepareData {
    public final static double AVG_GRADE = 899.0;
    public final static String BEH_PATH = "../docs/";

    public static void main (String[] filenames) throws IOException {
        String[] gradeCol = getGrades("../private/Grades.csv");
        String[] idCol = prepIDs(gradeCol.length);
        String[] avgCol = aboveAvg(gradeCol);
        for (int i = 0; i < gradeCol.length; i++) {
            System.out.println(gradeCol[i] + "\t" + idCol[i] + "\t" + avgCol[i]);
        }
        System.out.println(gradeCol.length + " " + idCol.length + " " + avgCol.length);
        ArrayList<String[]> cols = new ArrayList<>();

        cols.add(idCol);
        cols.add(gradeCol);
        cols.add(avgCol);
        ArrayList<String[]> rows = transposeCR(cols);
        CSVWriter out = new CSVWriter(new FileWriter("merge_1.csv"));
        out.writeAll(rows);
        out.flush();
        out.close();
    }

    private static ArrayList<String[]> transposeCR (ArrayList<String[]> cols) {
        ArrayList<String[]> rows = new ArrayList<>();
        rows.add(TitleCR(cols));
        for (int j = 1; j < cols.get(0).length; j++) {
            String[] currow = new String[cols.size()];
            for (int i = 0; i < currow.length; i++) {
                currow[i] = cols.get(i)[j];
            }
            if (currow != null && currow.length > 1)
                rows.add(currow);
        }
        return rows;
    }

    private static String[] TitleCR (ArrayList<String[]> cols) {
        String[] titles = new String[cols.size()];
        for (int i = 0; i < titles.length; i++) {
            titles[i] = cols.get(i)[0];
        }
        return titles;
    }

    public static String[] prepIDs (int size) {
        String[] ids = new String[size];
        ids[0] = "ID";
        for (int i = 1; i < size; i++) {
            if (i == 10)
                i++;
            ids[i] = Integer.toString(i);
        }
        return ids;
    }

    public static String[] getGrades (String filename) throws IOException {
        CSVReader in = new CSVReader(new FileReader(filename));
        String[] col;
        in.readNext();
        String[] gr = new String[112];
        gr[0] = "Overall Grade";
        for (int i = 1; i < 112; i++) {
            if (i == 10) {
                i++;
            }
            col = in.readNext();
            gr[i] = col[1];
        }

        return gr;
    }

    private static String[] aboveAvg (String[] grades) {
        String[] yn = new String[grades.length];
        yn[0] = "Above Average?";
        for (int i = 1; i < grades.length; i++) {
            if (i == 10) {
                i++;
            }
            try {
                yn[i] = (Double.parseDouble(grades[i]) >= AVG_GRADE ? "Y" : "N");
            } catch (Exception e) {
                yn[i] = "N";
            }

        }
        return yn;
    }
}
