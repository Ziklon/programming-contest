package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class DLunarNewYearAndAWander {

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt(), m = in.readInt();
    List<Integer>[] G = new List[n];
    boolean[] seen = new boolean[n];
    for (int i = 0; i < n; ++i) G[i] = new ArrayList();
    for (int i = 0; i < m; ++i) {
      int u = in.readInt() - 1, v = in.readInt() - 1;
      G[v].add(u);
      G[u].add(v);
    }

    Queue<Integer> path = new LinkedList<>();
    PriorityQueue<Integer> Q = new PriorityQueue<>();

    Q.add(0);
    seen[0] = true;
    while (!Q.isEmpty()) {
      int v = Q.poll();
      path.add(v + 1);
      for (int u : G[v]) {
        if (!seen[u]) {
          Q.add(u);
          seen[u] = true;
        }
      }
    }
    out.printLine(path.toArray());
  }
}
