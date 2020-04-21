package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.misc.ArrayUtils;

public class ETravelByCar {
    static long INF = 1L << 35;

    void floydWarsaw(long[][] adj) {
        for (int k = 0; k < adj.length; ++k)
            for (int i = 0; i < adj.length; ++i)
                for (int j = 0; j < adj.length; ++j) {
                    adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
                }
    }

    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int n = in.readInt(), m = in.readInt();
        long l = in.readLong();


        long[][] adj = new long[n][n];

        ArrayUtils.fill(adj, INF);

        for (int i = 0; i < n; ++i) adj[i][i] = 0;

        for (int i = 0; i < m; ++i) {
            int u = in.readInt() - 1, v = in.readInt() - 1;
            long w = in.readLong();
            adj[u][v] = adj[v][u] = w;
        }

        floydWarsaw(adj);
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j) {
                adj[i][j] = adj[i][j] <= l ? 1 : INF;
                if (i == j) adj[i][i] = 0;
            }
        floydWarsaw(adj);
        int q = in.readInt();

        for (int i = 0; i < q; ++i) {
            int u = in.readInt() - 1, v = in.readInt() - 1;
            out.printLine(adj[u][v] >= INF ? -1 : adj[u][v] - 1);
        }

    }
}
