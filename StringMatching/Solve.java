package StringMatching;

public class Solve {
    public static boolean findMatch (String s1, String s2) {
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
        int iterations = 0;
        boolean found = true;
        for (int i = 0; i < s1.length(); i++) {
            iterations++;
            found = true;
            for (int j = 0; j < s2.length(); j++, i++) {
                iterations++;
                if (s1.charAt(i) != s2.charAt(j)) {
                    found = false;
                    break;
                }
            }

            if (found) {
                System.out.println("String [" + s2 + "] encontrada em [" + s1 + "]");
                break;
            }
        }

        System.out.println("iterations = " + iterations);
        return found;
    }
}
