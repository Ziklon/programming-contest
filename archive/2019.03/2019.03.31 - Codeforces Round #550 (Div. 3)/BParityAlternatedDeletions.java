package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.misc.ArrayUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BParityAlternatedDeletions {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt();
    int[] seq = in.readIntArray(n);
    List<Integer> l1 = new ArrayList<>();
    List<Integer> l2 = new ArrayList<>();
    long sum = 0;
    for (int e : seq) {
      if ((e & 1) == 0) l1.add(e);
      else l2.add(e);
      sum += e;
    }
    Collections.sort(l1);
    Collections.sort(l2);
    Collections.reverse(l1);
    Collections.reverse(l2);
    int minSize = Math.min(l1.size(), l2.size());

    long sum1 = 0;
    for (int i = 0; i < minSize; ++i) {
      sum1 += l1.get(i);
      sum1 += l2.get(i);
    }
    long ans = Long.MAX_VALUE;
    if (l1.size() > minSize) ans = Math.min(ans, sum - sum1 - l1.get(minSize));
    if (l2.size() > minSize) ans = Math.min(ans, sum - sum1 - l2.get(minSize));

    if (minSize * 2 == n) ans = 0;

    out.printLine(ans);
  }
}
