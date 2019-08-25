package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.Arrays;

public class ATaskSchedulingProblem {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int[] seq = in.readIntArray(3);

        Arrays.sort(seq);

        int ans = (seq[2] - seq[1]);
        ans += seq[1] - seq[0];

        out.printLine(ans);

    }
}
