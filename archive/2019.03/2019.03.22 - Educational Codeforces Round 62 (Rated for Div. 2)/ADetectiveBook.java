package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.HashSet;
import java.util.Set;

public class ADetectiveBook {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt();
    int[] seq = in.readIntArray(n);
    int day = 0;
    Set<Integer> s = new HashSet<>();
    for (int i = 1; i <= n; ++i) {
      if (s.contains(i)) s.remove(i);
      if (seq[i - 1] > i) s.add(seq[i - 1]);
      else {
        if (s.isEmpty()) day++;
      }
    }
    out.printLine(day);
  }
}
