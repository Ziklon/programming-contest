package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.misc.ArrayUtils;

public class EGetEverything {

    int n, m;
    int[] open;
    int[] cost;
    int INF = 1 << 21;
    int[][] memo;

    int go(int idx, int mask) {
        if (Integer.bitCount(mask) == n) {
            return 0;
        }
        if (idx >= open.length) return INF;
        if (memo[idx][mask] == -1) {
            int ans = go(idx + 1, mask);
            ans = Math.min(ans, go(idx + 1, mask | open[idx]) + cost[idx]);
            memo[idx][mask] = ans;
        }
        return memo[idx][mask];
    }

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.readInt();
        m = in.readInt();
        cost = new int[m];

        open = new int[m];

        for (int i = 0; i < m; ++i) {
            cost[i] = in.readInt();
            int mask = 0;
            for (int e : in.readIntArray(in.readInt())) mask |= (1 << (e - 1));
            open[i] = mask;
        }
        memo = new int[m][1 << n];
        ArrayUtils.fill(memo, -1);
        int ans = go(0, 0);

        out.printLine(ans >= INF ? -1 : ans);
    }
}
