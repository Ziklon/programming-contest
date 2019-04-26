package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class DServalAndRootedTree {

  int[] sz;
  int[] m;
  int nl = 0;
  List<Integer>[] G;

  int[] dp;

  void dfs(int u) {
    dp[u] = 1;
    int h = 0;
    for (int v : G[u]) {
      dfs(v);
      h += sz[v] - dp[v] + 1;
      sz[u] += sz[v];
    }
    if (G[u].isEmpty()) {
      dp[u] = 1;
      return;
    }
    if (m[u] == 1) {
      for (int v : G[u]) {
        dp[u] = Math.max(dp[u], dp[v] + sz[u] - sz[v]);
      }
    } else dp[u] = sz[u] - h + 1;
  }

  public void solve(int testNumber, InputReader in, OutputWriter out) {

    int n = in.readInt();
    m = in.readIntArray(n);
    sz = new int[n];
    G = new List[n];
    dp = new int[n];
    for (int i = 0; i < n; ++i) G[i] = new ArrayList<>();

    for (int i = 1; i < n; ++i) {
      G[in.readInt() - 1].add(i);
    }

    for (int i = 0; i < n; ++i)
      if (G[i].isEmpty()) {
        sz[i] = 1;
        nl++;
      }

    dfs(0);
    out.printLine(dp[0]);
  }
}
