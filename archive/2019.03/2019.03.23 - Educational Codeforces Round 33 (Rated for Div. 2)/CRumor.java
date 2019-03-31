package com.darkbit.problems;

import net.egork.graph.BidirectionalGraph;
import net.egork.graph.Graph;
import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CRumor {

  boolean[] seen;

  void dfs(Graph graph, int root) {
    seen[root] = true;

    for (int next = graph.firstOutbound(root); next != -1; next = graph.nextOutbound(next)) {
      int e = graph.destination(next);
      if (seen[e] == false) dfs(graph, e);
    }
  }

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt(), m = in.readInt();
    List<int[]> vertex = new ArrayList<>();
    for (int i = 0; i < n; ++i) vertex.add(new int[] {in.readInt(), i});

    Collections.sort(vertex, Comparator.comparingInt(p -> p[0]));

    BidirectionalGraph graph = new BidirectionalGraph(n);
    seen = new boolean[n];

    for (int i = 0; i < m; ++i) {
      graph.addSimpleEdge(in.readInt() - 1, in.readInt() - 1);
    }

    long ans = 0;
    for (int i = 0; i < n; ++i) {
      int e = vertex.get(i)[1];
      if (seen[e] == false) {
        dfs(graph, e);
        ans += vertex.get(i)[0];
      }
    }
    out.printLine(ans);
  }
}
