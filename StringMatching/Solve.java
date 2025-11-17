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
        for (int i = 0; i < s1.length() - s2.length() + 1; i++) {
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
        System.out.println("iterations = " + iterations);
        
        return false;
    }

    public static boolean rabinKarp (String pat, String txt) {
        int M = pat.length();
        int N = txt.length();

        int iterations = 0;

        long patHash = hornerHash(pat, M);

        for (int i = 0; i <= N - M; i++) {
            iterations++;
            long txtHash = hornerHash(txt.substring(i, i+M), M);
            if (patHash == txtHash) {
                System.out.printf("String [%s] encontrada em [%s].\n", pat, txt);
                System.out.println("iterations = " + iterations);
                return true;
            }
        }

        System.out.printf("String [%s] não encontrada em [%s].\n", pat, txt);
        System.out.println("iterations = " + iterations);

        return false;
    }

    private static long hornerHash(String s, int M) {
        int Q = (int)Math.pow(2,31) - 1; // = 2147483647
        int R = 25; // alfabeto = 26 letras (indexando 0: 25)
        long h = 0;
        for (int j = 0; j < M; j++) {
            h = (h * R + s.charAt(j)) % Q;
        }
        return h;
    }

    public static void KMPsearch(String pat, String txt) {
        int M = pat.length(), N = txt.length();

        // lps guarda maior prefixo sufixo para o padrao
        int lps[] = new int[M];
        int j = 0; // index para pat[]

        computeLPSArray(pat, M, lps);

        int i = 0, iterations = 0;
        while (i < N) {
            iterations++;
            if (pat.charAt(j) == txt.charAt(i)) {
                // caractere igual
                j++;
                i++;
            }

            if (j == M) {
                // string igual
                System.out.printf("String [%s] encontrada em [%s].\n", pat, txt);
                System.out.println("Iterations = " + iterations);
                j = lps[j - 1];
                return;
            }

            else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                // caractere diferente
                if (j != 0) j = lps[j - 1];
                else i = i + 1;
            }
        }

        System.out.printf("String [%s] não encontrada em [%s].\n", pat, txt);
        System.out.println("Iterations = " + iterations);
    }

    private static void computeLPSArray(String pat, int M, int[] lps) {
        int len = 0;
        int i = 1;
        lps[0] = 0;

        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                // caracteres iguas
                len++;
                lps[i] = len;
                i++;
            }
            else {
                // caracteres diferentes
                if (len != 0) {
                    len = lps[len - 1];
                }
                else {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }
}
