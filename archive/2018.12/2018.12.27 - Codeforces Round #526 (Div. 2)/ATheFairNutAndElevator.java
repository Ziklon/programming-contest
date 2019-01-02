package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class ATheFairNutAndElevator {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt();
    int seq[] = new int[n];
    for (int i = 0; i < n; ++i) seq[i] = in.readInt();

    int ans = 0;
    for (int x = 0; x < n; ++x) {
      ans += x * 4 * seq[x];
    }
    out.printLine(ans);
  }
}
