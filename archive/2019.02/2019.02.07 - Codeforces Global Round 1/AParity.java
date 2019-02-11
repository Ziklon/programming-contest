package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.numbers.IntegerUtils;

public class AParity {
  public void solve(int testNumber, InputReader in, OutputWriter out) {

    int b = in.readInt(), k = in.readInt();

    int ans = 0;
    for (int i = 0; i < k; ++i) {
      ans += in.readInt() * IntegerUtils.power(b, k - i - 1, 2);
    }
    out.printLine(ans % 2 == 0 ? "even" : "odd");
  }
}
