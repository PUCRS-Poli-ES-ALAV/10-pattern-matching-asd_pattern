package StringMatching;


public class Solve {

    public static boolean findMatch (String s1, String s2) {
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        if (s2.length() > s1.length()) {
            String temp = s1;
            s1 = s2;
            s2 = temp;
        }

        int iterations = 0;
        for (int i = 0; i < s1.length() - s2.length(); i++) {
            iterations++;
            // System.out.println("substring = " + s1.substring(i, s2.length() + i));
            if (s1.charAt(i) == s2.charAt(0)            // primeiro caractere igual
                && s1.substring(i,s2.length() + i).equals(s2))  // restante da string igual
            {
                // então s2 está em s1
                System.out.println("String [" + s2 + "] encontrada em [" + s1 + "].");
                System.out.println("iterations = " + iterations);
                return true;
            }
        }
        System.out.println("String [" + s2 + "] não encontrada em [" + s1 + "].");
        return false;
    }
}
