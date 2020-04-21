package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CDrazilAndFactorial {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int[][] graph = {{}, {}, {2}, {3}, {3, 2, 2}, {5}, {5, 3}, {7}, {7, 2, 2, 2}, {7, 3, 3, 2}};

        int n = in.readInt();
        long m = in.readLong();

        List<Integer> list = new ArrayList<>();
        while (m > 0) {
            int d = (int) (m % 10);
            if (d >= 2) {
                for (int e : graph[d]) list.add(e);
            }
            m /= 10;
        }
        Collections.sort(list);
        Collections.reverse(list);
        StringBuilder sb = new StringBuilder();

        for (int e : list) sb.append(e);
        out.printLine(sb.toString());
    }
}
