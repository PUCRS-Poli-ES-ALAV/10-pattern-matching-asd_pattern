package StringMatching;
public class Main {
    public static void main(String[] args) {
        String s1 = "aaaaaaaaaaaaaaaaaaaaaaaaaa";
        String s2 = "aaaaab";

        Solve.findMatch(s1, s2);
        Solve.rabinKarp(s2, s1);
    }
}