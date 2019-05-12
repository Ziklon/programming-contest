package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.misc.ArrayUtils;
import net.egork.misc.MiscUtils;

public class ASushiForTwo {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt();
    int[] seq = in.readIntArray(n);
    MiscUtils.decreaseByOne(seq);
    int counter[] = new int[2];
    int prev = -1;
    int ans = 0;
    for (int e : seq) {
      if (prev == e) counter[e]++;
      else counter[e] = 1;
      prev = e;
      ans = Math.max(ans, ArrayUtils.minElement(counter));
    }
    out.printLine(ans * 2);
  }
}
