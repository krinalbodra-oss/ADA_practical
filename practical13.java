public class SCS {
    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) dp[i][0] = i;
        for (int j = 0; j <= n; j++) dp[0][j] = j;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println("Length of SCS: " + dp[m][n]);

        int i = m, j = n;
        String scs = "";

        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                scs = s1.charAt(i - 1) + scs;
                i--;
                j--;
            } else if (dp[i - 1][j] < dp[i][j - 1]) {
                scs = s1.charAt(i - 1) + scs;
                i--;
            } else {
                scs = s2.charAt(j - 1) + scs;
                j--;
            }
        }

        while (i > 0) {
            scs = s1.charAt(i - 1) + scs;
            i--;
        }

        while (j > 0) {
            scs = s2.charAt(j - 1) + scs;
            j--;
        }

        System.out.println("SCS: " + scs);
    }
}
