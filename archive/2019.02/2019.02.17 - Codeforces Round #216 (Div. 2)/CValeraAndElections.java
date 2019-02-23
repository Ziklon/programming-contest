package com.darkbit.problems;

import net.egork.graph.Graph;
import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.misc.MiscUtils;

import java.util.ArrayList;
import java.util.List;

public class CValeraAndElections {

  int[] d;
  boolean[] white;

  public void solve(int testNumber, InputReader in, OutputWriter out) {

    int n = in.readInt();
    int[] u = new int[n - 1], v = new int[n - 1], w = new int[n - 1];
    in.readIntArrays(u, v, w);
    MiscUtils.decreaseByOne(u, v);
    white = new boolean[n];
    d = new int[n];
    Graph graph = new Graph(n);
    for (int i = 0; i < n - 1; ++i) {
      graph.addSimpleEdge(u[i], v[i]);
      graph.addSimpleEdge(v[i], u[i]);
      if (w[i] == 2) {
        white[v[i]] = true;
        white[u[i]] = true;
      }
    }
    dfs(graph, 0, -1);

    List<Integer> vertices = new ArrayList<>();

    for (int i = 0; i < n; ++i) if (d[i] == 1 && white[i]) vertices.add(i + 1);

    out.printLine(vertices.size());
    out.printLine(vertices.toArray());
  }

  private void dfs(Graph graph, int root, int prev) {

    d[root] = white[root] ? 1 : 0;
    for (int i = graph.firstOutbound(root); i != -1; i = graph.nextOutbound(i)) {
      int v = graph.destination(i);
      if (v != prev) {
        dfs(graph, v, root);
        d[root] += d[v];
      }
    }
  }
}
