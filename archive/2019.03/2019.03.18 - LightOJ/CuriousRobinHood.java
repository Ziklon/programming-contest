package com.darkbit.problems;

import net.egork.collections.intervaltree.SumIntervalTree;
import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class CuriousRobinHood {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int t = in.readInt();

    for (int i = 0; i < t; ++i) {
      out.printLine(String.format("Case %d:", i + 1));
      int n = in.readInt(), k = in.readInt();
      long array[] = in.readLongArray(n);

      SumIntervalTree tree = new SumIntervalTree(array);

      for (int j = 0; j < k; ++j) {
        int q = in.readInt();
        if (q == 1) {
          int at = in.readInt();
          long val = tree.query(at, at);
          out.printLine(val);
          tree.update(at, at, -val);
        } else if (q == 2) {
          int at = in.readInt(), val = in.readInt();
          tree.update(at, at, val);
        } else {
          int x = in.readInt(), y = in.readInt();
          out.printLine(tree.query(x, y));
        }
      }
    }
  }
}
