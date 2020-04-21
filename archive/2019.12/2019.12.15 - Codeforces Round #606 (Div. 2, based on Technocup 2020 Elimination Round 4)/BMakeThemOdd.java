package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.TreeSet;

public class BMakeThemOdd {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        TreeSet<Integer> tree = new TreeSet<>();

        for (int e : in.readIntArray(n)) if (e % 2 == 0) tree.add(e);

        int ans = 0;
        while (!tree.isEmpty()) {
            int key = tree.last();
            tree.remove(key);
            ans++;
            if ((key / 2) % 2 == 0) tree.add(key / 2);
        }
        out.printLine(ans);
    }
}
