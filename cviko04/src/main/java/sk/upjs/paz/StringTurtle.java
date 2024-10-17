package sk.upjs.paz;

import sk.upjs.jpaz2.Turtle;

public class StringTurtle extends Turtle {

    public String unicharString(char c, int n) {
        String s1 = "";


        return s1;
    }


    public boolean isUnicharString(String s) {
        boolean jeGood = true;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                return false;
            }
        }

        return true;
    }

    public String duplicateChars(String s) {
        String s1 = "";


        return s1;
    }

    public String removeExtraSpaces(String s) {
        String result = "";
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == ' ' && s.charAt(i + 1) == ' ') {
                continue;
            } else {
                result += s.charAt(i);
            }

        }
        return result;
    }

    public int countWords(String s) {


        return 0;
    }


}
