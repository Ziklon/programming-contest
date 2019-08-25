package com.darkbit.problems;

import net.egork.collections.map.TreeCounter;
import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.Map;

public class Attendance {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        TreeCounter<String> counter = new TreeCounter<>();
        String[] name = new String[n];
        String[] last = new String[n];

        for (int i = 0; i < n; ++i) {
            String first = in.readString();
            String second = in.readString();

            counter.add(first);
            name[i] = first;
            last[i] = second;
        }

        for (int i = 0; i < n; ++i) {
            if (counter.get(name[i]) == 1L) out.printLine(name[i]);
            else out.printLine(name[i], last[i]);
        }
    }
}
