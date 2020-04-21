package com.darkbit.problems;

import net.egork.collections.map.TreeCounter;
import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class DLetsPlayTheWords {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();

        TreeCounter<Integer> counter = new TreeCounter<>();
        String[] seq = new String[n];

        int[][] graph = {{0, 1, 0, 0}, {0, 0, 1, 0}, {1, 1, 0, 0}, {0, 0, 1, 0}};



        for (int i = 0; i < n; ++i) {
            String s = in.readString();
            seq[i] = s;

            int mask = 0;
            if (s.charAt(0) == '1') mask |= (1 << 1);
            if (s.charAt(s.length() - 1) == '1') mask |= (1 << 0);

            counter.add(mask);

        }


    }
}
