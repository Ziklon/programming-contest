package com.darkbit.problems;

import net.egork.graph.BidirectionalGraph;
import net.egork.graph.Graph;
import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.misc.ArrayUtils;

import java.util.Arrays;

public class AParty {

  int[] depth;

  public void solve(int testNumber, InputReader in, OutputWriter out) {

    int n = in.readInt();

    int parent[] = new int[n];

    for (int i = 0; i < n; ++i) {
      parent[i] = in.readInt() - 1;
    }
    depth = new int[n];

    int ans = 0;
    for (int i = 0; i < n; ++i) {
      dfs(parent, i);
      ans = Math.max(ans, depth[i]);
    }
    out.printLine(ans);
  }

  private void dfs(int[] parent, int root) {
    if (depth[root] > 0) return;
    depth[root] = 1;
    if (parent[root] >= 0) {
      dfs(parent, parent[root]);
      depth[root] += depth[parent[root]];
    }
  }
}
