package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class DEqualizeThemAll {
  static int MAXN = (int) (2e5 + 5);

  public void solve(int testNumber, InputReader in, OutputWriter out) {

    int n = in.readInt();
    int[] seq = in.readIntArray(n);
    int counter[] = new int[MAXN];
    int goal = 0, cnt = 0;
    for (int e : seq) {
      counter[e]++;
      if (counter[e] > cnt) {
        goal = e;
        cnt = counter[e];
      }
    }

    out.printLine(n - cnt);

    for (int i = 0; i < seq.length; ++i)
      if (seq[i] == goal) {

        for (int j = i - 1; j >= 0; j--) {
          out.printLine((seq[j] < goal ? 1 : 2), j + 1, j + 2);
        }
        for (int j = i + 1; j < n; j++) {
          if (seq[j] == goal) continue;
          out.printLine((seq[j] < goal ? 1 : 2), j + 1, j);
        }
        break;
      }
  }
}
