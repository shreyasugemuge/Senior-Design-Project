package merge;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class PrepareData {
    public final static double AVG_GRADE = 899.0;
    public final static String BEH_PATH = "../docs/";

    public static void main (String[] args) throws IOException {
        String[] gradeCol = getGrades("../private/Grades.csv");
        String[] idCol = prepIDs(gradeCol.length);
        String[] avgCol = aboveAvg(gradeCol);
        ArrayList<String[]> behCol = new ArrayList<>();
        behCol.add(gradeCol);
        behCol.add(avgCol);
        toFile(gradeCol, avgCol);
    }

    public static void toFile (String[] a, String[] b) throws IOException {
        CSVWriter out = new CSVWriter(new FileWriter("../GradeHelp.csv"));
        for (int i = 0; i < a.length; i++) {
            String[] row = { a[i], b[i] };
            out.writeNext(row);
        }
        out.close();
    }

    public static ArrayList<String[]> behaviorsFromFile (String filename) throws IOException {
        CSVReader in = new CSVReader(new FileReader(BEH_PATH + filename));
        ArrayList<String[]> behCols = new ArrayList<>();
        ArrayList<Integer> indices = new ArrayList<>();
        String[] col = in.readNext();
        // System.out.println(col.length);
        int currow = 1;
        for (int i = 0; i < col.length; i++) {
            if (col[i] != null && !col[i].equals("X") && !col[i].equals("") && !col[i].equals("ID")) {
                String[] thisBeh = new String[112];
                thisBeh[0] = filename.substring(0, filename.length() - 4) + "_" + col[i];
                System.out.println(thisBeh[0]);
                behCols.add(thisBeh);
                indices.add(i);
            }
        }
        System.out.println(indices.size() + " " + behCols.size());
        while ((col = in.readNext()) != null) {
            System.out.println(col.length);
            for (int i = 0; i < indices.size(); i++) {
                System.out.println(col[indices.get(i)]);
            }
            currow++;
        }
        in.close();
        return behCols;
    }

    public static String[] prepIDs (int size) {
        String[] ids = new String[size];
        ids[0] = "ID";
        for (int i = 0; i < size; i++) {
            ids[i] = Integer.toString(i);
        }
        return ids;
    }

    public static String[] getGrades (String filename) throws IOException {
        CSVReader in = new CSVReader(new FileReader(filename));
        String[] col;
        in.readNext();
        ArrayList<String> gr = new ArrayList<String>();
        gr.add("Overall Grade");
        for (int i = 1; i <= 111; i++) {
            if (i == 10)
                gr.add("-");
            else {
                col = in.readNext();
                gr.add(col[1]);
            }
        }
        return gr.toArray(new String[112]);
    }

    private static String[] aboveAvg (String[] grades) {
        String[] yn = new String[grades.length];
        yn[0] = "Above Average?";
        for (int i = 0; i < grades.length; i++) {
            try {
                yn[i] = (Double.parseDouble(grades[i]) >= AVG_GRADE ? "Y" : "N");

            } catch (Exception e) {
                yn[i] = "N";
            }
        }
        return yn;
    }
}
