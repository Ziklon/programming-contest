package com.darkbit.problems;

import net.egork.collections.map.Indexer;
import net.egork.graph.BidirectionalGraph;
import net.egork.graph.Graph;
import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.Arrays;

public class TaskB {

  int[] dp;

  int end;

  int func(int u, Graph g) {
    if (u == end) return 1;
    if (dp[u] == -1) {
      int ans = 0;
      for (int next = g.firstOutbound(u); next != -1; next = g.nextOutbound(next)) {
        int dest = g.destination(next);
        ans += func(dest, g);
      }
      dp[u] = ans;
    }

    return dp[u];
  }

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt();

    Indexer<String> indexer = new Indexer<>();
    dp = new int[1000];
    Arrays.fill(dp, -1);
    Graph graph = new Graph(1000);
    for (int i = 0; i < n; ++i) {
      String[] line = in.readLine().split("[:]");
      Integer source = indexer.get(line[0]);
      for (String to : line[1].split("[,]")) {
        graph.addSimpleEdge(source, indexer.get(to));
      }
    }
    this.end = indexer.get("New Earth");
    int ans = func(indexer.get("Galactica"), graph);
    out.printLine(String.format("Case #%d: %d", testNumber, ans));
  }
}
