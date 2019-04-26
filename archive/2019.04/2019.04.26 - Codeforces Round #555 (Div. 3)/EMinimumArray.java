package com.darkbit.problems;

import net.egork.collections.map.TreeCounter;
import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class EMinimumArray {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int n = in.readInt();
        int[] a = in.readIntArray(n);
        TreeCounter<Integer> tree = new TreeCounter<>();
        for (int i = 0; i < n; ++i) tree.add(in.readInt());

        int[] ans = new int[n];

        for (int i = 0; i < n; ++i) {
            int x = (n - a[i]) % n;
            Integer key = tree.ceilingKey(x);
            if (key == null) key = tree.firstKey();
            ans[i] = (a[i] + key) % n;
            tree.removeOne(key);
        }

        out.printLine(ans);

    }
}
