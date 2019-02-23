package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.misc.ArrayUtils;

import java.util.HashSet;
import java.util.Set;

public class ABearAndFiveCards {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int[] seq = in.readIntArray(5);
    int ans = (int) ArrayUtils.sumArray(seq);

    for (int mask = 0; mask < (1 << 5); ++mask) {
      if (Integer.bitCount(mask) != 2 && Integer.bitCount(mask) != 3) continue;
      int sum = 0;
      Set<Integer> hs = new HashSet<>();
      for (int i = 0; i < 5; ++i) {
        if ((mask & (1 << i)) > 0) sum += seq[i];
        else {
          hs.add(seq[i]);
        }
      }
      if (hs.size() == 1) ans = Math.min(ans, sum);
    }

    out.printLine(ans);
  }
}
