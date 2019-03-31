package com.darkbit.problems;

import net.egork.collections.iss.RecursiveIndependentSetSystem;
import net.egork.collections.map.Counter;
import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.numbers.IntegerUtils;

import java.util.HashMap;
import java.util.Map;

public class CEdgyTrees {

  long MOD = (int) 1e9 + 7;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt(), k = in.readInt();
    RecursiveIndependentSetSystem ris = new RecursiveIndependentSetSystem(n);

    for (int i = 0; i + 1 < n; ++i) {
      int x = in.readInt() - 1, y = in.readInt() - 1, z = in.readInt();
      if (z == 0) ris.join(x, y);
    }

    Counter<Integer> counter = new Counter<>();
    for (int i = 0; i < n; ++i) counter.add(ris.get(i));

    if (ris.getSetCount() == 1) {
      out.printLine(0);
      return;
    }

    long ans = IntegerUtils.power(n, k, MOD);

    for (long setCount : counter.values()) {

      ans = (ans - IntegerUtils.power(setCount, k, MOD) + MOD) % MOD;
    }

    out.printLine(ans);
  }
}
