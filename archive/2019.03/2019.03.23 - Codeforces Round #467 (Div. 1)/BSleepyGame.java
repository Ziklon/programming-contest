package com.darkbit.problems;

import net.egork.graph.Graph;
import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.misc.ArrayUtils;

import java.util.*;

public class BSleepyGame {

  boolean isDraw = false;
  int[][] seen;
  boolean[] isEnd;
  Stack<Integer> path;
  boolean won = false;

  OutputWriter out;

  void dfs(int root, int mov, Graph graph) {
    seen[root][mov] = 1;
    path.add(root + 1);
    if (isEnd[root] && mov == 1 && !won) {
      won = true;
      out.printLine("Win");
      out.printLine(path.toArray());
    }

    for (int next = graph.firstOutbound(root); next != -1; next = graph.nextOutbound(next)) {
      int u = graph.destination(next);
      if (seen[u][mov ^ 1] == 0) {
        dfs(u, mov ^ 1, graph);
      } else if (seen[u][mov ^ 1] == 1) isDraw = true;
    }
    path.pop();
    seen[root][mov] = 2;
  }

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt(), m = in.readInt();

    Graph graph = new Graph(n);

    isEnd = new boolean[n];

    for (int i = 0; i < n; ++i) {
      int ci = in.readInt();
      for (int j = 0; j < ci; ++j) {
        int xi = in.readInt() - 1;
        graph.addSimpleEdge(i, xi);
      }
      if (ci == 0) isEnd[i] = true;
    }
    if (ArrayUtils.count(isEnd, true) == 0) {
      out.printLine("Draw");
      return;
    }
    seen = new int[n][2];
    path = new Stack<>();
    this.out = out;
    int source = in.readInt() - 1;
    dfs(source, 0, graph);
    if (!won) {
      if (isDraw) out.printLine("Draw");
      else out.printLine("Lose");
    }
  }
}
