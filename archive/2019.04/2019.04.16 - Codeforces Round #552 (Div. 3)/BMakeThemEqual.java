package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class BMakeThemEqual {
  public void solve(int testNumber, InputReader in, OutputWriter out) {

    int n = in.readInt();
    int[] seq = in.readIntArray(n);

    int ans = 1 << 20;
    for (int e = -200; e <= 200; ++e) {

      TreeSet<Integer> s1 = new TreeSet<>();
      for (int item : seq) {
        if (item > e) s1.add(item - e);
        else if (item < e) s1.add(e - item);
      }
      if (s1.isEmpty()) ans = 0;
      else if (s1.size() == 1) {
        ans = Math.min(ans, s1.first());
      }
    }

    out.printLine(ans >= 1 << 20 ? -1 : ans);
  }
}
