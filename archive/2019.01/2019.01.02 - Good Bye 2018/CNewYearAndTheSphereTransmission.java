package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.numbers.IntegerUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CNewYearAndTheSphereTransmission {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt();
    Set<Integer> divs = new HashSet<>();
    for (int i = 1; i * i <= n; ++i)
      if (n % i == 0) {
        divs.add(i);
        divs.add(n / i);
      }

    List<Long> ans = new ArrayList<>();
    for (Integer div : divs) ans.add(sum(div, n));

    Collections.sort(ans);
    out.printLine(ans.toArray());
  }

  private long sum(int k, int n) {

    long res = k * (k - 1L) / 2;
    return res * (n / k) + k;
  }
}
