package com.darkbit.problems;

import net.egork.graph.BidirectionalGraph;
import net.egork.graph.Graph;
import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CQueen {
  int[] color;
  int[] count;
  boolean[] children;

  void dfs(Graph graph, int root, int prev) {
    boolean allChildren = true;
    for (int next = graph.firstOutbound(root); next != -1; next = graph.nextOutbound(next)) {
      int v = graph.destination(next);
      if (v == prev) continue;
      if (color[v] == 0) allChildren = false;
      dfs(graph, v, root);
    }
    children[root] = allChildren;
  }

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt();
    color = new int[n];
    count = new int[n];
    children = new boolean[n];
    Arrays.fill(count, -1);

    BidirectionalGraph graph = new BidirectionalGraph(n);
    int parent = -1;
    for (int i = 0; i < n; ++i) {
      int v = in.readInt() - 1, ci = in.readInt();
      color[i] = ci;
      if (v == -2) parent = i;
      else graph.addSimpleEdge(i, v);
    }
    dfs(graph, parent, -1);

    List<Integer> ans = new ArrayList<>();
    for (int i = 0; i < n; ++i) if (color[i] == 1 && children[i]) ans.add(i + 1);

    if (ans.isEmpty()) out.printLine(-1);
    else out.printLine(ans.toArray());
  }
}
