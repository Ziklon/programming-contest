package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class AChipsMoving {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int n = in.readInt();
        int even = 0, odd = 0;
        for (int e : in.readIntArray(n)) {
            if (e % 2 == 1) odd++;
            else even++;
        }

        out.printLine(Math.min(even, odd));

    }
}
