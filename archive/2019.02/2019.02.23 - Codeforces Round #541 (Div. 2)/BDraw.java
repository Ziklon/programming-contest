package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import org.omg.CORBA.MARSHAL;

public class BDraw {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt();
    long ans = 1;
    int xs[] = new int[n + 1], ys[] = new int[n + 1];
    for (int i = 0; i < n; ++i) {
      xs[i + 1] = in.readInt();
      ys[i + 1] = in.readInt();
    }

    for (int i = 0; i < n; ++i) {
      // if (i > 0 && xs[i] == xs[i - 1] && ys[i] == ys[i - 1]) continue;

      int curA = xs[i], curB = ys[i];
      int nextA = xs[i + 1], nextB = ys[i + 1];

      int minNext = Math.min(nextA, nextB);
      int maxCur = Math.max(curA, curB);
      int add = Math.min(curA, curB) < maxCur ? 1 : 0;
      ans += Math.max(0, minNext - maxCur + add);
    }

    out.printLine(ans);
  }
}
