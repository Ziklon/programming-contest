package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.misc.ArrayUtils;

import java.util.*;

public class ASnacktower {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt();
    boolean seen[] = new boolean[n + 1];
    int lastMax = n;
    for (int e : in.readIntArray(n)) {
      List<Integer> ans = new ArrayList<>();
      seen[e] = true;
      while (lastMax > 0 && seen[lastMax]) ans.add(lastMax--);

      out.printLine(ans.toArray());
    }
  }
}
