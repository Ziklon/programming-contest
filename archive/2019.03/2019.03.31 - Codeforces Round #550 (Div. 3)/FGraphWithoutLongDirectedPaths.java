package com.darkbit.problems;

import net.egork.graph.BidirectionalGraph;
import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FGraphWithoutLongDirectedPaths {
  boolean hasAns = true;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt(), m = in.readInt();

    BidirectionalGraph graph = new BidirectionalGraph(n);
    List<int[]> edges = new ArrayList<>();
    for (int i = 0; i < m; ++i) {
      int u = in.readInt() - 1, v = in.readInt() - 1;
      graph.addSimpleEdge(u, v);
      edges.add(new int[] {u, v});
    }

    color = new int[n];
    Arrays.fill(color, -1);
    dfs(graph, 0, 0);
    if (!hasAns) {
      out.printLine("NO");
      return;
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < m; ++i) {
      int u = edges.get(i)[0];
      sb.append(color[u] == 0 ? "1" : "0");
    }
    out.printLine("YES");
    out.printLine(sb.toString());
  }

  int[] color;

  private void dfs(BidirectionalGraph graph, int root, int col) {
    color[root] = col;
    for (int next = graph.firstOutbound(root); next != -1; next = graph.nextOutbound(next)) {
      int u = graph.destination(next);
      if (color[u] == -1) dfs(graph, u, col ^ 1);
      if (color[root] == color[u]) hasAns = false;
    }
  }
}
