package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class BDivideCandies {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long n = in.readInt(), m = in.readInt();

    long ans = 0;
    long div = n / m;
    for (int i = 1; i <= m; ++i)
      for (int j = 1; j <= m; ++j) {
        long sum = (i * i) + j * j;
        int x = n % m >= i ? 1 : 0;
        int y = n % m >= j ? 1 : 0;

        if (sum % m == 0) {
          ans += (div + x) * (div + y);
        }
      }
    out.print(ans);
  }
}
