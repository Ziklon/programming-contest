package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.numbers.IntegerUtils;

import java.util.HashMap;
import java.util.Map;

public class CMeaninglessOperations {
  public void solve(int testNumber, InputReader in, OutputWriter out) {

    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i <= 25; ++i) {
      int x = (1 << i) - 1;
      int ans = 1;
      for (int j = 2; j * j <= x; ++j) {
        if (x % j == 0) {
          ans = Math.max(ans, IntegerUtils.gcd(x ^ j, x & j));
          int y = x / j;
          ans = Math.max(ans, IntegerUtils.gcd(x ^ y, x & y));
        }
      }
      map.put(x, ans);
    }

    int q = in.readInt();
    for (int i = 0; i < q; ++i) {
      int n = in.readInt();
      if (map.containsKey(n)) out.printLine(map.get(n));
      else {
        out.printLine(Integer.highestOneBit(n) * 2 - 1);
      }
    }
  }
}
