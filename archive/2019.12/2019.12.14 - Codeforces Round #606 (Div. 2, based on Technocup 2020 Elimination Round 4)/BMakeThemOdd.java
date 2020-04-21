package com.darkbit.problems;

import net.egork.collections.map.TreeCounter;
import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.TreeSet;

public class BMakeThemOdd {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int n = in.readInt();
        int[] s = in.readIntArray(n);

        TreeSet<Integer> tree = new TreeSet<>();

        for (int e : s) tree.add(e);

        int ans = 0;

        while (!tree.isEmpty()) {
            int key = tree.last();
            tree.remove(key);
            if (key % 2 == 1) continue;

            ans += 1;
            tree.add(key / 2);
        }
        out.printLine(ans);

    }
}
