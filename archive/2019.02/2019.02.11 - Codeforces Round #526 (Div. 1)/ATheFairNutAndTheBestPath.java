package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class ATheFairNutAndTheBestPath {
  List<int[]>[] adj;
  int[] W;
  long[] dp;
  long ans = 0;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt();
    W = in.readIntArray(n);

    adj = new List[n];
    dp = new long[n];
    for (int i = 0; i < n; ++i) adj[i] = new ArrayList<>();

    for (int i = 1; i < n; ++i) {
      int u = in.readInt() - 1, v = in.readInt() - 1, c = in.readInt();
      adj[u].add(new int[] {v, c});
      adj[v].add(new int[] {u, c});
    }

    dfs(0, -1);
    out.printLine(ans);
  }

  private void dfs(int root, int parent) {

    dp[root] = W[root];
    long big1 = 0, big2 = 0;

    for (int[] child : adj[root])
      if (child[0] != parent) {
        dfs(child[0], root);
        dp[root] = Math.max(dp[root], dp[child[0]] - child[1] + W[root]);
        if (dp[child[0]] - child[1] > big2) {
          big2 = dp[child[0]] - child[1];
          if (big2 > big1) {
            long tmp = big1;
            big1 = big2;
            big2 = tmp;
          }
        }
      }
    ans = Math.max(ans, dp[root]);
    ans = Math.max(ans, big1 + big2 + W[root]);
  }
}
