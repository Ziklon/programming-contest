package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class DSumInTheTree {

  final int MAXN = (int) 1e5 + 10;
  List<Integer>[] G;
  long[] S = new long[MAXN];
  long[] A = new long[MAXN];

  void dfs(int u, long s) {

    if (S[u] == -1) {
      if (G[u].isEmpty()) {
        A[u] = 0;
        return;
      }
      long lo = (long) 1e9;
      for (int v : G[u]) {
        lo = Math.min(lo, S[v] - s);
      }
      A[u] = lo;
    } else {
      A[u] = S[u] - s;
    }
    for (int v : G[u]) {
      dfs(v, s + A[u]);
    }
  }

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt();
    G = new List[n];
    for (int i = 0; i < n; ++i) G[i] = new ArrayList<>();

    for (int i = 1; i < n; ++i) {
      int u = in.readInt();
      G[u - 1].add(i);
    }
    for (int i = 0; i < n; ++i) S[i] = in.readInt();

    dfs(0, 0);
    long ans = 0;
    for (long a : A) {
      if (a < 0) {
        out.printLine(-1);
        return;
      }
      ans += a;
    }
    out.printLine(ans);
  }
}
