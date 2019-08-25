package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.Arrays;

public class CPrefixSumPrimes {

    int[] create(int n, int e) {
        int ans[] = new int[n];
        Arrays.fill(ans, e);
        return ans;
    }

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int one = 0, two = 0;
        for (int e : in.readIntArray(n)) {
            if (e == 1) one++;
            else two++;
        }

        if (two == 0) {
            out.printLine(create(n, 1));
        } else if (one == 0) {
            out.printLine(create(n, 2));
        } else {
            out.print(2, 1);
            for (int i = 0; i + 1 < two; ++i) out.print(" " + 2);
            for (int i = 0; i + 1 < one; ++i) out.print(" " + 1);
        }
    }
}
