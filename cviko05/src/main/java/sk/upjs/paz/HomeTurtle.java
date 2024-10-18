package sk.upjs.paz;

import sk.upjs.jpaz2.Turtle;

public class HomeTurtle extends Turtle {


    public String longestPref(String s1, String s2) {
        StringBuilder prefix = new StringBuilder();
//        prefix= new StringBuilder();
        int dlzka = Math.min(s1.length(), s2.length());
        System.out.println(dlzka);

        for (int i = 0; i < dlzka; i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                prefix.append(s1.charAt(i));
            }
        }
        return prefix.toString();
    }

    public String toEmailAddress(String name) {
        StringBuilder finalAdress = new StringBuilder();
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) == ' ') {
                finalAdress.append('.');
            } else {
                finalAdress.append(name.charAt(i));
            }
        }
        finalAdress.append("@upjs.sk");
        return finalAdress.toString().toLowerCase();
    }

    public int countAcronyms(String r) {
        int counter = 0;
        int finalCount = 0;
        for (int i = 0; i < r.length(); i++) {
            if (r.charAt(i) >= 'A' && r.charAt(i) <= 'Z') {
                counter++;
                if (counter == 3) {
                    finalCount++;
                }
            } else {
                counter = 0;
            }
        }
        return finalCount;
    }

    public String replaceNumbers(String s, String replacement) {
        StringBuilder sb = new StringBuilder();
        String part = s;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(part.charAt(i))) {
                sb.append(replacement.charAt(i));

            } else {
                sb.append(part.charAt(i));
            }
        }
        return sb.toString();
    }

    public String sanitize(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                sb.append(s.charAt(0));
            } else {
                if (s.charAt(i) == s.charAt(i - 1)) {
                    continue;
                } else {
                    sb.append(s.charAt(i));
                }
            }

        }
        return sb.toString();
    }

}
