package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.misc.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GLongestPath {

  List<Integer>[] G;
  int[] dp;

  int go(int root) {

    if (dp[root] != -1) return dp[root];

    int ans = 0;
    for (int next : G[root]) {
      ans = Math.max(ans, go(next) + 1);
    }
    dp[root] = ans;
    return ans;
  }

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt(), m = in.readInt();

    G = new List[n];
    dp = new int[n];
    Arrays.fill(dp, -1);
    for (int i = 0; i < n; ++i) G[i] = new ArrayList<>();

    for (int i = 0; i < m; ++i) {
      int from = in.readInt() - 1;
      int to = in.readInt() - 1;
      G[from].add(to);
    }
    int ans = 0;
    for (int i = 0; i < n; ++i) ans = Math.max(ans, go(i));

    out.printLine(ans);
  }
}
