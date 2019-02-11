package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AKFactorization {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt(), k = in.readInt();

    List<Integer> ans = new ArrayList<>();
    for (int i = 2; i <= n && k > 1; ++i) {
      while (k > 1 && n > 0 && n % i == 0) {
        ans.add(i);
        n /= i;
        k--;
      }
    }
    if (k > 1 || n < 2) out.printLine(-1);
    else {
      ans.add(n);
      out.printLine(ans.toArray());
    }
  }
}
