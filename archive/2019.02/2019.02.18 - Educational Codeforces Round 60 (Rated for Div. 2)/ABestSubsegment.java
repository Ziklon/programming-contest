package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.misc.ArrayUtils;

public class ABestSubsegment {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt();
    int[] seq = in.readIntArray(n);
    int max = ArrayUtils.maxElement(seq);
    int len = 0;

    for (int i = 0; i < n; ++i) {
      if (seq[i] == max) {
        int tmp = 0;
        int j;
        for (j = i; j < n && seq[j] == seq[i]; ++j) tmp++;
        len = Math.max(len, tmp);
        i = j - 1;
      }
    }
    out.printLine(len);
  }
}
