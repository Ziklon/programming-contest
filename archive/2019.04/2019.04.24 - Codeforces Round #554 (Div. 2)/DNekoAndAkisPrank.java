package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.misc.ArrayUtils;

public class DNekoAndAkisPrank {
    static int MOD = (int) (1e9 + 7);


    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int[][] dp = new int[n + 1][n + 1];

        dp[0][0] = 1;

        long ans = 0;
        for (int i = 0; i <= n; ++i)
            for (int j = 0; j <= i; ++j) {
                if ((i + j) % 2 == 1) ans = (ans + dp[i][j]) % MOD;
                if (i + 1 <= n) dp[i + 1][j] = (dp[i + 1][j] + dp[i][j]) % MOD;
                if (j < i) dp[i][j + 1] = (dp[i][j + 1] + dp[i][j]) % MOD;

            }

        out.printLine(ans);


    }
}
