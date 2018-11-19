import java.util.*;

public class Main {
    static Random R = new Random();
    static int count = 1000;
    static HashSet<String> set = new HashSet<String>();
    static ArrayList<String> list = new ArrayList<String>();

    public static void main(String[] args) {
        for (int i = 0; i < count; i++) {
            String wort = rule1();
//            String wort = "0AZ0";
            String shorted = shortener(wort);
            if (!set.contains(shorted)) {
                set.add(shorted);
            }
            if (!list.contains(shorted)) {
                list.add(shorted);
            }
//            System.out.println(rule1());

//            System.out.println(shorted);
        }
//        for (String aSet : set) {
//            System.out.println(aSet);
//        }
        Collections.sort(list);
        for (String i : list) {
            System.out.println(i);
        }

    }

    private static String shortener(String wort) {
        boolean gekürzt = true;

        while (gekürzt) {
            gekürzt = false;
            for (int i = 0; i < wort.length() - 1; i++) {
                String substring = wort.substring(i, i + 2);
                if (substring.equals("AZ")) {
                    gekürzt = true;
                    wort = wort.replace("AZ", "Z1");
                    break;
                } else if (substring.equals("BZ")) {
                    gekürzt = true;
                    wort = wort.replace("BZ", "Z0");
                    break;
                } else if (substring.equals("1Z")) {
                    gekürzt = true;
                    wort = wort.replace("1Z", "1");
                    break;
                } else if (substring.equals("0Z")) {
                    gekürzt = true;
                    wort = wort.replace("0Z", "0");
                    break;
                }

            }
        }
        return wort;

    }

    private static String rule1() {
        int a = R.nextInt(2);
        if (a == 0) {
            return "0" + rule2() + "0";
        } else {
            return "1" + rule3() + "1";
        }

    }

    private static String rule2() {
        int a = R.nextInt(3);
        if (a == 0) {
            return "A" + rule2();
        } else if (a == 1) {
            return "B" + rule2();
        } else {
            return "Z";
        }
    }

    private static String rule3() {
        int a = R.nextInt(2);
        if (a == 0) {
            return "Z";
        } else {
            return "A" + rule3();
        }
    }


}
