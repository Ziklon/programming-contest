package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.misc.ArrayUtils;

public class ThatIsMyScore {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int[] games = new int[8];
        for (int i = 0; i < n; ++i) {
            int p = in.readInt(), s = in.readInt();
            if (p <= 8) games[p - 1] = Math.max(games[p - 1], s);
        }
        out.printLine(ArrayUtils.sumArray(games));
    }
}
