import java.util.Scanner;

public class Main {

    public static int[] computeLPSArray(String s) {
        int n = s.length();
        int[] lps = new int[n];
        int len = 0;
        int i = 1;
        
        while (i < n) {
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1]; 
                    } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    public static String longestHappyPrefix(String s) {
        int n = s.length();
        int[] lps = computeLPSArray(s);
        
        int len = lps[n - 1];
        if (len > 0) {
            return s.substring(0, len);
        } else {
            return "";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);     
        String s = sc.nextLine();
 
        System.out.println(longestHappyPrefix(s));
        sc.close();
    }
}
