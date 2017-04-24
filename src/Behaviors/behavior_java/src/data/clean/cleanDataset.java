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
    final static File DIR_CLEAN = new File("../private/clan/");

    public static void main (String[] args) throws Exception { // bad error
                                                               // handling but
                                                               // meh
        String[] cur;
        int logCount = 1;
        System.out.print(DIR_CLEAN.mkdir() ? "Creating new folder:" + DIR_CLEAN.getPath() + '\n' : "");
        File[] files = getAllMatchingFromDir(DIR_ALLLOGS, ALLLOGS_REGEX);
        for (File f : files) {
            CSVReader in = new CSVReader(new FileReader(f));
            CSVWriter out = new CSVWriter(new FileWriter(DIR_CLEAN.getName() + "log_" + logCount++ + ".csv"));
            out.writeNext(handleTitles(in.readNext()));
            while ((cur = in.readNext()) != null)
                out.writeNext(cleanRow(cur));
            in.close();
            out.close();
        }
    }

    private static String[] cleanRow (String[] cur) {
        System.out.println(cur.length);
        if (cur.length >= 6 && cur[5] == cur[6])
            cur[6] = "";

        return cur;
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
