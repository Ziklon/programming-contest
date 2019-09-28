package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.Arrays;
import java.util.Comparator;

public class CGoToSchool {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int[][] seq = new int[n][];

        for (int i = 0; i < n; ++i)
            seq[i] = new int[]{in.readInt(), i + 1};


        Arrays.sort(seq, Comparator.comparingInt(p -> p[0]));

        int[] ans = new int[n];
        for (int i = 0; i < n; ++i) ans[i] = seq[i][1];

        out.printLine(ans);

    }
}
