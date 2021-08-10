package view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    private static Validate instance;

    private Validate() {
    }

    public static Validate getInstance() {
        if (instance == null) {
            instance = new Validate();
        }
        return instance;
    }

    public boolean validate(String string, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }
}
