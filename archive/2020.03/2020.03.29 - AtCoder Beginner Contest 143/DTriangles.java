package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.Arrays;

public class DTriangles {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int[] arr = in.readIntArray(n);

        Arrays.sort(arr);


        long ans = 0;

        for (int i = 0; i < n; ++i)
            for (int j = i + 1; j + 1 < n; ++j) {

                int low = j + 1;
                int hih = n;
                int until = arr[i] + arr[j] - 1;
                while (hih - low > 1) {
                    int middle = (low + hih) >> 1;
                    if (arr[middle] <= until)
                        low = middle;
                    else
                        hih = middle;
                }
                if (arr[low] <= until)
                    ans += low - j;
            }

        out.printLine(ans);

    }
}
