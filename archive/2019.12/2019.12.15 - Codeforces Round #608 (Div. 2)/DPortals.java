package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.misc.ArrayUtils;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;

public class DPortals {
    private static final int MAXN = 5100;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt(), m = in.readInt(), K = in.readInt();

        int[][] castles = in.readIntTable(n, 3);

        int[] latest = new int[n];

        for (int i = 0; i < n; ++i) latest[i] = i;

        for (int i = 0; i < m; ++i) {
            int u = in.readInt() - 1;
            int v = in.readInt() - 1;
            latest[v] = Math.max(latest[v], u);
        }

        int[][] dp = new int[MAXN + 2][MAXN + 2];
        ArrayUtils.fill(dp, -1 * (int) 1e9);
        dp[0][K] = 0;

        for (int i = 0; i < n; ++i) {
            int[] cur = castles[i];
            for (int j = cur[0]; j < MAXN; ++j) {
                if (dp[i][j] >= 0) {
                    dp[i + 1][j + cur[1]] = Math.max(dp[i + 1][j + cur[1]], dp[i][j]);
                }
            }
            for (int j = 0; j <= i; ++j) {
                if (latest[j] == i) {
                    for (int k = 1; k < MAXN; ++k) {
                        if (dp[i + 1][k] >= 0)
                            dp[i + 1][k - 1] = Math.max(dp[i + 1][k - 1], dp[i + 1][k] + castles[j][2]);
                    }
                }
            }
        }
        int ans = -1;
        for (int e : dp[n]) ans = Math.max(ans, e);

        out.printLine(ans);


    }


}
