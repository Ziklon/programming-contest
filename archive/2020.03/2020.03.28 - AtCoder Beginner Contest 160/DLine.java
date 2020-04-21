package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DLine {
    List<Integer>[] G;
    boolean[] seen;
    int[] dist;

    void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        seen[node] = true;
        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int e : G[cur]) {
                if (!seen[e]) {
                    dist[e] = dist[cur] + 1;
                    queue.add(e);
                    seen[e] = true;
                }
            }
        }
    }

    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int n = in.readInt(), x = in.readInt() - 1, y = in.readInt() - 1;
        G = new List[n];

        for (int i = 0; i < n; ++i) G[i] = new ArrayList<>();

        G[x].add(y);
        G[y].add(x);

        for (int i = 0; i + 1 < n; ++i) {
            G[i].add(i + 1);
            G[i + 1].add(i);
        }
        int[] ans = new int[n];

        for (int v = 0; v < n; ++v) {
            seen = new boolean[n];
            dist = new int[n];
            bfs(v);

            for (int i = v + 1; i < n; ++i) {
                ans[dist[i]]++;
            }
        }
        for (int i = 1; i < n; ++i) {
            out.printLine(ans[i]);
        }


    }
}
