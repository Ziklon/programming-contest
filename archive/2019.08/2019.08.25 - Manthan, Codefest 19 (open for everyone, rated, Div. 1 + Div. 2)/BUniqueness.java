package com.darkbit.problems;

import net.egork.collections.map.Indexer;
import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.misc.ArrayUtils;

import java.util.Arrays;

public class BUniqueness {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int n = in.readInt();
        int[] seq = in.readIntArray(n);

        Indexer<Integer> indexer = new Indexer<>();
        boolean[] used = new boolean[n];
        int ans = n;
        for (int i = 0; i <= n; ++i) {
            Arrays.fill(used, false);
            boolean ok = true;
            for (int j = 0; j < i && ok; ++j) {
                int idx = indexer.get(seq[j]);
                if (used[idx]) ok = false;
                used[idx] = true;
            }
            if (!ok) break;
            ans = Math.min(ans, n - i);
            for (int j = n - 1; j >= i; --j) {
                int idx = indexer.get(seq[j]);
                if (used[idx]) break;
                used[idx] = true;
                ans = Math.min(ans, j - i);
            }
        }
        out.printLine(ans);
    }
}
