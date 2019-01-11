package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.misc.ArrayUtils;

public class BAccordion {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    char[] seq = in.readString().toCharArray();
    char[] rev = seq.clone();
    ArrayUtils.reverse(rev);
    int left = getIndex("[:", seq);
    int right = getIndex("]:", rev);
    if (Math.min(left, right) == -1) out.printLine(-1);
    else {
      right = seq.length - right - 1;

      if (left >= right) out.printLine(-1);
      else {
        int ans = 4;
        for (int i = left; i < right; ++i) if (seq[i] == '|') ans++;
        out.printLine(ans);
      }
    }
  }

  int getIndex(String pattern, char[] seq) {
    int idx = 0;
    for (int i = 0; i < seq.length; ++i) {
      if (pattern.charAt(idx) == seq[i]) idx++;
      if (pattern.length() == idx) return i;
    }
    return -1;
  }
}
