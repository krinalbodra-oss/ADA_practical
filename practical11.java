public class MatrixChainMultiplication {
    public static void main(String[] args) {
        int[] p = {1, 2, 3, 4};
        int n = p.length;

        int[][] m = new int[n][n];

        for (int L = 2; L < n; L++) {
            for (int i = 1; i < n - L + 1; i++) {
                int j = i + L - 1;
                m[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    int q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (q < m[i][j]) {
                        m[i][j] = q;
                    }
                }
            }
        }

        System.out.println("Minimum number of multiplications: " + m[1][n - 1]);
    }
}
