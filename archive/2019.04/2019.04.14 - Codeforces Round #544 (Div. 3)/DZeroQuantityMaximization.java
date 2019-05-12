package com.darkbit.problems;

import net.egork.generated.collections.pair.IntIntPair;
import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.numbers.IntegerUtils;

import java.util.HashMap;
import java.util.Map;

public class DZeroQuantityMaximization {
  public void solve(int testNumber, InputReader in, OutputWriter out) {

    int n = in.readInt();
    int[] a = in.readIntArray(n);
    int[] b = in.readIntArray(n);

    int ans = 0;
    int maxi = 0;

    Map<IntIntPair, Integer> map = new HashMap<>();
    for (int i = 0; i < n; ++i) {
      if (a[i] == 0) {
        if (b[i] == 0) ans++;
      } else {

        int bi = b[i];
        int ai = a[i];

        if (bi < 0) {
          bi *= -1;
          ai *= -1;
        }

        if (bi == 0 && ai < 0) ai *= -1;

        int g = IntegerUtils.gcd(bi, ai);

        bi /= g;
        ai /= g;
        int val = map.getOrDefault(IntIntPair.makePair(bi, ai), 0) + 1;

        map.put(IntIntPair.makePair(bi, ai), val);

        maxi = Math.max(maxi, val);
      }
    }

    out.printLine(ans + maxi);
  }
}
