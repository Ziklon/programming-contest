package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.misc.ArrayUtils;

import java.util.HashSet;
import java.util.Set;

public class BModuloEquality {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt(), m = in.readInt();

        int[] a = in.readIntArray(n);
        int[] b = ArrayUtils.radixSort(in.readIntArray(n));

        Set<Integer> tested = new HashSet<>();

        for (int i = 0; i < n; ++i) {
            int k = (b[i] - a[0] + m) % m;

            if (tested.contains(k)) continue;

            int[] tmp = new int[n];

            for (int j = 0; j < n; ++j) tmp[j] = (k + a[j]) % m;


            boolean ok = true;
            tmp = ArrayUtils.radixSort(tmp);

            for (int j = 0; j < n; ++j) if (tmp[j] != b[j]) ok = false;

            if (ok) {
                out.printLine(k);
                return;
            }
            tested.add(k);
        }
    }
}
