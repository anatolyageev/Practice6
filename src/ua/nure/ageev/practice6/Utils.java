package ua.nure.ageev.practice6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    private static final String PATTERN = "[a-zA-Z]+";
    public static String getInitInfo(String fileName, String charset){
        StringBuilder stringBuilder = new StringBuilder();
        try (Scanner scanner = new Scanner(new File(fileName), charset)) {
            while (scanner.hasNext()) {
                stringBuilder.append(scanner.next()).append(" ");
            }
        } catch (FileNotFoundException e) {
            System.err.println(String.format("%s not found", fileName));
        }

        StringBuilder sb = new StringBuilder();
        gettingWordsOnly(stringBuilder, sb);

        return sb.toString();
    }

    private static void gettingWordsOnly(StringBuilder stringBuilder, StringBuilder sb) {
        Pattern p = Pattern.compile(PATTERN);
        Matcher m = p.matcher(stringBuilder);
        while (m.find()) {
            sb.append(m.group() + " ");
        }
    }


}
