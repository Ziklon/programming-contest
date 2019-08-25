package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.numbers.IntegerUtils;

public class CGCDOnBlackboard {


    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int n = in.readInt();

        int[] a = in.readIntArray(n);


        int[] left = new int[n + 1];
        int[] right = new int[n + 1];

        for (int i = 1; i < left.length; ++i) {
            left[i] = IntegerUtils.gcd(a[i - 1], left[i - 1]);
        }
        for (int i = n - 1; i >= 0; --i) {
            right[i] = IntegerUtils.gcd(a[i], right[i + 1]);
        }

        int ans = right[0];

        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, IntegerUtils.gcd(left[i], right[i + 1]));
        }
        out.printLine(ans);

    }
}
