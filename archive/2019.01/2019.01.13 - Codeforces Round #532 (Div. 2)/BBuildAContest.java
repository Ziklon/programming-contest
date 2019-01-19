package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class BBuildAContest {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt(), m = in.readInt();

    StringBuilder sb = new StringBuilder();
    int counter[] = new int[n];

    int now = 0;

    for (int i = 0; i < m; ++i) {

      int current = in.readInt() - 1;
      counter[current]++;
      if (counter[current] == 1) now++;
      if (now == n) {
        sb.append('1');
        now = 0;
        for (int j = 0; j < n; ++j) {
          counter[j]--;
          if (counter[j] > 0) now++;
        }
      } else sb.append('0');
    }
    out.printLine(sb.toString());
  }
}
