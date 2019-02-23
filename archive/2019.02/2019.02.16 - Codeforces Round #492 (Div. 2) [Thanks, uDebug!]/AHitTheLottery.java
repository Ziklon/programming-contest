package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class AHitTheLottery {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int[] changes = {1, 5, 10, 20, 100};
    int n = in.readInt();

    int ans = 0;
    for (int i = 4; i >= 0; --i) {
      if ( n >= changes[i]) {
        ans += n / changes[i];
        n %= changes[i];
      }
    }
    out.printLine(ans);
  }
}
