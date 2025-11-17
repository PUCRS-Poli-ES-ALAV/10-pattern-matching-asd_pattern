package StringMatching;
public class Main {
    public static void main(String[] args) {
        String s1 = "paralelepipedo";
        String s2 = "lep";

        Solve.findMatch(s1, s2);
        Solve.rabinKarp(s2, s1);
        Solve.KMPsearch(s2,s1);
    }
}