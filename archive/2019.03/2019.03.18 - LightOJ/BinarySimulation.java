package com.darkbit.problems;

import net.egork.collections.intervaltree.SumIntervalTree;
import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class BinarySimulation {
  public void solve(int testNumber, InputReader in, OutputWriter out) {

    int t = in.readInt();

    for (int k = 0; k < t; ++k) {
      String s = in.readString();
      long[] array = new long[s.length()];
      for (int i = 0; i < s.length(); ++i) array[i] = s.charAt(i) - '0';

      SumIntervalTree tree = new SumIntervalTree(array);
      out.printLine(String.format("Case %d:", k + 1));
      int q = in.readInt();

      for (int i = 0; i < q; ++i) {
        char c = in.readCharacter();
        if (c == 'Q') {
          int at = in.readInt() - 1;
          out.printLine(tree.query(at, at) % 2);
        } else {
          int x = in.readInt(), y = in.readInt();
          tree.update(x - 1, y - 1, 1);
        }
      }
    }
  }
}
