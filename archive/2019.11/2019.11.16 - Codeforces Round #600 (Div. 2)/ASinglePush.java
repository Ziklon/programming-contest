package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class ASinglePush {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int[] a = in.readIntArray(n);
        int[] b = in.readIntArray(n);


        int l = 0, r = n - 1;
        while (l < n && a[l] == b[l]) l++;
        while (r >= 0 && a[r] == b[r]) r--;

        if (l > r) {
            out.printLine("YES");
            return;
        }
        int k = b[l] - a[l];
        boolean isOk = k > 0;

        for (int j = l; j <= r; ++j) if (a[j] + k != b[j]) isOk = false;

        if (isOk) out.printLine("YES");
        else out.printLine("NO");
    }
}
