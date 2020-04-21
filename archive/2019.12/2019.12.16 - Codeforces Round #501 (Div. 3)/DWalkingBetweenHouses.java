package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.TreeSet;

public class DWalkingBetweenHouses {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        long n = in.readInt(), k = in.readInt(), s = in.readLong();

        if (k > s || (n - 1) * k < s) {
            out.printLine("NO");
            return;
        }
        int cur = 1;
        out.printLine("YES");

        TreeSet<Integer> tree = new TreeSet<>();
        int[] steps = new int[(int) k];

        for (int i = 0; i < k; ++i) {
            int curDist = (int) Math.min(n - 1, s - (k - i - 1));

            if (cur - curDist > 0)
                steps[i] = cur - curDist;
            else
                steps[i] = cur + curDist;

            cur = steps[i];
            s -= curDist;
        }
        out.printLine(steps);

    }
}
