package com.darkbit.problems;

import net.egork.graph.BidirectionalGraph;
import net.egork.graph.Graph;
import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class SubtreeRemoval {
  int[] seq;
  int x;

  long dfs(int root, int prev, BidirectionalGraph graph) {

    long sum = seq[root];
    for (int next = graph.firstOutbound(root); next != -1; next = graph.nextOutbound(next)) {
      int dest = graph.destination(next);
      if (dest == prev) continue;
      sum += dfs(dest, root, graph);
    }
    return Math.max(sum, -x);
  }

  public void solve(int testNumber, InputReader in, OutputWriter out) {

    int t = in.readInt();

    for (int a = 0; a < t; ++a) {
      int n = in.readInt();
      x = in.readInt();
      seq = in.readIntArray(n);

      BidirectionalGraph graph = new BidirectionalGraph(n);

      for (int i = 0; i + 1 < n; ++i) {
        graph.addSimpleEdge(in.readInt() - 1, in.readInt() - 1);
      }
      out.printLine(dfs(0,-1, graph));
    }
  }
}
