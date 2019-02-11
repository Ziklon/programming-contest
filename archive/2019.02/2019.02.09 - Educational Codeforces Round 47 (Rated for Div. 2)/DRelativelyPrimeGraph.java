package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.numbers.IntegerUtils;

import java.util.ArrayList;
import java.util.List;

public class DRelativelyPrimeGraph {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt(), m = in.readInt();

    if (m + 1 < n) {
      out.printLine("Impossible");
      return;
    }

    List<int[]> ans = new ArrayList<>();
    for (int i = 1; i <= n && m > 0; ++i) {
      for (int j = i + 1; j <= n && m > 0; ++j) {
        if (IntegerUtils.gcd(j, i) > 1) continue;
        ans.add(new int[] {i, j});
        m--;
      }
    }
    if (m > 0) out.printLine("Impossible");
    else {
      out.printLine("Possible");
      for (int[] item : ans) out.printLine(item);
    }
  }
}
