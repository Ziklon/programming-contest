package com.darkbit.problems;

import net.egork.generated.collections.pair.LongIntPair;
import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.numbers.IntegerUtils;

import java.util.List;
import java.util.Map;

public class CTrailingLovesOrLoeufs {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long n = in.readLong(), b = in.readLong();

    List<LongIntPair> factors = IntegerUtils.factorize(b);

    long ans = Long.MAX_VALUE;
    for (int i = 0; i < factors.size(); ++i) {
      LongIntPair e = factors.get(i);
      long tmp = n;
      long yi = 0;
      while (tmp > 0) {
        yi += tmp / e.first;
        tmp /= e.first;
      }
      ans = Math.min(ans, yi / e.second);
    }

    out.print(ans);
  }
}
