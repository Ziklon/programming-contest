package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.misc.ArrayUtils;

public class APaintTheNumbers {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int[] s = in.readIntArray(n);
        s = ArrayUtils.sort(s);


        boolean[] used = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (used[i]) continue;
            ans++;
            for (int j = i; j < n; ++j) {
                used[j] |= used[j] || s[j] % s[i] == 0;
            }
        }
        out.printLine(ans);


    }
}
