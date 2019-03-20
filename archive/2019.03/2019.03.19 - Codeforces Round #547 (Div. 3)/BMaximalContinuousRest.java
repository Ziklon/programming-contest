package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.misc.ArrayUtils;

public class BMaximalContinuousRest {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt();
    int[] seq = in.readIntArray(n);
    int[] twoCopy = ArrayUtils.concatenate(seq, seq);

    int ans = 0;

    int prev = -1;
    int count = 0;
    for (int i = 0; i < twoCopy.length; ++i) {
      if (twoCopy[i] == prev) count++;
      else {
        prev = twoCopy[i];
        count = 1;
      }
      if (twoCopy[i] == 1) ans = Math.max(ans, count);
    }
    out.printLine(ans);
  }
}
