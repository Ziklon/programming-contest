package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.misc.ArrayUtils;

public class ChefAndParty {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int t = in.readInt();
    for (int i = 0; i < t; ++i) {
      int n = in.readInt();
      int[] seq = in.readIntArray(n);
      seq = ArrayUtils.radixSort(seq);
      int people = 0;
      for (int e : seq) {
        if (e <= people) {
          people++;
        }
      }
      out.printLine(people);
    }
  }
}
