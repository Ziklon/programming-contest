package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class AMaximAndBiology {

  String g = "ACTG";

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt();

    String s = in.readString();

    int ans = 1 << 20;
    for (int i = 0; i + 4 <= n; ++i) {
      String t = s.substring(i, i + 4);
      int cost = 0;

      for (int j = 0; j < 4; ++j) {

        cost +=
            Math.min((g.charAt(j) - t.charAt(j) + 26) % 26, (t.charAt(j) - g.charAt(j) + 26) % 26);
      }
      ans = Math.min(ans, cost);
    }

    out.print(ans);
  }
}
