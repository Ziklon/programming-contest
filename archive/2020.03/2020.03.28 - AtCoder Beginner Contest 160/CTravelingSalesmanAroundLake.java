package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class CTravelingSalesmanAroundLake {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int k = in.readInt(), n = in.readInt();
        int[] arr = in.readIntArray(n);

        long sum = 0;
        for (int i = 0; i < n; ++i) {

            int cur = arr[i];
            int prev = arr[(i - 1 + n) % n];

            if (cur >= prev) {
                sum += cur - prev;
            } else {
                sum += k - prev;
                sum += cur;
            }
        }

        long ans = sum;

        for (int i = 0; i < n; ++i) {

            int cur = arr[i];
            int prev = arr[(i - 1 + n) % n];

            int curDistance = cur >= prev ? cur - prev : k - prev + cur;

            ans = Math.min(ans, sum - curDistance);

        }
        out.printLine(ans);


    }
}
