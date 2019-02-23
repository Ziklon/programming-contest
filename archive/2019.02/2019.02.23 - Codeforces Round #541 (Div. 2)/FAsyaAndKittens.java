package com.darkbit.problems;

import net.egork.collections.DisjointSetOfList;
import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class FAsyaAndKittens {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt();
    DisjointSetOfList ds = new DisjointSetOfList(n);

    for (int i = 0; i + 1 < n; ++i) {
      int x = in.readInt() - 1, y = in.readInt() - 1;
      ds.union(x, y);
    }

    for (int i = ds.root(1); i != -1; i = ds.next[i]) {
      out.print((i + 1) + " ");
    }
  }
}
