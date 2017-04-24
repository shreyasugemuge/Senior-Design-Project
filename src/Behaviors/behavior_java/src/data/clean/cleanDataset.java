package data.clean;

import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.regex.Pattern;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class cleanDataset {
    final static String ALLLOGS_REGEX = "^Learner_Profile_Activity_Logs \\(\\d|\\d\\d|\\d\\d\\d\\)\\.csv$";
    final static File DIR_ALLLOGS = new File("../private/alllogs/");
    final static File DIR_CLEAN = new File("../private/clean/");

    public static void main (String[] args) throws Exception { // bad error
                                                               // handling but
                                                               // meh
        String[] cur;
        System.out.print(DIR_CLEAN.mkdir() ? "Creating new folder:" + DIR_CLEAN.getPath() + '\n' : "");
        File[] files = getAllMatchingFromDir(DIR_ALLLOGS, ALLLOGS_REGEX);
        for (File f : files) {
            CSVReader in = new CSVReader(new FileReader(f));
            CSVWriter out = new CSVWriter(
                    new FileWriter("../private/clean/log_" + f.getName().split("\\(|\\)")[1] + ".csv"));
            out.writeNext(handleTitles(in.readNext()));
            while ((cur = in.readNext()) != null && cur[0] != null && !cur[0].contains("4/13/2013"))
                out.writeNext(cleanRow(cur));
            // System.out.println(logCount + " " + cur[1]);
            in.close();
            out.flush();
            out.close();
        }
    }

    private static String[] cleanRow (String[] cur) {
        if (cur.length >= 6 && cur[5] == cur[6])
            cur[6] = "";

        String[] cur2 = new String[cur.length + 1];
        cur2[0] = "";
        for (int i = 1; i < cur2.length; i++) {
            cur2[i] = cur[i - 1];
        }
        return cur2;
    }

    private static String[] handleTitles (String[] titles) {
        String newTitles[] = { "", "Date", "Activity_Count", "Date_Active", "Time", "Activity", "Object_Title",
                "Quiz_Title" };
        return newTitles;
    }

    public static File[] getAllMatchingFromDir (File dir, String regex) {
        if (!dir.isDirectory())
            throw new IllegalArgumentException(
                    dir + "is not a directory, please choose a directory path where the files are stored");
        final Pattern regexp = Pattern.compile(regex);
        return dir.listFiles(new FileFilter() {
            @Override
            public boolean accept (File pathname) {
                return regexp.matcher(pathname.getName()).find();
            }

        });

    }
}
