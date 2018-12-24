package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class BDivTimesMod {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt(), x = in.readInt();
    List<Integer> factors = new ArrayList<>();
    for (int i = 2; i * i <= n; ++i) {
      if (n % i == 0) {
        factors.add(i);
        factors.add(n / i);
      }
    }

    for (int a : factors) {
      int b = n / a;

    }
  }
}
