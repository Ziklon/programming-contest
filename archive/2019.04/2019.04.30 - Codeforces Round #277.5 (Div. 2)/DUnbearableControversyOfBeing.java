package com.darkbit.problems;

import net.egork.graph.Graph;
import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class DUnbearableControversyOfBeing {

    int[] times;

    void dfs(int u, int len, Graph graph) {

        if (len == 2) {
            times[u]++;
            return;
        }

        for (int next = graph.firstOutbound(u); next != -1; next = graph.nextOutbound(next)) {
            int dest = graph.destination(next);
            dfs(dest, len + 1, graph);
        }

    }


    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int n = in.readInt(), m = in.readInt();
        Graph graph = new Graph(n);

        for (int i = 0; i < m; ++i) graph.addSimpleEdge(in.readInt() - 1, in.readInt() - 1);

        long ans = 0;

        for (int i = 0; i < n; ++i) {

            times = new int[n];
            dfs(i, 0, graph);

            for (int j = 0; j < n; ++j)
                if (i != j) {
                    ans += times[j] * (times[j] - 1) / 2;
                }
        }

        out.printLine(ans);

    }
}
