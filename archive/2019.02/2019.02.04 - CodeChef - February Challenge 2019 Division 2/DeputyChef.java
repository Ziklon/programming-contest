package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class DeputyChef {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int t = in.readInt();
    for (int i = 0; i < t; ++i) {
      int n = in.readInt();
      int[] attacks = in.readIntArray(n);
      int[] defenses = in.readIntArray(n);

      int ans = -1;

      for (int j = 0; j < n; ++j) {

        int next = (j + 1) % n;
        int prev = (j - 1 + n) % n;

        int total = attacks[next]+ attacks[prev];
        if(total < defenses[j]){
            ans = Math.max(ans, defenses[j]);
        }
      }
      out.printLine(ans);
    }
  }
}
